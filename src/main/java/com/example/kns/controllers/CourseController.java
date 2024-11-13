package com.example.kns.controllers;

import com.example.kns.models.Answer;
import com.example.kns.models.Course;
import com.example.kns.models.Task;
import com.example.kns.models.User;
import com.example.kns.services.CourseService;
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
        User user = courseService.getUserByPrincipal(principal);
        model.addAttribute("user", user);
        model.addAttribute("course", course);
        model.addAttribute("notFoundCourse", !courseService.foundCourse(user, course));
        model.addAttribute("tasks", courseService.listTasks(idCourse));
        return "course-info";
    }
    @PostMapping("/course/{idCourse}")
    public String courseToUser(@PathVariable Long idCourse, Model model, Principal principal) {
        Course course = courseService.getCourseById(idCourse);
        User user = courseService.getUserByPrincipal(principal);
        courseService.userCourse(user, course);
        return "redirect:/course/"+idCourse;
    }

    @GetMapping("/course/{idCourse}/task/{idTask}")
    public String taskInfo(@PathVariable Long idCourse,
                           @PathVariable Long idTask, Model model, Principal principal) {
        User user = courseService.getUserByPrincipal(principal);
        Task task = courseService.getTaskById(idTask);
        model.addAttribute("user", user);
        model.addAttribute("courseid", idCourse);
        model.addAttribute("task", task);
        model.addAttribute("noAnsw", !courseService.haveAnswer(user, task));
        return "task";
    }

    @PostMapping("/course/{idCourse}/task/{idTask}")
    public String getAnswer(@PathVariable Long idCourse,
                            @PathVariable Long idTask,
                            @RequestParam(name = "text") String text, Model model, Principal principal) {
        User user = courseService.getUserByPrincipal(principal);
        Task task = courseService.getTaskById(idTask);
        if (!courseService.haveAnswer(user, task)){
            Answer answer = new Answer();
            answer.setDate();
            answer.setText(text);
            answer.setTask(task);
            answer.setUser(user);
            courseService.addAnswer(task, answer);
        }
        return "redirect:/course/"+idCourse+"/task/"+idTask;
    }

    @GetMapping("/add/course")
    public String courseAdd(Model model, Principal principal) {
        User user = courseService.getUserByPrincipal(principal);
        model.addAttribute("user", user);
        return "courseAdd";
    }

    @PostMapping("/add/course")
    public String courseAdd(@RequestParam(name = "Title") String title,
                            @RequestParam(name = "Price") int price,
                            @RequestParam(name = "Description") String text,
                            Model model, Principal principal) {
        User user = courseService.getUserByPrincipal(principal);
        Course course = new Course();
        course.setTitle(title);
        course.setPrice(price);
        course.setDescription(text);
        courseService.addCourse(course);
        return "redirect:/course";
    }
    @GetMapping("/add/course/{idCourse}")
    public String taskAdd(@PathVariable Long idCourse, Model model, Principal principal) {
        User user = courseService.getUserByPrincipal(principal);
        model.addAttribute("user", user);
        return "/add/course/"+idCourse;
    }

    @PostMapping("/add/course/{idCourse}")
    public String taskAdd(@PathVariable Long idCourse,
                          @RequestParam(name = "Text") String text,
                          @RequestParam(name = "Namber") int namber,
                          @RequestParam(name = "link") String link,
                          Model model, Principal principal) {
        User user = courseService.getUserByPrincipal(principal);
        Course course = courseService.getCourseById(idCourse);
        Task task = new Task();
        task.setText(text);
        task.setLink(link);
        task.setNamber(namber);
        task.setCourse(course);
        course.addTaskToCourse(task);
        courseService.addTask(course, task);
        return "redirect:/course/"+idCourse;
    }
}

//    @GetMapping("/course/{idCourse}/task/{idTask}")
//    public String taskInfo(@PathVariable Long idCourse,
//                           @PathVariable Long idTask, Model model, Principal principal) {
//        User user = courseService.getUserByPrincipal(principal);
//        Task task = courseService.getTaskById(idTask);
//        model.addAttribute("user", user);
//        model.addAttribute("courseid", idCourse);
//        model.addAttribute("task", task);
//        model.addAttribute("noAnsw", !courseService.haveAnswer(user, task));
////        if (courseService.userAnswerPrew(user, task)) {
////            return "task";
////        }else if(courseService.prewAnswerTime(user, task)) {
////                model.addAttribute("errorTime", "Подождите до завтра");
////        }else {
////            model.addAttribute("errorTask", "Выполните предыдущее задание");
////        }
////        return "noTask";
//        return "task";
//    }



