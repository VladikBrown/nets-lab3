package com.vladbrown.netslab.lab3.web.controllers.user;

import com.vladbrown.netslab.lab3.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
@RequestMapping("/user")
public class UserDetailsController {

    public static final String URL_PREFIX = "http://back:8080";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public String getUserForm() {
        return "userForm";
    }

    @GetMapping("/{userId}")
    public String getUserInfo(@PathVariable String userId, final Model model) {
        User user = restTemplate.getForObject(URL_PREFIX + "/user/" + userId, User.class);
        model.addAttribute("user", user);
        return "userDetails";
    }

    @PutMapping("/{userId}")
    public String updateUserInfo(@PathVariable String userId, User user) {
        user.setId(Long.valueOf(userId));
        restTemplate.put(URL_PREFIX + "/user/" + userId, user);
        return "redirect:/user/" + userId;
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable String userId) {
        restTemplate.delete(URL_PREFIX + "/user/" + userId);
        return "redirect:/users";
    }

    @PutMapping("/{userId}/artis/{artistId}")
    public void likeArtist(@PathVariable String userId, @PathVariable String artistId) {
        restTemplate.put(URL_PREFIX + "/" + "user/" + userId + "/artist/" + artistId, null);
    }

    @PutMapping("/{userId}/album/{albumId}")
    public void likeAlbum(@PathVariable String userId, @PathVariable String albumId) {
        restTemplate.put(URL_PREFIX + "/" + "user/" + userId + "/album/" + albumId, null);
    }

    @PutMapping("/{userId}/track/{trackId}")
    public void likeTrack(@PathVariable String userId, @PathVariable String trackId) {
        restTemplate.put(URL_PREFIX + "/" + "user/" + userId + "/track/" + trackId, null);
    }
}
