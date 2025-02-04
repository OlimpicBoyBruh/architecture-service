# Archirecture-service

## Инструкция по запуску

- Для запуска необходимо запустить файл compose.yaml командой из терминала - "docker-compose up", он поднимает БД в контейнере.
- После нужно запустить main класс - AppArchitecture
- Для проверки работоспособности, необходимо перейти по url http://localhost:9090/swagger 


## Описание

Микросервис archirecture-service предоставляет API для сохранения сведений о памятниках истории и архитектуры

## Технологии
- swagger
- Java 17
- Spring 3.2
- Flyway migration
- Postgresql
- Docker
- Apache Maven

## DataBase entity

- CreatorMonument - хранит информацию о создателе
- Monument - содержит информацию о памятнике
- MonumentExpertEvaluation - экспертная оценка о состояние памятника
- Region - содержит информацию о регионе, в котором находиться памятник

## API Методы

### Сохранение информации в реляционную базу данных

POST: http://localhost:9090/architecture/save

Этот метод позволяет сохранить информацию о памятнике.

#### Логика работы:

- По API приходит MonumentDto в ArchitectureController, метод saveArchitecture
- На основе MonumentDto создаётся сущность Monument и сохраняется в БД.
- Информация о регионе, создателе и экспертной оценки достается из monumentDto и сохраняет в Бд используя транзакцию,

### Получения информации о всех памятниках, хранимых в БД

GET: http://localhost:9090/architecture/get

Этот метод позволяет выбрать все записи из базы данных, достаются все связанные сущности.

#### Логика работы:

- По API приходит запрос в ArchitectureController, метод getArchitecture
- Делает запрос в таблицу MonumentЮ достаются все связанные сущности, в дальнейшем происходит сериализация в формат JSON и вкладывает в body http Response.