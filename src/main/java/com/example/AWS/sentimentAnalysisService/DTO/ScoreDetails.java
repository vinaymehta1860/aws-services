package com.example.AWS.sentimentAnalysisService.DTO;

import org.springframework.stereotype.Component;

@Component
public class ScoreDetails {
    private Float mixed;
    private Float positive;
    private Float negative;
    private Float neutral;

    public ScoreDetails() {}

    public ScoreDetails(Float mixed, Float positive, Float negative, Float neutral) {
        this.setMixed(mixed);
        this.setPositive(positive);
        this.setNegative(negative);
        this.setNeutral(neutral);
    }

    public Float getMixed() {
        return mixed;
    }

    public void setMixed(Float mixed) {
        this.mixed = mixed;
    }

    public Float getPositive() {
        return positive;
    }

    public void setPositive(Float positive) {
        this.positive = positive;
    }

    public Float getNegative() {
        return negative;
    }

    public void setNegative(Float negative) {
        this.negative = negative;
    }

    public Float getNeutral() {
        return neutral;
    }

    public void setNeutral(Float neutral) {
        this.neutral = neutral;
    }
}
