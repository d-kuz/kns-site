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

    @OneToMany(cascade = CascadeType.ALL, mappedBy="course", fetch = FetchType.LAZY )
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<UserCourse> userCourses  = new HashSet<UserCourse>();


//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "user_course",
//            joinColumns = @JoinColumn(name = "course_id"),
//            inverseJoinColumns = @JoinColumn(name = "user_id"))
//    private List<User> usersList = new ArrayList<>();



    public Integer getSizeTask() {
        return tasks.size();
    }

    public void addTaskToCourse(Task task) {
        task.setCourse(this);
        this.tasks.add(task);
    }

}
