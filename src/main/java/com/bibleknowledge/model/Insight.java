package com.bibleknowledge.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "insights")
public class Insight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(name = "your_commentary", columnDefinition = "TEXT")
    private String yourCommentary;

    @ManyToOne
    @JoinColumn(name = "source_id")
    private Source source;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;

    @ManyToMany
    @JoinTable(
        name = "insight_verses",
        joinColumns = @JoinColumn(name = "insight_id"),
        inverseJoinColumns = @JoinColumn(name = "verse_id")
    )
    private List<Verse> verses;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getYourCommentary() { return yourCommentary; }
    public void setYourCommentary(String yourCommentary) { this.yourCommentary = yourCommentary; }

    public Source getSource() { return source; }
    public void setSource(Source source) { this.source = source; }

    public Topic getTopic() { return topic; }
    public void setTopic(Topic topic) { this.topic = topic; }

    public List<Verse> getVerses() { return verses; }
    public void setVerses(List<Verse> verses) { this.verses = verses; }
}
