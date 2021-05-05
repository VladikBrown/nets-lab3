package com.vladbrown.netslab.lab3.web.controllers.user;

import com.vladbrown.netslab.lab3.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/users")
public class UserListController {

    public static final String URL_PREFIX = "http://localhost:8080";

    public static final String USER_LIST_SUFFIX = "/users";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public String getUsers(final Model model){
        List<User> userList = List.of(Objects.requireNonNull(
                restTemplate.getForObject(URL_PREFIX + USER_LIST_SUFFIX, User[].class)));
        model.addAttribute("users", userList);
        return "userList";
    }

    @PostMapping
    public String postUser(User user) {
        System.out.println(restTemplate.postForObject(URL_PREFIX + "/" + USER_LIST_SUFFIX, user, User.class).getUserName());
        return "redirect:/users";
    }

}