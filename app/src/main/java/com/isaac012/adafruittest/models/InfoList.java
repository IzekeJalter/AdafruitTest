package com.isaac012.adafruittest.models;

import java.util.List;

public class InfoList {
    private String username;
    private String name;
    private String created_at;
    private List<Feed> feeds;

    public InfoList(String username, String name, String created_at, List<Feed> feeds) {
        this.username = username;
        this.name = name;
        this.created_at = created_at;
        this.feeds = feeds;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public List<Feed> getFeeds() {
        return feeds;
    }

    public void setFeeds(List<Feed> feeds) {
        this.feeds = feeds;
    }
}
