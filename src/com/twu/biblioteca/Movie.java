package com.twu.biblioteca;

/**
 * Created by muskandhanda on 8/22/15.
 */
public class Movie {
    private String name;
    private int year;
    private String director;
    private float rating;

    public Movie(String name, int year, String director, float rating) {
        this.name=name;
        this.year=year;
        this.director=director;
        this.rating=rating;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }

    public float getRating() {
        return rating;
    }
}
