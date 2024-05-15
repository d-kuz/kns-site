package com.example.kns.controllers;

import com.example.kns.models.Course;
import com.example.kns.models.User;
import com.example.kns.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/login")
    public String login(Principal principal, Model model) {
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        return "login";
    }

    @GetMapping("/profile")
    public String profile(Principal principal,
                          Model model) {
        User user = userService.getUserByPrincipal(principal);
        List<Course> c = userService.getCourseList(user);
        model.addAttribute("user", user);
        model.addAttribute("courses", c);
        model.addAttribute("emptyCourses", c.isEmpty());
        return "profile";
    }

//    @PostMapping("/profile")
//    public String cleanCourses(Principal principal,
//                          Model model) {
//        User user = userService.getUserByPrincipal(principal);
//        userService.cleanCourse(user);
//        return "profile";
//    }

    @GetMapping("/registration")
    public String registration(Principal principal, Model model) {
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        return "registration";
    }

    @PostMapping("/registration")
    public String createUser(User user, Model model) {
        if (!userService.createUser(user)) {
            model.addAttribute("errorMessage", "Пользователь с email: " + user.getEmail() + " уже существует");
            return "registration";
        }
        return "redirect:/login";
    }

    @GetMapping("/userChange")
    public String userChange(Principal principal, Model model) {
        User user = userService.getUserByPrincipal(principal);
        model.addAttribute("user", user);
        return "userChange";
    }
    @PostMapping("/userChangeEmail")
    public String saveUserChangeEmail(@RequestParam(name = "email") String email, Principal principal, Model model) {
        if (!userService.foundByEmail(email)){
            User user = userService.getUserByPrincipal(principal);
            userService.changeUserEmail(user, email);
        }else{
            model.addAttribute("errorMessage", "Такая почта занята!");
        }
        return "userChange";
    }

    @PostMapping("/userChangePassword")
    public String saveUserChangePass(@RequestParam(name = "password1") String p1,
                                      @RequestParam(name = "password2") String p2, Principal principal, Model model) {
        User user = userService.getUserByPrincipal(principal);
        if(p1.equals(p2)){
            userService.changeUserPassword(user, p1);
        }else {
            model.addAttribute("errorMessage", "Пароли не совпадают!");
        }
        return "userChange";
    }

}
