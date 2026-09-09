CREATE TABLE games (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255),
    release_year INTEGER,
    rating NUMERIC(3,1)
);

CREATE TABLE genres (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE platforms (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE games_genres (
    game_id INTEGER REFERENCES games(id),
    genre_id INTEGER REFERENCES genres(id)
);

CREATE TABLE games_platforms (
    game_id INTEGER REFERENCES games(id),
    platform_id INTEGER REFERENCES platforms(id)
);