package com.bibleknowledge.repository;

import com.bibleknowledge.model.Insight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface InsightRepository extends JpaRepository<Insight, Long> {

    List<Insight> findByTopicId(Long topicId);

    List<Insight> findBySourceId(Long sourceId);

    @Query("SELECT i FROM Insight i WHERE " +
           "LOWER(i.content) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
           "LOWER(i.yourCommentary) LIKE LOWER(CONCAT('%', :query, '%'))")
    List<Insight> searchByText(@Param("query") String query);
}
