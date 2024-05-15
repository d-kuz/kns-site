package com.example.kns.models;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tasks")
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Long id;
    private Integer namber;
    private String text;
    private String link;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private Course course;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,
            mappedBy = "task")
    private List<Answer> answers = new ArrayList<>();



    public Answer getUserAnswer(User user){
        Answer answ = new Answer();
        answ.setText("");
        for (Answer answer: answers) {
            if (answer.getUser().equals(user)){
                return answer;
            }
        }
        return answ;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void addAnswer(Answer answer) {
        answers.add(answer);
    }
}
