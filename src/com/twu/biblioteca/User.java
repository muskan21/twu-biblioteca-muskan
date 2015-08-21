package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by muskandhanda on 8/21/15.
 */
public class User {
    private String password;
    private String libraryNumber;
    private ArrayList<Books> checkedOutBooks;
    private ArrayList<Movie> checkedOutMovies;
    private String username;
    private boolean isSet;

    public User() {
        checkedOutBooks=new ArrayList<Books>();
        checkedOutMovies=new ArrayList<Movie>();
        isSet=false;
    }

    public User(String username, String librarynumber, String password) {
        this.username=username;
        this.libraryNumber=librarynumber;
        this.password=password;
        isSet=true;
    }

    public boolean checkOutBook(String bookname, BibliotecaLibrary bibliotecaLibrary) {
        if(bibliotecaLibrary.getIsEmptyBookList() == true)
            return false;
        Books b = bibliotecaLibrary.checkOutBook(bookname);
        if(b != null) {
            this.checkedOutBooks.add(b);
            return true;
        }
        else return false;
    }

    private boolean isSetUserName() {
        return isSet;
    }

    public void setIsSet() {
        isSet=true;
    }

    public boolean returnBook(String bookname, BibliotecaLibrary bibliotecaLibrary) {
        if(bibliotecaLibrary.getIsEmptyBookList()==true)
            return false;
        for(Books b : bibliotecaLibrary.getBooksList()) {
            if (b.getBookName().equals(bookname) && b.getIsCheckedOut() == true && checkedOutBooks.contains(b)) {
                b.setIsCheckedOut(false);
                return true;
            }
        }
        return false;
    }

    public void setUserName(String userName) {
        this.username = userName;
    }

    public boolean checkOutMovie(String moviename, BibliotecaLibrary bibliotecaLibrary) {
        if(bibliotecaLibrary.getIsEmptyBookList() == true)
            return false;
        Movie m = bibliotecaLibrary.checkOutMovie(moviename);
        if(m != null) {
            this.checkedOutMovies.add(m);
            return true;
        }
        else return false;
    }

    public String getUserName() {
        return username;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public String getPassword() {
        return password;
    }
}
