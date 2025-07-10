package com.smiling.buddah.entity;

import jakarta.persistence.*;

@Entity
public class Follow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User followings;
    @ManyToOne
    private User followers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getFollowings() {
        return followings;
    }

    public void setFollowings(User followings) {
        this.followings = followings;
    }

    public User getFollowers() {
        return followers;
    }

    public void setFollowers(User followers) {
        this.followers = followers;
    }
}
