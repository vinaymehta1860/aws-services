package com.example.AWS.sentimentAnalysisService.RequestObjects;

import java.util.List;

public class AnalyseTexts {
    private List<String> texts;

    public AnalyseTexts() {}

    public AnalyseTexts(List<String> texts) {
        this.setTexts(texts);
    }

    public List<String> getTexts() {
        return texts;
    }

    public void setTexts(List<String>  texts) {
        this.texts = texts;
    }
}
