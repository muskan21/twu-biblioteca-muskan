package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by muskandhanda on 8/21/15.
 */
public class User {
    private ArrayList<Books> checkedOutBooks;
    private ArrayList<Movie> checkedOutMovies;
    private String username;
    private boolean isSet;
    private String userName;

    public User() {
        checkedOutBooks=new ArrayList<Books>();
        checkedOutMovies=new ArrayList<Movie>();
    }

    public boolean checkOutBook(String bookname, BibliotecaLibrary bibliotecaLibrary) {
        if(!isSetUserName())
            username=inputUserName("check out", "book");
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

    private String inputUserName(String op, String item) {
        System.out.println("Enter your username to "+op+" "+item+" : ");
        Scanner input = new Scanner(System.in);
        setIsSet();
        return input.nextLine();
    }

    public void setIsSet() {
        isSet=true;
    }

    public boolean returnBook(String bookname, BibliotecaLibrary bibliotecaLibrary) {
        if(!isSetUserName())
            username=inputUserName("return", "book");
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
        this.userName = userName;
    }

    public boolean checkOutMovie(String moviename, BibliotecaLibrary bibliotecaLibrary) {
        if(!isSetUserName())
            username=inputUserName("check out","movie");
        if(bibliotecaLibrary.getIsEmptyBookList() == true)
            return false;
        Movie m = bibliotecaLibrary.checkOutMovie(moviename);
        if(m != null) {
            this.checkedOutMovies.add(m);
            return true;
        }
        else return false;
    }
}
