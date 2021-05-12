package com.vladbrown.netslab.lab3.web.controllers.album;

import com.vladbrown.netslab.lab3.entity.Album;
import com.vladbrown.netslab.lab3.entity.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
@RequestMapping("/album")
public class AlbumDetailsController {

    public static final String URL_PREFIX = "http://back:8080";

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/{albumId}/track")
    public String addNewTrack(@PathVariable String albumId, Track track, Model model) {
        var album = restTemplate.postForObject(URL_PREFIX + "/album/" + albumId + "/track", track, Album.class);
        return "redirect:/artist/" + album.getArtist().getId();
    }
}
