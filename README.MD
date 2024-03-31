Площадка для перепродаж

Администратор может добавлять и удалять пользователей.

Пользователи могут выставлять товар на продажу и приобретать товар.
(приобретение товара не реализовано).

Интеграция с курсом валют ЦБ, по ендпоинту /getCourse можно получить курс всех валют,
реализовано с использованием xsd схемы.

# Запуск
Скачать проект из репозитория.

Загрузить зависимости maven.

создать базу данных postgresFinal в postgresql по schema.sql, добавить данные из data.sql.

в application.properties заменить на свои данные пользователя postgresql

spring.datasource.username=postgres

spring.datasource.password=1234

spring.datasource.url=jdbc:postgresql://localhost:5432/postgresFinal

запустить EresaleApplication.java

открыть в браузере localhost:8080/login


