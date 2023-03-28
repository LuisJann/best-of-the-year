package org.java.bestoftheyear.model;

public class Movie {
    private String title;
    private int id;

    private String description;
    private String director;

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

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Movie(String title, int id, String description, String director) {
        this.title = title;
        this.id = id;
        this.description = description;
        this.director = director;
    }
}
