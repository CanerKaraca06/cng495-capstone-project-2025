package com.capstoneproject.musicplatform.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "artists")
public class Artist {

    //Fields of artist class
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String stageName;

    @Column(nullable = false)
    private String realName;

    @Column(length = 500)
    private String bio;

    @Column(name = "image_url", nullable = true)
    private String profileImageUrl;

    @Column
    private String genre;

    @Column
    private String country;

    @Column
    private LocalDate debutDate;

    @Column
    private int followersCount = 0;

    @Column
    private double averageRating = 0.0;

    //CONSTRUCTORS
    public Artist() {

    }

    public Artist(String stageName, String realName, String bio, String profileImageUrl, String genre, String country, LocalDate debutDate) {
        this.stageName = stageName;
        this.realName = realName;
        this.bio = bio;
        this.profileImageUrl = profileImageUrl;
        this.genre = genre;
        this.country = country;
        this.debutDate = debutDate;
    }


    //GETTERS AND SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDate getDebutDate() {
        return debutDate;
    }

    public void setDebutDate(LocalDate debutDate) {
        this.debutDate = debutDate;
    }

    public int getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(int followersCount) {
        this.followersCount = followersCount;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }
}
