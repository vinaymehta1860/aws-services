package com.example.AWS.sentimentAnalysisService.services;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.comprehend.AmazonComprehend;
import com.amazonaws.services.comprehend.AmazonComprehendClientBuilder;
import com.amazonaws.services.comprehend.model.*;
import com.example.AWS.sentimentAnalysisService.DTO.Analysis;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnalysisService {
    // Public method to detect sentiment for a single text string
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

    // Public method to detect sentiment for a list of strings
    public List<Analysis> analyzeTexts(List<String> texts) {
        AWSCredentialsProvider awsCredentialsProvider = DefaultAWSCredentialsProviderChain.getInstance();

        AmazonComprehend comprehendClient = AmazonComprehendClientBuilder
                                                            .standard()
                                                            .withCredentials(awsCredentialsProvider)
                                                            .withRegion("us-west-2")
                                                            .build();

        BatchDetectSentimentRequest batchDetectSentimentRequest = new BatchDetectSentimentRequest().withTextList(texts).withLanguageCode("en");

        BatchDetectSentimentResult batchDetectSentimentResult = comprehendClient.batchDetectSentiment(batchDetectSentimentRequest);

        return getAnalysisObjects(batchDetectSentimentResult);
    }

    private Analysis getAnalysisObject(String sentiment, SentimentScore scoreDetails) {
        return new Analysis(sentiment, scoreDetails);
    }

    private List<Analysis> getAnalysisObjects(BatchDetectSentimentResult batchDetectSentimentResult) {
        List textAnalysisObjects = new ArrayList();

        for (BatchDetectSentimentItemResult item : batchDetectSentimentResult.getResultList()) {
            Analysis analysis = new Analysis(item.getSentiment(), item.getSentimentScore());
            textAnalysisObjects.add(analysis);
        }

        return textAnalysisObjects;
    }
}
