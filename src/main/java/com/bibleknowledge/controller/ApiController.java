package com.bibleknowledge.controller;

import com.bibleknowledge.model.*;
import com.bibleknowledge.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ApiController {

    @Autowired private TopicRepository topicRepo;
    @Autowired private InsightRepository insightRepo;
    @Autowired private SourceRepository sourceRepo;
    @Autowired private VerseRepository verseRepo;

    // ── Topics ──────────────────────────────────────────────
    @GetMapping("/topics")
    public List<Topic> getAllTopics() {
        return topicRepo.findAll();
    }

    @GetMapping("/topics/{id}")
    public ResponseEntity<Topic> getTopic(@PathVariable Long id) {
        return topicRepo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/topics")
    public Topic createTopic(@RequestBody Topic topic) {
        return topicRepo.save(topic);
    }

    @DeleteMapping("/topics/{id}")
    public ResponseEntity<Void> deleteTopic(@PathVariable Long id) {
        topicRepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // ── Insights ─────────────────────────────────────────────
    @GetMapping("/insights")
    public List<Insight> getAllInsights() {
        return insightRepo.findAll();
    }

    @GetMapping("/insights/topic/{topicId}")
    public List<Insight> getInsightsByTopic(@PathVariable Long topicId) {
        return insightRepo.findByTopicId(topicId);
    }

    @GetMapping("/insights/search")
    public List<Insight> searchInsights(@RequestParam String q) {
        return insightRepo.searchByText(q);
    }

    @PostMapping("/insights")
    public Insight createInsight(@RequestBody Insight insight) {
        return insightRepo.save(insight);
    }

    @DeleteMapping("/insights/{id}")
    public ResponseEntity<Void> deleteInsight(@PathVariable Long id) {
        insightRepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // ── Sources ──────────────────────────────────────────────
    @GetMapping("/sources")
    public List<Source> getAllSources() {
        return sourceRepo.findAll();
    }

    @PostMapping("/sources")
    public Source createSource(@RequestBody Source source) {
        return sourceRepo.save(source);
    }

    @DeleteMapping("/sources/{id}")
    public ResponseEntity<Void> deleteSource(@PathVariable Long id) {
        sourceRepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // ── Verses ───────────────────────────────────────────────
    @GetMapping("/verses")
    public List<Verse> getAllVerses() {
        return verseRepo.findAll();
    }

    @PostMapping("/verses")
    public Verse createVerse(@RequestBody Verse verse) {
        return verseRepo.save(verse);
    }
}
