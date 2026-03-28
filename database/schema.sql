-- Bible Knowledge Base Schema
-- (Spring Boot + JPA auto-creates these tables. This file is for reference.)

CREATE TABLE IF NOT EXISTS sources (
    id            INTEGER PRIMARY KEY AUTOINCREMENT,
    title         TEXT NOT NULL,
    url           TEXT,
    type          TEXT CHECK(type IN ('video','article','book','podcast','sermon')),
    author        TEXT,
    date_accessed TEXT
);

CREATE TABLE IF NOT EXISTS topics (
    id          INTEGER PRIMARY KEY AUTOINCREMENT,
    name        TEXT NOT NULL UNIQUE,
    description TEXT
);

CREATE TABLE IF NOT EXISTS verses (
    id          INTEGER PRIMARY KEY AUTOINCREMENT,
    book        TEXT NOT NULL,
    chapter     INTEGER NOT NULL,
    verse_start INTEGER NOT NULL,
    verse_end   INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS insights (
    id               INTEGER PRIMARY KEY AUTOINCREMENT,
    content          TEXT NOT NULL,
    your_commentary  TEXT,
    source_id        INTEGER REFERENCES sources(id),
    topic_id         INTEGER REFERENCES topics(id)
);

CREATE TABLE IF NOT EXISTS insight_verses (
    insight_id INTEGER REFERENCES insights(id),
    verse_id   INTEGER REFERENCES verses(id),
    PRIMARY KEY (insight_id, verse_id)
);
