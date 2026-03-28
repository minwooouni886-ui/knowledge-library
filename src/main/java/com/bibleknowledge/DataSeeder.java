package com.bibleknowledge;

import com.bibleknowledge.model.*;
import com.bibleknowledge.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner seedData(
            TopicRepository topicRepo,
            SourceRepository sourceRepo,
            VerseRepository verseRepo,
            InsightRepository insightRepo
    ) {
        return args -> {
            // Only seed if DB is empty
            if (topicRepo.count() > 0) return;

            // Topics
            Topic grace = new Topic();
            grace.setName("Grace");
            grace.setDescription("The unmerited favor and love of God toward humanity.");
            topicRepo.save(grace);

            Topic faith = new Topic();
            faith.setName("Faith");
            faith.setDescription("Trust and belief in God and His promises.");
            topicRepo.save(faith);

            Topic prayer = new Topic();
            prayer.setName("Prayer");
            prayer.setDescription("Communication with God — praise, petition, and listening.");
            topicRepo.save(prayer);

            // Sources
            Source ytVideo = new Source();
            ytVideo.setTitle("What Is Grace? | The Bible Project");
            ytVideo.setUrl("https://www.youtube.com/watch?v=example");
            ytVideo.setType("video");
            ytVideo.setAuthor("The Bible Project");
            ytVideo.setDateAccessed("2024-03-01");
            sourceRepo.save(ytVideo);

            Source article = new Source();
            article.setTitle("Understanding Faith in the New Testament");
            article.setUrl("https://www.gotquestions.org/faith-in-the-Bible.html");
            article.setType("article");
            article.setAuthor("GotQuestions.org");
            article.setDateAccessed("2024-03-10");
            sourceRepo.save(article);

            // Verses
            Verse eph28 = new Verse();
            eph28.setBook("Ephesians");
            eph28.setChapter(2);
            eph28.setVerseStart(8);
            eph28.setVerseEnd(9);
            verseRepo.save(eph28);

            Verse heb11 = new Verse();
            heb11.setBook("Hebrews");
            heb11.setChapter(11);
            heb11.setVerseStart(1);
            heb11.setVerseEnd(1);
            verseRepo.save(heb11);

            // Insights
            Insight graceInsight = new Insight();
            graceInsight.setContent("Grace is not something we earn — it is freely given by God as a gift. The Bible Project video highlighted how the Hebrew word 'hesed' (loving kindness) is the Old Testament root of this concept.");
            graceInsight.setYourCommentary("This really changed how I read Ephesians. Grace is not just forgiveness — it is God's active love toward us even when we do not deserve it.");
            graceInsight.setSource(ytVideo);
            graceInsight.setTopic(grace);
            graceInsight.setVerses(List.of(eph28));
            insightRepo.save(graceInsight);

            Insight faithInsight = new Insight();
            faithInsight.setContent("Faith in the New Testament (Greek: 'pistis') means active trust and commitment, not just intellectual belief. The article explains that James 2 clarifies that true faith produces action.");
            faithInsight.setYourCommentary("I used to think faith meant just believing facts about God. Now I understand it is more like trusting a person — it changes how you live.");
            faithInsight.setSource(article);
            faithInsight.setTopic(faith);
            faithInsight.setVerses(List.of(heb11));
            insightRepo.save(faithInsight);
        };
    }
}
