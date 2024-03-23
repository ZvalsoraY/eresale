
DROP TABLE IF EXISTS UsersRoles;
DROP TABLE IF EXISTS Roles;
DROP TABLE IF EXISTS USERS;
DROP TABLE IF EXISTS PRODUCTS;
DROP TABLE IF EXISTS SELLERS;
DROP TABLE IF EXISTS DEALS;
DROP TABLE IF EXISTS BUYERS;


DROP TABLE IF EXISTS USERS;
CREATE TABLE USERS(
    ID BIGSERIAL NOT NULL PRIMARY KEY,
    NAME VARCHAR(255),
    PATRONYMIC VARCHAR(255),
    SURNAME VARCHAR(255),
    BIRTHDAY DATE,
    PHONENUMBER VARCHAR(255),
    STATUS VARCHAR(255),
    PASS VARCHAR(255)
);

DROP TABLE IF EXISTS PRODUCTS;
CREATE TABLE PRODUCTS(
    ID BIGSERIAL NOT NULL PRIMARY KEY,
    USER_ID BIGINT,
    TITLE VARCHAR(255),
    DESCRIPTION VARCHAR(255),
    DATEPLACED DATE,
    PRICE DECIMAL(10,2),
    CURRENCY VARCHAR(255)
);

DROP TABLE IF EXISTS SELLERS;
CREATE TABLE SELLERS(
    ID BIGSERIAL NOT NULL PRIMARY KEY,
    USER_ID BIGINT,
    BRANDNAME VARCHAR(255),
    ADDITIONALPHONE VARCHAR(255)
);

DROP TABLE IF EXISTS DEALS;
CREATE TABLE DEALS(
    ID BIGSERIAL NOT NULL PRIMARY KEY,
    SELLERUSER_ID BIGINT,
    BUYERUSER_ID BIGINT,
    PRODUCT_ID BIGINT,
    DEALDATE DATE,
    DEALPRICE DECIMAL(10,2),
    CURRENCY VARCHAR(255)
);

DROP TABLE IF EXISTS BUYERS;
CREATE TABLE BUYERS(
    ID BIGSERIAL NOT NULL PRIMARY KEY,
    USER_ID BIGINT,
    ADDITIONALPHONE VARCHAR(255)
);