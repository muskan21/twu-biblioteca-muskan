package com.twu.biblioteca;

import java.beans.beancontext.BeanContextMembershipEvent;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by muskan on 21/8/15.
 */
public class BibliotecaLibrary {
    private ArrayList<Books> bookslist;
    private boolean isEmptyBookList;
    private ArrayList<Movie> movielist;
    private boolean isEmptyMovieList;
    private ArrayList<Movie> movieList;

    public BibliotecaLibrary() {
        isEmptyBookList=true;
        bookslist = new ArrayList<Books>();
        isEmptyMovieList=true;
        movielist = new ArrayList<Movie>();
    }

    public boolean initializeLibrary() {
        return this.initializeBook() && this.initializeMovie();
    }

    private boolean initializeMovie() {
        movielist.add(new Movie("Bollywood Movie", 2009, "Director one", 3.5f));
        movielist.add(new Movie("Tollywood Movie", 2007, "Director two", 3.8f));
        movielist.add(new Movie("Hollywood Movie", 2015, "Director five", 4.5f));
        movielist.add(new Movie("Pollywood Movie", 2012, "Director three", 3.0f));
        isEmptyMovieList=false;
        return true;
    }

    private boolean initializeBook() {
        //ArrayList<Books> bookslist = new ArrayList<Books>();

        bookslist.add(new Books("Computer Science","Comp1",1992));
        bookslist.add(new Books("Operating Systems","Comp1",1998));
        bookslist.add(new Books("Computer Science","Comp3",1996));
        bookslist.add(new Books("Computer Technos","Comp4",2005));
        bookslist.add(new Books("Information Tech","Comp2",2000));
        bookslist.add(new Books("Computer Networks","Comp8",2004));
        bookslist.add(new Books("Computer Systems","Comp6",2009));
        bookslist.add(new Books("Operating Systems","Comp6",2007));
        bookslist.add(new Books("Fiction/Comic Book","NoComp",2010));
        bookslist.add(new Books("Learn Programming","Comp7",1995));
        bookslist.add(new Books("TDD Programming!!","Comp7",2004));
        bookslist.add(new Books("Computers & World","NotComp",2005));
        isEmptyBookList=false;
        return true;
    }

    public void printBookList() {
        System.out.println("Book Name\t\t\t\t\tBook Author\t\tYear Published");
        for(Books b : bookslist) {
            if(b.getIsCheckedOut()==true)
                continue;
            System.out.println(b.getBookName()+"\t\t\t"+b.getBookAuthor()+"\t\t\t"+b.getYearPublished());
        }
    }

    public void printMenu() {
        System.out.println("\nMENU.\n1.List Books.\n2.Check Out Book.\n3.Return Book.\n4.List Movies.\n5.Check Out Movies.\n6.Quit.\nEnter Your Choice.");
    }

    public int getInput() {
        Scanner input=new Scanner(System.in);
        return Integer.parseInt(input.nextLine());
    }

    public ArrayList<Books> getBooksList() {
        return bookslist;
    }

    public Books checkOutBook(String bookname) {
        for(Books b : bookslist) {
            if(b.getBookName().equals(bookname) && b.getIsCheckedOut()==false) {
                b.setIsCheckedOut(true);
                //System.out.println("It's true");
                return b;
            }
        }
        return null;
    }

    public boolean getIsEmptyBookList() {
        return isEmptyBookList;
    }

    public boolean getIsEmptyMovieList() {
        return isEmptyMovieList;
    }

    public ArrayList<Movie> getMovieList() {
        return movieList;
    }

    public void printMovieList() {
        System.out.println("Movie Name\t\t\t\t\tYear\tMovie Director\t\t\tRating");
        for(Movie m : movielist) {
            if(m.getIsCheckedOut()==true)
                continue;
            System.out.println(m.getName() + "\t\t\t\t" + m.getYear() + "\t" + m.getDirector() + "\t\t\t" + m.getRating());
        }
    }

    public Movie checkOutMovie(String moviename) {
        for(Movie m : movielist) {
            if(m.getMovieName().equals(moviename) && m.getIsCheckedOut()==false) {
                m.setIsCheckedOut(true);
                //System.out.println("It's true");
                return m;
            }
        }
        return null;    }
}
