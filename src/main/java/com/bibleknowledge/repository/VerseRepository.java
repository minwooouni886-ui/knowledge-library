package com.bibleknowledge.repository;

import com.bibleknowledge.model.Verse;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VerseRepository extends JpaRepository<Verse, Long> {
    List<Verse> findByBook(String book);
    List<Verse> findByBookAndChapter(String book, int chapter);
}
