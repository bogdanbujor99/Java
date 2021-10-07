DROP TABLE movie;
DROP TABLE genres;
DROP TABLE junction;
DROP TABLE actors;
DROP TABLE directors;

CREATE TABLE movie (
id INTEGER PRIMARY KEY AUTOINCREMENT,
title VARCHAR(25) unique NOT NULL,
release_date DATE,
duration NUMBER(3),
score DOUBLE
);

CREATE TABLE genres (
id INTEGER PRIMARY KEY AUTOINCREMENT,
name VARCHAR(25) unique NOT NULL
); 

CREATE TABLE junction (
id_movie INTEGER references movie(id),
id_genres INTEGER references genres(id)
);

CREATE TABLE actors(
name VARCHAR(25) NOT NULL,
title_movie VARCHAR(25) references movie(title)
);

CREATE TABLE directors(
name VARCHAR(25) NOT NULL,
title_movie references movie(title)
);