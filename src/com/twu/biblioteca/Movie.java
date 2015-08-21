package com.twu.biblioteca;

import com.sun.org.apache.xerces.internal.xni.XMLString;

import java.awt.*;

/**
 * Created by muskandhanda on 8/22/15.
 */
public class Movie {
    private String name;
    private int year;
    private String director;
    private float rating;
    private boolean isCheckedOut;

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

    public String getMovieName() {
        return name;
    }

    public boolean getIsCheckedOut() {
        return isCheckedOut;
    }

    public void setIsCheckedOut() {
        this.isCheckedOut = true;
    }
}
