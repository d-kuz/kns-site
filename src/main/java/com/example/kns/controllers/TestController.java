package com.example.kns.controllers;


import com.example.kns.models.*;
import com.example.kns.services.UserService;
import com.example.kns.services.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class TestController {
    private final TestService testService;
    private final UserService userService;

    @GetMapping("/test")
    public String tests(Principal principal, Model model) {
        List <Test> tests = testService.listTests();
        model.addAttribute("tests", tests);
        model.addAttribute("Empty", tests.isEmpty());
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        return "tests";
    }

    @GetMapping("/test/{idTest}")
    public String testInfo(@PathVariable Long idTest, Principal principal, Model model) {
        Test test = testService.getTestById(idTest);
        User user = userService.getUserByPrincipal(principal);
        model.addAttribute("user", user);
        model.addAttribute("test", test);
        return "test-info";
    }

    @GetMapping("/test/{idTest}/questions")
    public String testQuestions(@PathVariable Long idTest, Principal principal, Model model) {
        Test test = testService.getTestById(idTest);
        User user = userService.getUserByPrincipal(principal);
        model.addAttribute("user", user);
        model.addAttribute("q", testService.listQuestions(idTest));
        model.addAttribute("a", testService.listResult(idTest));
        model.addAttribute("r", testService.listResult(idTest));
        return "questions";
    }

    @PostMapping("/test/{idTest}/questions")
    public String getResult(@PathVariable Long idTest,
                            @RequestParam List<Integer> res,
                            Principal principal, Model model) {
        Test test = testService.getTestById(idTest);
        User user = userService.getUserByPrincipal(principal);
        Integer result = 0;
        for (Integer r: res){
            result += r;
        }
        return "redirect:/test/"+idTest+"/results/"+result;
    }

    @GetMapping("/test/{idTest}/results/{resultT}")
    public String getResult(@PathVariable Long idTest,
                            @PathVariable Long resultT,
                            Principal principal, Model model) {
        Test test = testService.getTestById(idTest);
        User user = userService.getUserByPrincipal(principal);
        model.addAttribute("user", user);
        model.addAttribute("test", test);
        String text= "";
        for (QuestionsResult res: test.getQuestionsResults()) {
            if ((resultT >= res.getMin()) & (resultT <= res.getMax())){
                text = res.getText();
            }
        }
        model.addAttribute("res", resultT);
        model.addAttribute("resultTest", text);
        return "result";
    }


}
/*
    @GetMapping("/test/add")
    public String testAdd(Model model, Principal principal) {
        User user = userService.getUserByPrincipal(principal);
        model.addAttribute("user", user);
        if (!user.isAdmin()){
            model.addAttribute("errorMessage", "Нет доступа!");
        }
        return "testAdd";
    }

    @PostMapping("/test/add")
    public String testAdd(@RequestParam(name = "Title") String title,
                          @RequestParam(name = "Price") int price,
                          @RequestParam(name = "Description") String text,
                          Model model, Principal principal) {
        User user = userService.getUserByPrincipal(principal);
        if (user.isAdmin()){
            Test test = new Test();
            test.setTitle(title);
            test.setPrice(price);
            test.setDescription(text);
            testService.addTest(test);
        }else{
            model.addAttribute("errorMessage", "Нет доступа!");
        }
        return "courseAdd";
    }
    @GetMapping("/test/{idTest}/addQ")
    public String questionAdd(@PathVariable Long idTest, Model model, Principal principal) {
        User user = userService.getUserByPrincipal(principal);
        model.addAttribute("user", user);
        if (!user.isAdmin()){
            model.addAttribute("errorMessage", "Нет доступа!");
        }
        return "/test/"+idTest+"/add";
    }

    @PostMapping("/test/{idTest}/addQ")
    public String questionAdd(@PathVariable Long idTest,
                              @RequestParam(name = "Namber") int namber,
                              @RequestParam(name = "Text") String text,
                              Model model, Principal principal) {
        User user = userService.getUserByPrincipal(principal);
        if (user.isAdmin()){
            Question question = new Question();
            question.setNamber(namber);
            question.setText(text);
            testService.addQuestions(testService.getTestById(idTest), question);
        }else{
            model.addAttribute("errorMessage", "Нет доступа!");
        }
        return "/test/"+idTest+"/add";
    }

    @GetMapping("/test/{idTest}/addR")
    public String resultAdd(@PathVariable Long idTest, Model model, Principal principal) {
        User user = userService.getUserByPrincipal(principal);
        model.addAttribute("user", user);
        if (!user.isAdmin()){
            model.addAttribute("errorMessage", "Нет доступа!");
        }
        return "/test/"+idTest+"/add";
    }

    @PostMapping("/test/{idTest}/addR")
    public String resultAdd(@PathVariable Long idTest,
                            @RequestParam(name = "Min") int min,
                            @RequestParam(name = "Max") int max,
                            @RequestParam(name = "Text") String text,
                            Model model, Principal principal) {
        User user = userService.getUserByPrincipal(principal);
        if (user.isAdmin()){
            QuestionsResult result = new QuestionsResult();
            result.setMax(max);
            result.setMin(min);
            result.setText(text);
            testService.addResult(testService.getTestById(idTest), result);
        }else{
            model.addAttribute("errorMessage", "Нет доступа!");
        }
        return "/test/"+idTest+"/add";
    }*/
