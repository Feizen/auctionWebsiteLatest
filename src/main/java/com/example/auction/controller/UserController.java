package com.example.auction.controller;


import com.example.auction.model.Role;
import com.example.auction.model.User;
import com.example.auction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String userList(Model model) {
        model.addAttribute("users", userService.findAllUsers());
        return "userList";
    }

    @GetMapping("/{id}")
    public String userEditForm(@PathVariable("id") Long userId, Model model) {
        User user = userService.findUserById(userId);
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return "userEdit";
    }
    // Problems with this one
//    @PostMapping("/registration")
//    public String createUser(User user, Map<String, Object> model){
//        User userFromDb = userService.findByUsername(user.getUsername());
//        if(userFromDb != null){
//            model.put("message", "User exists");
//            return "registration";
//        }
//        user.setActive(true);
//        user.setRoles(Collections.singleton(Role.USER));
//        userService.createUser(user);
//        return "redirect:/home";
//    }

    @PostMapping("{id}")
    public String updateUser(@PathVariable("id") Long userId, @RequestParam Map<String, String> form) {
        User user = userService.findUserById(userId);
        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());
        String formRole = form.get("role");
        if (roles.contains(formRole)) {
            Set<Role> newRole = Arrays.stream(Role.values())
                    .filter(role -> role.name().contains(formRole))
                    .collect(Collectors.toSet());
            user.getRoles().clear();
            user.setRoles(newRole);
        }
        userService.updateUser(user);
        return "redirect:/user";
    }
}
