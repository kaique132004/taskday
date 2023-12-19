CREATE TABLE users (
    id varchar(255) PRIMARY KEY UNIQUE NOT NULL,
    login varchar(255) NOT NULL UNIQUE,
    password varchar(255) NOT NULL,
    role varchar(255) NOT NULL
);