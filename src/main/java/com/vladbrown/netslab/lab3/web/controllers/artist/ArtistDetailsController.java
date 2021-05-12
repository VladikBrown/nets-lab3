package com.vladbrown.netslab.lab3.web.controllers.artist;

import com.vladbrown.netslab.lab3.entity.Album;
import com.vladbrown.netslab.lab3.entity.Artist;
import com.vladbrown.netslab.lab3.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
@RequestMapping("/artist")
public class ArtistDetailsController {

    public static final String URL_PREFIX = "http://back:8080";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{artistId}")
    public String getArtist(@PathVariable String artistId, final Model model) {
        Artist artist = restTemplate.getForObject(URL_PREFIX + "/artist/" + artistId, Artist.class);
        List<User> users = List.of(Objects.requireNonNull(
                restTemplate.getForObject(URL_PREFIX + "/users", User[].class)));

        model.addAttribute("artist", artist);
        model.addAttribute("users", users);
        return "artistDetails";
    }

    @PutMapping("/{artistId}")
    public String updateArtistInfo(@PathVariable String artistId, Artist artist, Model model) {
        artist.setId(Long.valueOf(artistId));
        restTemplate.put(URL_PREFIX + "/artist/" + artistId, artist);
        return "redirect:/artist/" + artistId;
    }

    @DeleteMapping("/{artistId}")
    public String deleteArtist(@PathVariable String artistId) {
        restTemplate.delete(URL_PREFIX + "/artist/" + artistId);
        return "redirect:/artists";
    }

    @PostMapping("/{artistId}/album")
    public String addNewAlbum(@PathVariable String artistId, Album album) {
        var savedArtist = restTemplate.postForObject(URL_PREFIX + "/artist/" + artistId + "/album", album, Album.class);
        return "redirect:/artist/" + artistId;
    }
}
