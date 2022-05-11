DROP TABLE IF EXISTS rabbit CASCADE;
DROP TABLE IF EXISTS rabbit_hole CASCADE;
DROP TABLE IF EXISTS subscription CASCADE;
DROP TABLE IF EXISTS post CASCADE;

CREATE TABLE rabbit
(
    id       SERIAL PRIMARY KEY,
    username VARCHAR(60) NOT NULL UNIQUE
);

CREATE TABLE rabbit_hole
(
    id   SERIAL       NOT NULL PRIMARY KEY,
    name VARCHAR(120) NOT NULL UNIQUE
);

CREATE TABLE subscription
(
    rabbit_id      INT NOT NULL REFERENCES rabbit (id),
    rabbit_hole_id INT NOT NULL REFERENCES rabbit_hole (id),
    PRIMARY KEY (rabbit_id, rabbit_hole_id)
);

CREATE TABLE post
(
    id             SERIAL PRIMARY KEY,
    rabbit_id      INT          NOT NULL REFERENCES rabbit (id),
    rabbit_hole_id INT          NOT NULL REFERENCES rabbit_hole (id),
    title          VARCHAR(120) NOT NULL,
    content        TEXT         NOT NULL
);
