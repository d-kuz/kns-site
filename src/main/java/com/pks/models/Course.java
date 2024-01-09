package com.pks.models;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Long id;
    private String title;
    private String description;
    private Integer price;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,
    mappedBy = "course")
    private List<Task> tasks = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_course",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> usersList = new ArrayList<>();



    public Integer getSizeTask() {
        return tasks.size();
    }

    public void addTaskToCourse(Task task) {
        task.setCourse(this);
        tasks.add(task);
    }

    public void addUser(User user) {
        usersList.add(user);
    }
}
