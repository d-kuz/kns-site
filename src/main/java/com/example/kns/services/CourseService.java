package com.example.kns.services;

import com.example.kns.models.*;
import com.example.kns.repositories.CourseRepository;
import com.example.kns.repositories.TaskRepository;
import com.example.kns.repositories.UserCourseRepository;
import com.example.kns.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;
    private final TaskRepository taskRepository;
    private final UserCourseRepository userCourseRepository;

    public List<Course> listCourses(String title) {
        if (title != null) return courseRepository.findByTitle(title);
        return courseRepository.findAll();
    }

    public void addAnswer( Task task, Answer answer){
        task.addAnswer(answer);
        taskRepository.save(task);
    }

    public boolean haveAnswer(User user, Task task){
        for (Answer answer: task.getAnswers()) {
            if (answer.getUser().equals(user)){
                return true;
            }
        }
        return false;
    }
    public void userCourse(User user, Course course){
        if(!foundCourse(user, course)){
            UserCourse userCourse = new UserCourse();
            userCourse.setUser(user);
            userCourse.setCourse(course);
            userCourseRepository.save(userCourse);
            user.addUserCourse(userCourse);
            userRepository.save(user);
        }
    }

    public boolean foundCourse(User user, Course course){
        for (UserCourse userCourse: userCourseRepository.findAll()) {
            if ((userCourse.getUser().equals(user)) & (userCourse.getCourse().equals(course))){
                return true;
            }
        }
        return false;

    }


    public User getUserByPrincipal(Principal principal) {
        if (principal == null) return new User();
        return userRepository.findByEmail(principal.getName());
    }


    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }
    public List<Course> listCourses() {
        return courseRepository.findAll();
    }

    public List<Task> findTasksByIdCourse(Long idCourse) {
        List<Task> newList = new ArrayList<>();
        for (Task task: taskRepository.findAll()) {
            if(task.getCourse().getId().equals(idCourse)){
                newList.add(task);
            }
        }
        return newList;
    }


    public List<Task> listTasks(Long idCourse) {
        List<Task> list = findTasksByIdCourse(idCourse);
        Comparator<Task> compareByNamber = new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return o1.getNamber()-o2.getNamber();
            }
        };
        Collections.sort(list, compareByNamber);
        return list;
    }

//    public boolean userAnswerPrew(User user, Task taskNext) {
//        Task task = foundPrewTask(taskNext);
//        if (task.equals(taskNext)){
//            return true;
//        }
//        for (Answer answer: task.getAnswers()){
//            if(answer.getUser().equals(user)){
//                return true;
//            }
//        }
//        return  false;
//    }

//    public boolean prewAnswerTime(User user, Task taskNext) {
//        Task task = foundPrewTask(taskNext);
//        if (task.equals(taskNext)){
//            return true;
//        }
//        for (Answer answer: task.getAnswers()){
//            if(answer.getUser().equals(user)){
//                if((answer.getDate().getDayOfYear() < LocalDateTime.now().getDayOfYear()) &
//                        (answer.getDate().getYear()<LocalDateTime.now().getYear())){
//                    return true;
//                }
//                return  false;
//            }
//        }
//        return false;
//    }

//    private Task foundPrewTask(Task taskNext) {
//        for (Task task: taskNext.getCourse().getTasks()){
//            if (task.getNamber()==task.getNamber()+1){
//                return task;
//            }
//        }
//        return taskNext;
//    }


    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    public void addTask(Course course, Task task) {
        courseRepository.save(course);
        taskRepository.save(task);
    }
}
