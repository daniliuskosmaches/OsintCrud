# OsintCrud

Version: 25
License: MIT

---

ENGLISH
=======

Project overview
----------------
OsintCrud is a simple Java library/CLI for performing local CRUD operations and sending search queries to a test database. This project does not expose a REST API or web server — it provides in-process methods and an optional command-line entrypoint for working with test data.

Key features
------------
- Create / Read / Update / Delete records in a test database
- Simple local search queries (method calls or CLI)
- Minimal dependencies, JDBC-based database access
- Easy configuration via properties file

Requirements
------------
- Java 25 (JDK)
- A JDBC-compatible test database (H2, SQLite, PostgreSQL, MySQL, etc.)
- Optional: Maven or Gradle if you prefer a build tool

Configuration
-------------
Create a file named config.properties (or provide equivalent runtime settings):

```
db.url=jdbc:h2:~/osintcrud-test
db.user=sa
db.password=
# jdbc.driver (optional)
```

Adjust the URL and credentials to match your test database.

Build & Run
-----------
If using Maven:

- mvn clean package
- java -jar target/osintcrud-<version>.jar

If using Gradle:

- ./gradlew build
- java -jar build/libs/osintcrud-<version>.jar

Without a build tool (simple compile/run):

- javac -d out $(find src -name "*.java")
- java -cp out com.yourpackage.Main

Replace com.yourpackage.Main with the actual fully-qualified main class.

Usage examples
--------------
CLI (if provided/implemented):

- java -jar osintcrud.jar search --q "keyword"
- java -jar osintcrud.jar create --name "Example" --value "Data"

Programmatic usage (example):

```java
// Example usage (adapt to your package names)
Config config = Config.fromProperties("config.properties");
DbClient client = new DbClient(config);
List<Record> results = client.search("keyword");
client.create(new Record("name", "value"));
client.update(1, updatedRecord);
client.delete(1);
```

Notes
-----
- This project is intended for local/testing use and simple OSINT-style search queries against a test DB.
- There are no network-exposed APIs in this repository by design.

Project layout (suggested)
-------------------------
- src/                — Java source files
- src/main/resources  — configuration templates (config.properties)
- docs/               — additional documentation and examples
- LICENSE             — MIT license

Contributing
------------
1. Fork the repository
2. Create a feature branch: git checkout -b feature/my-change
3. Make changes and commit them
4. Open a pull request with a clear description

License
-------
This project is licensed under the MIT License. See LICENSE for details.

Contact
-------
Author: daniliuskosmaches

---

РУССКИЙ
=======

Обзор проекта
-------------
OsintCrud — простой Java-проект (библиотека и/или CLI) для локальных CRUD-операций и отправки поисковых запросов в тестовую базу данных. REST API и веб-сервер не используются — проект предоставляет методы в процессе выполнения и при необходимости точку входа в виде CLI.

Возможности
-----------
- Создание / Чтение / Обновление / Удаление записей в тестовой БД
- Простые поисковые запросы (вызовы методов или CLI)
- Минимум зависимостей, доступ к БД через JDBC
- Простая конфигурация через properties-файл

Требования
----------
- Java 25 (JDK)
- JDBC-совместимая тестовая БД (H2, SQLite, PostgreSQL, MySQL и т.д.)
- Опционально: Maven или Gradle при использовании сборщика

Настройка
--------
Создайте файл config.properties (или передайте эквивалентные настройки при запуске):

```
db.url=jdbc:h2:~/osintcrud-test
db.user=sa
db.password=
# jdbc.driver (опционально)
```

Измените URL и учётные данные под вашу тестовую базу.

Сборка и запуск
----------------
С Maven:

- mvn clean package
- java -jar target/osintcrud-<version>.jar

С Gradle:

- ./gradlew build
- java -jar build/libs/osintcrud-<version>.jar

Без сборщика:

- javac -d out $(find src -name "*.java")
- java -cp out com.yourpackage.Main

Замените com.yourpackage.Main на реальный главный класс с полным именем.

Примеры использования
---------------------
CLI (если реализовано):

- java -jar osintcrud.jar search --q "ключевое слово"
- java -jar osintcrud.jar create --name "Пример" --value "Данные"

Использование из кода (пример):

```java
// Пример использования (адаптируйте под свои пакеты)
Config config = Config.fromProperties("config.properties");
DbClient client = new DbClient(config);
List<Record> results = client.search("ключевое слово");
client.create(new Record("name", "value"));
client.update(1, updatedRecord);
client.delete(1);
```

Примечания
---------
- Проект рассчитан на локальное/тестовое использование и простые OSINT-поисковые запросы к тестовой БД.
- В репозитории нет сетевых API по замыслу.

Структура проекта (рекомендуется)
--------------------------------
- src/                — исходники Java
- src/main/resources  — шаблоны конфигураций (config.properties)
- docs/               — документация и примеры
- LICENSE             — лицензия MIT

Как внести вклад
----------------
1. Форкните репозиторий
2. Создайте ветку: git checkout -b feature/my-change
3. Внесите изменения и закоммитьте
4. Откройте pull request с описанием изменений

Лицензия
--------
Проект распространяется под лицензией MIT. Подробности в файле LICENSE.

Контакты
--------
Автор: daniliuskosmaches
