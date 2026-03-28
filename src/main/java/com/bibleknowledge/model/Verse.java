package com.bibleknowledge.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "verses")
public class Verse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String book;
    private int chapter;

    @Column(name = "verse_start")
    private int verseStart;

    @Column(name = "verse_end")
    private int verseEnd;

    @ManyToMany(mappedBy = "verses")
    private List<Insight> insights;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getBook() { return book; }
    public void setBook(String book) { this.book = book; }

    public int getChapter() { return chapter; }
    public void setChapter(int chapter) { this.chapter = chapter; }

    public int getVerseStart() { return verseStart; }
    public void setVerseStart(int verseStart) { this.verseStart = verseStart; }

    public int getVerseEnd() { return verseEnd; }
    public void setVerseEnd(int verseEnd) { this.verseEnd = verseEnd; }

    public List<Insight> getInsights() { return insights; }
    public void setInsights(List<Insight> insights) { this.insights = insights; }

    public String getReference() {
        if (verseStart == verseEnd) {
            return book + " " + chapter + ":" + verseStart;
        }
        return book + " " + chapter + ":" + verseStart + "-" + verseEnd;
    }
}
