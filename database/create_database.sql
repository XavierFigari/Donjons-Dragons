CREATE DATABASE postgres;

\c postgres;

CREATE SCHEMA dd;

CREATE TYPE dd.person_type AS ENUM (
    'Warrior',
    'Wizard'
    );


CREATE TABLE dd.heroes
(
    id       SERIAL PRIMARY KEY,
    name     VARCHAR(255) NOT NULL,
    type     dd.person_type NOT NULL,
    life     INT,
    strength INT,
    weapon   VARCHAR(255)
);