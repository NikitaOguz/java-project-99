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

## Технологии

### Backend

- Java 25
- Spring Boot
- Spring Data JPA
- Spring Security (JWT)
- Hibernate

### Базы данных

- H2 — локальная разработка и тестирование
- PostgreSQL — production

## Доступ к приложению

Проект задеплоен на Render:

https://java-project-99-g09l.onrender.com

### Тестовая учетная запись

| Поле | Значение |
|------|----------|
| Email | `hexlet@example.com` |
| Пароль | `qwerty` |

## Полезные ссылки

- Swagger UI: https://java-project-99-g09l.onrender.com/swagger-ui.html
- Sentry test: https://java-project-99-g09l.onrender.com/sentry-test

## Быстрый старт

### Клонирование

```bash
git clone https://github.com/NikitaOguz/java-project-99.git
cd java-project-99
```

### Запуск

```bash
./gradlew bootRun
```

После запуска приложение будет доступно по адресу:

```
http://localhost:8080
```

## API

### Аутентификация

| Метод | Endpoint | Описание |
|--------|----------|----------|
| POST | `/api/login` | Авторизация пользователя |

### Пользователи

| Метод | Endpoint | Описание |
|--------|----------|----------|
| GET | `/api/users` | Получить список пользователей |
| POST | `/api/users` | Создать пользователя |
| GET | `/api/users/{id}` | Получить пользователя по ID |

### Задачи

| Метод | Endpoint | Описание |
|--------|----------|----------|
| GET | `/api/tasks` | Получить список задач |
| GET | `/api/tasks/{id}` | Получить задачу по ID |
| POST | `/api/tasks` | Создать задачу |
| PUT | `/api/tasks/{id}` | Обновить задачу |
| DELETE | `/api/tasks/{id}` | Удалить задачу |

### Статусы

| Метод | Endpoint | Описание |
|--------|----------|----------|
| GET | `/api/task_statuses` | Получить список статусов |
| POST | `/api/task_statuses` | Создать статус |

### Метки

| Метод | Endpoint | Описание |
|--------|----------|----------|
| GET | `/api/labels` | Получить список меток |
| POST | `/api/labels` | Создать метку |
