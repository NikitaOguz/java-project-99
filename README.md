### Hexlet tests and linter status:
[![Actions Status](https://github.com/NikitaOguz/java-project-99/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/NikitaOguz/java-project-99/actions)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=NikitaOguz_java-project-99&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=NikitaOguz_java-project-99)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=NikitaOguz_java-project-99&metric=bugs)](https://sonarcloud.io/summary/new_code?id=NikitaOguz_java-project-99)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=NikitaOguz_java-project-99&metric=coverage)](https://sonarcloud.io/summary/new_code?id=NikitaOguz_java-project-99)

# Менеджер задач

Учебный проект — backend-часть менеджера задач (Task Manager).

## О проекте

Приложение представляет собой REST API для управления задачами с возможностью регистрации и авторизации пользователей. 

### Основные возможности
- Создание, просмотр, редактирование и удаление задач
- Назначение задач исполнителям
- Фильтрация и поиск задач
- Управление статусами и метками задач
- Авторизация и разграничение прав доступа

## Технологии и инструменты

**Backend:**
- **Java 21**
- **Spring Boot**
- **Spring Data JPA**
- **Spring Security** (с JWT-аутентификацией)
- **Hibernate**

**Базы данных:**
- **H2** — для локальной разработки и тестов
- **PostgreSQL** — в продакшен-окружении

## Доступ к приложению

Проект задеплоен и доступен по ссылке: **[→ Открыть приложение](https://java-project-99-g09l.onrender.com)**

**Тестовая учётная запись:**
- **Email:** `hexlet@example.com`
- **Пароль:** `qwerty`

## Полезные ссылки

- [OpenAPI спецификация (Swagger UI)](https://your-app.onrender.com/swagger-ui.html)
- [Вызвать тестовую ошибку (Sentry)](https://your-app.onrender.com/sentry-test)

---

## Быстрый старт

1. Клонируйте репозиторий:

   ```bash
   git clone https://github.com/ArturStimbiris/java-project-99.git
   cd java-project-99
2. Запустите приложение:
```bash
./gradlew bootRun
```
3. Приложение будет доступно по адресу:
```bash
http://localhost:8080
```
API

Аутентификация

POST /api/login — Авторизация пользователя

Пользователи

GET /api/users — Получить список пользователей
POST /api/users — Создать нового пользователя
GET /api/users/{id} — Получить пользователя по ID

Задачи

GET /api/tasks — Получить список задач (с фильтрами)
GET /api/tasks/{id} — Получить задачу по ID
POST /api/tasks — Создать новую задачу
PUT /api/tasks/{id} — Обновить задачу
DELETE /api/tasks/{id} — Удалить задачу

Справочники

GET /api/task_statuses — Получить список статусов
POST /api/task_statuses — Создать статус
GET /api/labels — Получить список меток
POST /api/labels — Создать метку
