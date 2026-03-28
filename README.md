# 📖 Bible Knowledge Base

A personal knowledge base for insights learned about the Bible — from YouTube videos, articles, books, sermons, podcasts, and more. Built as a full-stack web application with **Java (Spring Boot)**, **SQLite**, and a clean web frontend.

> This project serves two purposes: a spiritual resource for others to learn from, and a portfolio demonstration of relational database design and REST API development.

---

## ✨ Features

- Browse insights organized by **topic** (Grace, Faith, Prayer, etc.)
- Each insight links to its **source** (video, article, book, sermon, podcast) and relevant **Bible verses**
- Full-text **search** across all insights and commentary
- Add new **topics**, **insights**, and **sources** through the UI
- Clean, readable web interface

---

## 🛠 Tech Stack

| Layer | Technology |
|---|---|
| Backend | Java 17 + Spring Boot 3 |
| Database | SQLite (via Spring Data JPA) |
| Frontend | HTML / CSS / Vanilla JavaScript |
| Build tool | Maven |

---

## 🗄 Database Schema

```
sources        — where the insight came from (YouTube, article, book…)
topics         — biblical themes (Grace, Faith, Prayer…)
verses         — Bible references (book, chapter, verse range)
insights       — key takeaways, with personal commentary
insight_verses — many-to-many: links insights to Bible verses
```

See [`database/schema.sql`](database/schema.sql) for full table definitions.

---

## 🚀 Running Locally

**Prerequisites:** Java 17+, Maven

```bash
# Clone the repo
git clone https://github.com/YOUR_USERNAME/bible-knowledge-base.git
cd bible-knowledge-base

# Run the app
mvn spring-boot:run
```

Then open your browser at **http://localhost:8080**

The SQLite database file is created automatically at `database/bible_kb.db` on first run, with some sample data pre-loaded.

---

## 📡 REST API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/topics` | List all topics |
| POST | `/api/topics` | Create a new topic |
| DELETE | `/api/topics/{id}` | Delete a topic |
| GET | `/api/insights` | List all insights |
| GET | `/api/insights/topic/{id}` | Insights by topic |
| GET | `/api/insights/search?q=...` | Full-text search |
| POST | `/api/insights` | Create a new insight |
| DELETE | `/api/insights/{id}` | Delete an insight |
| GET | `/api/sources` | List all sources |
| POST | `/api/sources` | Add a new source |
| GET | `/api/verses` | List all verses |
| POST | `/api/verses` | Add a verse reference |

---

## 🙏 Purpose

This project was created for two reasons:

1. **Spiritual**: To share what I've learned studying the Bible through various resources, so others can benefit from these insights.
2. **Professional**: To demonstrate skills in relational database design, REST API development, and full-stack Java development.

---

## 📄 License

Content (insights, commentary) is shared under [Creative Commons CC BY 4.0](https://creativecommons.org/licenses/by/4.0/).
Code is under the [MIT License](LICENSE).
