package com.example.AWS.sentimentAnalysisService.services;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.comprehend.AmazonComprehend;
import com.amazonaws.services.comprehend.AmazonComprehendClientBuilder;
import com.amazonaws.services.comprehend.model.DetectSentimentRequest;
import com.amazonaws.services.comprehend.model.DetectSentimentResult;
import com.amazonaws.services.comprehend.model.SentimentScore;
import com.example.AWS.sentimentAnalysisService.DTO.Analysis;
import org.springframework.stereotype.Service;

@Service
public class AnalysisService {
    public Analysis analyzeText(String text) {
        AWSCredentialsProvider awsCredentialsProvider = DefaultAWSCredentialsProviderChain.getInstance();

        AmazonComprehend comprehendClient = AmazonComprehendClientBuilder
                                                            .standard()
                                                            .withCredentials(awsCredentialsProvider)
                                                            .withRegion("us-west-2")
                                                            .build();

        DetectSentimentRequest detectSentimentRequest = new DetectSentimentRequest().withText(text).withLanguageCode("en");

        DetectSentimentResult detectSentimentResult = comprehendClient.detectSentiment(detectSentimentRequest);

        System.out.println("Sentiment: " + detectSentimentResult.getSentiment());
        System.out.println("Sentiment score: " + detectSentimentResult.getSentimentScore());

        return getAnalysisObject(detectSentimentResult.getSentiment(), detectSentimentResult.getSentimentScore());
    }

    private Analysis getAnalysisObject(String sentiment, SentimentScore scoreDetails) {
        return new Analysis(sentiment, scoreDetails);
    }
}
