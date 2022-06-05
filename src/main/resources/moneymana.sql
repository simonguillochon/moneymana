DROP SCHEMA moneymana;
CREATE SCHEMA IF NOT EXISTS moneymana;
GRANT ALL ON SCHEMA moneymana TO moneymana;

CREATE TYPE ShareType AS ENUM ('CRYPTO', 'MARKET');

CREATE TABLE company (
    id INTEGER NOT NULL PRIMARY KEY,
    name VARCHAR(100) UNIQUE,
    description VARCHAR(100)
);
CREATE TABLE order (
    id INTEGER NOT NULL PRIMARY KEY,
    type BOOLEAN NOT NULL,
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);
CREATE TABLE shares (
    id INTEGER NOT NULL PRIMARY KEY,
    slug VARCHAR(10) UNIQUE NOT NULL,
    shareType ShareType NOT NULL
);
CREATE TABLE user (
    id INTEGER NOT NULL PRIMARY KEY,
    username VARCHAR(100) UNIQUE NOT NULL
);
CREATE TABLE wallet (
    id INTEGER NOT NULL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    link VARCHAR(200)
);

-- CREATE TABLE known_fruits(
--     ID INTEGER NOT NULL PRIMARY KEY,
--     NAME VARCHAR(40) UNIQUE
-- );

-- INSERT INTO known_fruits(id, name) VALUES (1, 'Cherry');
-- INSERT INTO known_fruits(id, name) VALUES (2, 'Apple');
-- INSERT INTO known_fruits(id, name) VALUES (3, 'Banana');
