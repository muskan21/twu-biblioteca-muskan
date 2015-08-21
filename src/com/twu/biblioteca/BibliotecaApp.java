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
                        try {
                            String bookname = getNameInput("checked out", "book");
                            boolean checkout = user.checkOutBook(bookname, bibliotecaLibrary);
                            //System.out.println(checkout);
                            if (checkout)
                                System.out.println("Thank You. Enjoy the book.");
                            else
                                System.out.println("That book is not available.");
                        }
                        catch(NumberFormatException e) {
                            System.out.println(e.getMessage());
                        }
                        finally {
                            break;
                        }

                    case 3:
                        try {
                            String bookname2 = getNameInput("returned", "book");
                            boolean returnbook = user.returnBook(bookname2, bibliotecaLibrary);
                            if (returnbook)
                                System.out.println("Thank You for returning the book.");
                            else
                                System.out.println("That is not a valid book to return for the signed in user.");
                        }
                        catch(NumberFormatException e) {
                            System.out.println(e.getMessage());
                        }
                        finally {
                            break;
                        }

                    case 4:
                        bibliotecaLibrary.printMovieList();
                        break;

                    case 5:
                        try {
                            String moviename = getNameInput("checked out", "movie");
                            boolean checkoutm = user.checkOutMovie(moviename, bibliotecaLibrary);
                            //System.out.println(checkout);
                            if (checkoutm)
                                System.out.println("Thank You. Enjoy the movie.");
                            else
                                System.out.println("That movie is not available.");
                        }
                        catch(NumberFormatException e) {
                            System.out.println(e.getMessage());
                        }
                        finally {
                            break;
                        }

                    case 6:
                        break;

                    default:
                        System.out.println("Select a valid option!!");
                }
        }while (choice != 6);
    }

    private static String getNameInput(String op, String item) throws NumberFormatException{
        System.out.println("Enter the name of the "+item+" to be "+op+" : ");
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
