package com.isaac012.adafruittest.models;

public class Feed {
    private String username;
    private int id;
    private String name;
    private String last_value;
    private String created_at;
    private String key;

    public Feed(String username, Integer id, String name, String last_value, String created_at, String key) {
        this.username = username;
        this.id = id;
        this.name = name;
        this.last_value = last_value;
        this.created_at = created_at;
        this.key = key;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_value() {
        return last_value;
    }

    public void setLast_value(String last_value) {
        this.last_value = last_value;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
