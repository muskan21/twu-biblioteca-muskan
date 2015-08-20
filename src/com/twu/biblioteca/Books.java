package com.twu.biblioteca;

/**
 * Created by muskan on 21/8/15.
 */
public class Books {
    private String bookName;
    private String bookAuthor;
    private int yearPublished;

    public Books(String name, String author, int yearPublished) {
        bookName=name;
        bookAuthor=author;
        this.yearPublished=yearPublished;
    }

    public String getBookName() {
        return bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public int getYearPublished() {
        return yearPublished;
    }
}
