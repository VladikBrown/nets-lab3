package com.vladbrown.netslab.lab3.web.controllers.artist;

import com.vladbrown.netslab.lab3.entity.Artist;
import com.vladbrown.netslab.lab3.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
@RequestMapping("/artists")
public class ArtistListController {

    public static final String URL_PREFIX = "http://back:8080";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public String getArtists(final Model model) {
        List<Artist> artists = List.of(Objects.requireNonNull(
                restTemplate.getForObject(URL_PREFIX + "/artists", Artist[].class)));
        List<User> users = List.of(Objects.requireNonNull(
                restTemplate.getForObject(URL_PREFIX + "/users", User[].class)));

        model.addAttribute("artists", artists);
        model.addAttribute("users", users);

        return "artistList";
    }

    @PostMapping
    public String postArtist(Artist artist) {
        var savedArtist = restTemplate.postForObject(URL_PREFIX + "/artists", artist, Artist.class);
        return "redirect:/artist/" + savedArtist.getId();
    }

}
