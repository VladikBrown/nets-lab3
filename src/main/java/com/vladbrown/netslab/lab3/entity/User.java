package com.vladbrown.netslab.lab3.entity;

import java.util.Set;


public class User {

    private Long id;

    private String firstName;

    private String secondName;

    private String userName;

    private Set<Track> likedTracks;

    private Set<Album> likedAlbums;

    private Set<Artist> likedArtists;

    public User() {
    }

    public User(Long id, String firstName, String secondName, String userName) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.userName = userName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Set<Album> getLikedAlbums() {
        return likedAlbums;
    }

    public void setLikedAlbums(Set<Album> likedAlbums) {
        this.likedAlbums = likedAlbums;
    }

    public Set<Track> getLikedTracks() {
        return likedTracks;
    }

    public void setLikedTracks(Set<Track> likedTracks) {
        this.likedTracks = likedTracks;
    }

    public Set<Artist> getLikedArtists() {
        return likedArtists;
    }

    public void setLikedArtists(Set<Artist> likedArtists) {
        this.likedArtists = likedArtists;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", userName='" + userName + '\'' +
                ", likedTracks=" + likedTracks +
                ", likedAlbums=" + likedAlbums +
                ", likedArtists=" + likedArtists +
                '}';
    }
}
