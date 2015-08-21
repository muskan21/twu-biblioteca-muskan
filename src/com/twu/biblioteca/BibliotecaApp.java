package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        System.out.println(bibliotecaApp.welcome());
        Scanner input = new Scanner(System.in);
        input.nextLine();
        //ArrayList<Books> bookslist = new ArrayList<Books>();
        BibliotecaLibrary bibliotecaLibrary = new BibliotecaLibrary();
        boolean libr = bibliotecaLibrary.initializeLibrary();
        //System.out.println(bibliotecaLibrary.getIsEmptyBookList());
        User user=new User();
        int choice;
        boolean check = false;
        do {
            bibliotecaLibrary.printMenu();
            choice = bibliotecaLibrary.getInput();
                switch (choice) {
                    case 1:
                        bibliotecaLibrary.printBookList();
                        break;

                    case 2:
                        String bookname=getBookInput("checked out");
                        boolean checkout=user.checkOutBook(bookname, bibliotecaLibrary);
                        //System.out.println(checkout);
                        if(checkout)
                            System.out.println("Thank You. Enjoy the book.");
                        else
                            System.out.println("That book is not available.");
                        break;

                    case 3:
                        String bookname2 = getBookInput("returned");
                        boolean returnbook = user.returnBook(bookname2, bibliotecaLibrary);
                        if(returnbook)
                            System.out.println("Thank You for returning the book.");
                        else
                            System.out.println("That is not a valid book to return for the signed in user.");
                        break;

                    case 4:
                        bibliotecaLibrary.printMovieList();
                        break;

                    case 5:
                        break;

                    default:
                        System.out.println("Select a valid option!!");
                }
        }while (choice != 5);
    }

    private static String getBookInput(String op) {
        System.out.println("Enter the name of the book to be "+op+" : ");
        Scanner input= new Scanner(System.in);
        return input.nextLine();
    }

    public String welcome() {
        String welcomeString="Welcome to Bangalore Public Library.\nBiblioteca is available for your assistance.\n(Press Enter To Continue.)";
        return welcomeString;
    }

    public boolean validateUserInput(int choice) {
        if(choice == 1 || choice == 2 || choice == 3)
            return true;
        else
            return false;
    }
}
