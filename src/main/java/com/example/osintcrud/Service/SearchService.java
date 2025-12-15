package com.example.osintcrud.Service; // 1. ИСПРАВЛЕНИЕ: Удалена лишняя точка в конце

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import com.example.osintcrud.Searchtype;
import com.example.osintcrud.Entity.UserEntity; // Импорт Model
import com.example.osintcrud.Repository.UserRepository; // Импорт Repository



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
        Searchtype type = detectType(query);
        List <SearchPattern> results;


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



    private Searchtype detectType(String query) {
        query = query.trim();
        record SearchPattern(String regex, Searchtype pattern) {
            List<SearchPattern> results = List.of(
                    new SearchPattern("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$", Searchtype.FULLNAME
                    ),


            new SearchPattern("\\d{1,3}(\\.\\d{1,3}){3}", Searchtype.IP),
                    new SearchPattern("\\+?\\d{10,15}", Searchtype.PHONE),

        );
        }

    }

} // 3. ИСПРАВЛЕНИЕ: Это закрывающая скобка для класса SearchService