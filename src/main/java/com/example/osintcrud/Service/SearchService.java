package com.example.osintcrud.Service; // 1. ИСПРАВЛЕНИЕ: Удалена лишняя точка в конце

import org.springframework.stereotype.Service;

import com.example.osintcrud.Model.UserEntity; // Импорт Model
import com.example.osintcrud.Repository.UserRepository; // Импорт Repository

import java.util.List;
import java.util.regex.Pattern; // Добавлен импорт для более чистого использования Pattern

@Service
public class SearchService { // Начало класса SearchService

    private final UserRepository userRepository;

    // Внедрение зависимости (DI) через конструктор
    public SearchService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Выполняет поиск пользователя по типу запроса.
     * Отвечает ТОЛЬКО за бизнес-логику и возвращает чистые Entity.
     * Всю логику формирования ответа (Map) и ловли ошибок мы убрали в Controller/ExceptionHandler.
     */
    public List<UserEntity> search(String query) throws IllegalArgumentException {

        // УДАЛЕН код создания Map<String, Object> response = new HashMap<>(); (Это нарушение SRP)
        List<UserEntity> results;

        switch (detectType(query)) {
            // ВАЖНО: Если данные не число, NumberFormatException будет брошено Integer.parseInt.
            // Эту ошибку поймает наш GlobalExceptionHandler (400 Bad Request).
            case "EMAIL" -> results = userRepository.findByEmail(query);
            case "FULLNAME" -> results = userRepository.findByFullnameContainingIgnoreCase(query);
            case "NUMBER" -> results = userRepository.findByNumber(Integer.parseInt(query));
            case "PASSPORT" -> results = userRepository.findByPasport(Integer.parseInt(query));

            // Если detectType вернул что-то, что не обрабатывается:
            default -> throw new IllegalArgumentException("Неизвестный тип запроса или некорректный формат: " + query);
        }

        // УДАЛЕН код response.put("status", "ok"); и т.д. (Это нарушение SRP)

        return results;
    } // 2. ИСПРАВЛЕНИЕ: Это закрывающая скобка только для метода search


    /**
     * Определяет тип запроса.
     */
    private String detectType(String query) {
        query = query.trim();

        if (query.contains("@")) {
            return "EMAIL";
        }

        // Паттерн для IPv4
        if (query.matches("\\d{1,3}(\\.\\d{1,3}){3}")) {
            return "IP";
        }

        // Паттерн для номера телефона (+ или 10-15 цифр)
        if (query.matches("\\+?\\d{10,15}")) {
            return "PHONE";
        }

        // Паттерн для паспорта (например: AB123456)
        // ВАЖНО: В вашем репозитории findByPasport принимает int.
        // Если паспорт - это String (буквы+цифры), то нужно изменить Repository.
        // Здесь мы предполагаем, что вы ищете по целым числам.
        if (query.matches("\\d{6,10}")) { // Предполагаем 6-10 цифр как NUMBER или PASPORT
            // Если в базе 'number' и 'pasport' - int, то запрос должен быть числом.
            // Если это именно PASPORT (со строками), нужна другая логика.
            try {
                // Если парсится как число, то это NUMBER или PASPORT (в зависимости от длины)
                Integer.parseInt(query);
                return "PASPORT"; // Или NUMBER, если вы хотите их разделить по логике.
            } catch (NumberFormatException e) {
                // Не число, пропускаем
            }
        }

        // Паттерн для ФИО (Слово с большой буквы, пробел, Слово с большой буквы)
        if (query.matches("[А-ЯЁA-Z][а-яёa-z]+\\s+[А-ЯЁA-Z][а-яёa-z]+")) {
            return "FULLNAME";
        }

        // Если не попадает ни в один тип, ищем как текст (или выбрасываем ошибку)
        // В вашем коде он падал на этом, теперь бросим ошибку явно.
        throw new IllegalArgumentException("Неизвестный тип запроса или не поддерживается.");
    }
} // 3. ИСПРАВЛЕНИЕ: Это закрывающая скобка для класса SearchService