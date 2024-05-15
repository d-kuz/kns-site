package com.example.kns.services;

import com.example.kns.models.Course;
import com.example.kns.models.User;
import com.example.kns.models.UserCourse;
import com.example.kns.models.enums.Role;
import com.example.kns.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public boolean createUser(User user) {
        String email = user.getEmail();
        if (userRepository.findByEmail(email) != null) return false;
        user.setActive(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.getRoles().add(Role.ROLE_USER);
        log.info("Saving new User with email: {}", email);
        userRepository.save(user);
        return true;
    }

    public List<User> list() {
        return userRepository.findAll();
    }

    public void banUser(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            if (user.isActive()) {
                user.setActive(false);
                log.info("Ban user with id = {}; email: {}", user.getId(), user.getEmail());
            } else {
                user.setActive(true);
                log.info("Unban user with id = {}; email: {}", user.getId(), user.getEmail());
            }
        }
        userRepository.save(user);
    }

    public void changeUserRoles(User user) {
        //Set<String> roles = Arrays.stream(Role.values()).map(Role::name).collect(Collectors.toSet());
        user.getRoles().clear();
//        for (String key : form.keySet()) {
//            if (roles.contains(key)) {
//                user.getRoles().add(Role.valueOf(key));
//            }
//        }
        user.getRoles().add(Role.ROLE_ADMIN);
        userRepository.save(user);
    }

    public void changeUserEmail(User user, String email) {
        user.setEmail(email);
        userRepository.save(user);
    }

    public void changeUserPassword(User user, String pass) {
        user.setPassword(pass);
        userRepository.save(user);
    }

    public User getUserByPrincipal(Principal principal) {
        if (principal == null) return new User();
        return userRepository.findByEmail(principal.getName());
    }

    public List<Course> getCourseList(User user) {
        List<Course> courses= new ArrayList<>();
            for (UserCourse c: user.getUserCourses()) {
                if (c.getUser().equals(user)){
                    courses.add(c.getCourse());
                }
            }
        return courses;
    }

    public boolean foundByEmail(String email) {
        if  (isNull(userRepository.findByEmail(email))){
            return false;
        }else {
            return true;
        }
    }
}
