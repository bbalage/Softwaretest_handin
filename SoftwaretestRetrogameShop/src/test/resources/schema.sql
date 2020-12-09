CREATE SEQUENCE hibernate_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE game(id LONG PRIMARY KEY, title VARCHAR(80), release_year INT, genre VARCHAR(100), price INT);

CREATE TABLE customer(id LONG PRIMARY KEY, name VARCHAR(80), address VARCHAR(100), phone_number VARCHAR(20));

CREATE TABLE purchases(
    customer_id LONG,
    game_id LONG,
    FOREIGN KEY (customer_id) references customer(id),
    foreign key (game_id) references game(id)
);