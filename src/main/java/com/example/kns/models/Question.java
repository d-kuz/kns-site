package com.example.kns.models;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "questions")
@Data
public class Question{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Long id;
    private Integer namber;
    private String text;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private Test test;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,
            mappedBy = "question")
    private List<QuestionsAnswer> questionsAnswers = new ArrayList<>();




    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


    public void setTest(Test test) {
        this.test = test;
    }

    public void addQuestionAnswer(QuestionsAnswer answer) {
        questionsAnswers.add(answer);
    }
}
