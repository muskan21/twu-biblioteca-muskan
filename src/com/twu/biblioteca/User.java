package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by muskandhanda on 8/21/15.
 */
public class User {
    private ArrayList<Books> checkedOutBooks;
    private String username;
    private boolean isSet;
    private String userName;

    public User() {
        checkedOutBooks=new ArrayList<Books>();
    }

    public boolean checkOutBook(String bookname, BibliotecaLibrary bibliotecaLibrary) {
        if(!isSetUserName())
            username=inputUserName("check out");
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

    private String inputUserName(String op) {
        System.out.println("Enter your username to "+op+" book : ");
        Scanner input = new Scanner(System.in);
        setIsSet();
        return input.nextLine();
    }

    public void setIsSet() {
        isSet=true;
    }

    public boolean returnBook(String bookname, BibliotecaLibrary bibliotecaLibrary) {
        if(!isSetUserName())
            username=inputUserName("return");
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
}
