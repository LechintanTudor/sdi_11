DROP TABLE IF EXISTS rabbit CASCADE;
DROP TABLE IF EXISTS rabbithole CASCADE;
DROP TABLE IF EXISTS subscription CASCADE;
DROP TABLE IF EXISTS post CASCADE;

CREATE TABLE rabbit
(
    id       SERIAL PRIMARY KEY,
    username VARCHAR(60) NOT NULL UNIQUE
);

CREATE TABLE rabbithole
(
    id   SERIAL       NOT NULL PRIMARY KEY,
    name VARCHAR(120) NOT NULL UNIQUE
);

CREATE TABLE subscription
(
    rabbitid      INT NOT NULL REFERENCES rabbit (id),
    rabbitholeid INT NOT NULL REFERENCES rabbithole (id),
    PRIMARY KEY (rabbitid, rabbitholeid)
);

CREATE TABLE post
(
    id             SERIAL PRIMARY KEY,
    rabbitid      INT          NOT NULL REFERENCES rabbit (id),
    rabbitholeid INT          NOT NULL REFERENCES rabbithole (id),
    title          VARCHAR(120) NOT NULL,
    content        TEXT         NOT NULL
);
