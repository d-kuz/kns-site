package com.example.kns.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "questions_answers")
public class QuestionsAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "questions_answer_id")
    private Long id;
    private String text;
    private Long point;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private Question question;

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public Long getPoint() {
        return point;
    }
    public void setPoint(Long point) {
        this.point = point;
    }
    public Question getQuestion() {
        return question;
    }
    public void setQuestion(Question question) {
        this.question = question;
    }
}
