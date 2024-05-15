package com.example.kns.models;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name = "results")
public class QuestionsResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "result_id")
    private Long id;
    private String text;

    private int min;
    private int max;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private Test test;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }
}
