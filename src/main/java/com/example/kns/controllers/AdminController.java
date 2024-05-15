package com.example.kns.controllers;

import com.example.kns.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public class AdminController {
    private final UserService userService;

    @GetMapping("/admin")
    public String admin(Model model, Principal principal) {
        model.addAttribute("users", userService.list());
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        return "admin";
    }



}
