package com.example.AWS.sentimentAnalysisService.RequestObjects;

import org.springframework.stereotype.Component;

@Component public class AnalyseText {
    private String text;

    public AnalyseText() {}

    public AnalyseText(String text) {
        this.setText(text);
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }
}
