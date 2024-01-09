package com.pks.controllers;

import com.pks.models.Answer;
import com.pks.models.Course;
import com.pks.models.Task;
import com.pks.models.User;
import com.pks.repositories.AnswerRepository;
import com.pks.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;
    private final AnswerRepository answerRepository;

    @GetMapping("/")
    public String mainTitle(Principal principal, Model model) {
        model.addAttribute("user", courseService.getUserByPrincipal(principal));
        return "index";
    }
    @GetMapping("/course")
    public String courses(Principal principal, Model model) {
        model.addAttribute("courses", courseService.listCourses());
        model.addAttribute("user", courseService.getUserByPrincipal(principal));
        return "courses";
    }

    @GetMapping("/course/{idCourse}")
    public String courseInfo(@PathVariable Long idCourse, Model model, Principal principal) {
        Course course = courseService.getCourseById(idCourse);
        model.addAttribute("user", courseService.getUserByPrincipal(principal));
        model.addAttribute("course", course);
        model.addAttribute("tasks", courseService.listTasks(idCourse));
        return "course-info";
    }
    @PostMapping("/course/{idCourse}")
    public String courseToUser(@PathVariable Long idCourse, Model model, Principal principal) {
        Course course = courseService.getCourseById(idCourse);
        User user = courseService.getUserByPrincipal(principal);
        courseService.userCourse(user, course);
        return "course-info";
    }

    @GetMapping("/course/{idCourse}/task/{idTask}")
    public String taskInfo(@PathVariable Long idCourse,
                           @PathVariable Long idTask, Model model, Principal principal) {
        User user = courseService.getUserByPrincipal(principal);
        Task task = courseService.getTaskById(idTask);
        model.addAttribute("user", user);
        model.addAttribute("task", task);
        if (courseService.userAnswerPrew(user, task)) {
            return "task";
        }else if(courseService.prewAnswerTime(user, task)) {
                model.addAttribute("errorTime", "Подождите до завтра");
        }else {
            model.addAttribute("errorTask", "Выполните предыдущее задание");
        }
        return "noTask";
    }

    @PostMapping("/course/{idCourse}/task/{idTask}")
    public String getAnswer(@PathVariable Long idCourse,
                            @PathVariable Long idTask,
                            @RequestParam(name = "text") String text, Model model, Principal principal) {
        User user = courseService.getUserByPrincipal(principal);
        Task task = courseService.getTaskById(idTask);
        if (task.haveAnswer(user)){
            Answer answer = task.getUserAnswer(user);
            answer.setText(text);
        }else{
            Answer answer = new Answer();
            answer.setDate();
            answer.setText(text);
            answer.setTask(task);
            answer.setUser(user);
            courseService.addAnswer(user, task, answer);
            answerRepository.save(answer);
        }
        return "task";
    }
}
