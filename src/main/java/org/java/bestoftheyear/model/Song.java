package org.java.bestoftheyear.model;

public class Song {
    private String title;
    private int id;

    private String description;

    private String singer;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public Song(String title, int id, String description, String singer) {
        this.title = title;
        this.id = id;
        this.description = description;
        this.singer = singer;
    }
}
