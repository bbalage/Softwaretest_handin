CREATE SEQUENCE hibernate_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE GAME(id LONG PRIMARY KEY, title VARCHAR(80), release_year INT, genre VARCHAR(100));

CREATE TABLE CUSTOMER(id LONG PRIMARY KEY, name VARCHAR(80), address VARCHAR(100), phone_number VARCHAR(20));

CREATE TABLE PURCHASES(
    customer_id LONG,
    game_id LONG,
    FOREIGN KEY (customer_id) references CUSTOMER(id),
    foreign key (game_id) references GAME(id)
);