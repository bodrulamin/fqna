package com.futureaisoft.model;

import org.springframework.stereotype.Component;

@Component
public class RatingCount {
    long id;
    long positive;
    long negative;

    public RatingCount() {
    }

    public RatingCount(long id, long positive, long negative) {
        this.id = id;
        this.positive = positive;
        this.negative = negative;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPositive() {
        return positive;
    }

    public void setPositive(long positive) {
        this.positive = positive;
    }

    public long getNegative() {
        return negative;
    }

    public void setNegative(long negative) {
        this.negative = negative;
    }
}
