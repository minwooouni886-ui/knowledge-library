package com.bibleknowledge.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "sources")
public class Source {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String url;
    private String type; // "video", "article", "book", "podcast", "sermon"
    private String author;

    @Column(name = "date_accessed")
    private String dateAccessed;

    @OneToMany(mappedBy = "source", cascade = CascadeType.ALL)
    private List<Insight> insights;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getDateAccessed() { return dateAccessed; }
    public void setDateAccessed(String dateAccessed) { this.dateAccessed = dateAccessed; }

    public List<Insight> getInsights() { return insights; }
    public void setInsights(List<Insight> insights) { this.insights = insights; }
}
