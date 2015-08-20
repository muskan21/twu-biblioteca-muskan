package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by muskan on 21/8/15.
 */
public class BibliotecaLibrary {
    public ArrayList<Books> initializeLibrary() {
        ArrayList<Books> bookslist = new ArrayList<Books>();
        bookslist.add(new Books("Computer Science","Comp1",1992));
        bookslist.add(new Books("Operating Systems","Comp1",1998));
        bookslist.add(new Books("Computer Science","Comp3",1996));
        bookslist.add(new Books("Computer Technologies","Comp4",2005));
        bookslist.add(new Books("Information Technology Sector","Comp2",2000));
        bookslist.add(new Books("Computer Networks","Comp8",2004));
        bookslist.add(new Books("Computer System Architecture","Comp6",2009));
        bookslist.add(new Books("Operating Systems","Comp6",2007));
        bookslist.add(new Books("Fiction Book","NoComp",2010));
        bookslist.add(new Books("Learning Computer Science Programming","Comp7",1995));
        bookslist.add(new Books("TDD Programming","Comp7",2004));
        bookslist.add(new Books("Computer Science And Thw World","NotComp",2005));

        return bookslist;
    }

    public void printBookList(ArrayList<Books> bookslist) {
        System.out.println("Book Name\t\t\t\t\t\tBook Author\tYear Published");
        for(Books b : bookslist) {
            System.out.println(b.getBookName()+"\t\t\t"+b.getBookAuthor()+"\t"+b.getYearPublished());
        }
    }

    public void printMenu() {
        System.out.println("\nMenu..\n1.List Books.\nEnter Your Choice.");
    }

    public int getInput() {
        Scanner input=new Scanner(System.in);
        return Integer.parseInt(input.nextLine());
    }
}
