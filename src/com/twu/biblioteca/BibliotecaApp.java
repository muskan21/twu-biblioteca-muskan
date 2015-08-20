package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        System.out.println(bibliotecaApp.welcome());
        Scanner input = new Scanner(System.in);
        input.nextLine();
        ArrayList<Books> bookslist = new ArrayList<Books>();
        BibliotecaLibrary bibliotecaLibrary = new BibliotecaLibrary();
        bookslist= bibliotecaLibrary.initializeLibrary();
        bibliotecaLibrary.printMenu();
        int choice = bibliotecaLibrary.getInput();
        switch(choice) {
            case 1 : bibliotecaLibrary.printBookList(bookslist);
                    break;
            default:System.out.println("Wrong choice.");
        }
    }

    public String welcome() {
        String welcomeString="Welcome to Bangalore Public Library.\nBiblioteca is available for your assistance.\n(Press Enter To Continue.)";
        return welcomeString;
    }
}
