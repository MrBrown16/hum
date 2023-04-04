CREATE DATABASE hum
CHARACTER SET utf8
COLLATE utf8_hungarian_ci;

USE hum;

CREATE TABLE employees (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    city VARCHAR(50),
    salary DOUBLE
);

GRANT ALL PRIVILEGES
ON hum.*
TO hum@localhost
IDENTIFIED BY 'titok';

