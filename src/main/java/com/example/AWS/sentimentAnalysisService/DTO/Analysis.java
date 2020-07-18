package com.example.AWS.sentimentAnalysisService.DTO;

import com.amazonaws.services.comprehend.model.SentimentScore;
import org.springframework.stereotype.Component;

@Component
public class Analysis {
    private String sentiment;
    private SentimentScore scoreDetails;

    public Analysis() {}

    public Analysis(String sentiment, SentimentScore SentimentScore) {
        this.setSentiment(sentiment);
        this.setScoreDetails(SentimentScore);
    }

    public String getSentiment() {
        return sentiment;
    }

    public void setSentiment(String sentiment) {
        this.sentiment = sentiment;
    }

    public SentimentScore getScoreDetails() {
        return scoreDetails;
    }

    public void setScoreDetails(SentimentScore scoreDetails) {
        this.scoreDetails = scoreDetails;
    }
}
