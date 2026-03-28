package com.bibleknowledge.repository;

import com.bibleknowledge.model.Source;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SourceRepository extends JpaRepository<Source, Long> {
    List<Source> findByType(String type);
    List<Source> findByTitleContainingIgnoreCase(String title);
}
