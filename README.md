#room_reservations_system

Учебный проект — REST API для управления бронированиями номеров в отеле.  
Реализована базовая бизнес-логика: создание, обновление, отмена и подтверждение броней, проверка пересечений дат для одной комнаты, статусная модель (`PENDING` → `APPROVED` / `CANCELED`).

## Технологический стек

- **Java 21**
- **Spring Boot 3** (Web, Data JPA, Validation)
- **PostgreSQL** (основная БД)
- **Hibernate** (ORM)
- **Docker** (контейнеризация PostgreSQL)
- **Gradle** (сборка)
- **Postman** (тестирование API)

## Функциональные возможности

- `GET    /reservation/{id}`      – получить бронь по ID  
- `GET    /reservation`           – получить список всех броней  
- `POST   /reservation`           – создать новую бронь (статус `PENDING`)  
- `PUT    /reservation/{id}`      – обновить существующую бронь (только для `PENDING`)  
- `DELETE /reservation/{id}/cancel` – отменить бронь (статус `CANCELED`)  
- `PUT    /reservation/{id}/approve` – подтвердить бронь (проверка конфликтов дат)

### Детали бизнес-логики

- При создании / обновлении проверяется, что `endDate` позже `startDate`.
- Изменить или отменить можно только бронь со статусом `PENDING`.
- Подтвердить (`APPROVED`) можно только `PENDING` бронь, если для указанной комнаты нет пересечений по датам с другими уже подтверждёнными бронями.
- Отменить подтверждённую бронь (`APPROVED`) нельзя – требуется обращение к менеджеру.

## Запуск проекта

### 1. Клонирование репозитория
```bash
git clone https://github.com/MeTaLdiCODING/hotel-booking-api.git
cd hotel-booking-api

2. Настроить подключение (application.properties)
properties
spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
spring.datasource.password=pass

3. Запустить приложение
bash
./gradlew bootRun
