-- Добавление полей Person в таблицу creator_monument
ALTER TABLE creator_monument 
ADD COLUMN age INTEGER,
ADD COLUMN place_of_birth VARCHAR(255),
ADD COLUMN nationality VARCHAR(100),
ADD COLUMN gender VARCHAR(20);
