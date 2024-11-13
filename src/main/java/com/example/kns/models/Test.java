package com.example.kns.models;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tests")
@Data
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "test_id")
    private Long id;
    private String title;
    private String description;
    private Integer price;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,
            mappedBy = "test")
    private List<Question> questions = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,
            mappedBy = "test")
    private List<QuestionsResult> questionsResults = new ArrayList<>();

}
//    public void addQuestionToTest(Question question) {
//        question.setTest(this);
//        this.questions.add(question);
//    }
//
//    public void addResultToTest(QuestionsResult result) {
//        result.setTest(this);
//        this.questionsResults.add(result;
//    }