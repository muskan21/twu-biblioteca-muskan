package com.twu.biblioteca;

import java.util.ArrayList;
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
        User user=null;
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
                        if(user == null) {
                            user=userLogin(bibliotecaLibrary);
                        }
                        String bookname = getNameInput("checked out", "book");
                        boolean checkout = user.checkOutBook(bookname, bibliotecaLibrary);
                        if (checkout)
                            System.out.println("Thank You. Enjoy the book.");
                        else
                            System.out.println("That book is not available.");
                        break;

                    case 3:
                        if(user == null) {
                            user=userLogin(bibliotecaLibrary);
                        }
                        String bookname2 = getNameInput("returned", "book");
                        boolean returnbook = user.returnBook(bookname2, bibliotecaLibrary);
                        if (returnbook)
                            System.out.println("Thank You for returning the book.");
                        else
                            System.out.println("That is not a valid book to return for the signed in user.");
                        break;

                    case 4:
                        bibliotecaLibrary.printMovieList();
                        break;

                    case 5:
                        if(user == null) {
                            user=userLogin(bibliotecaLibrary);
                        }
                        String moviename = getNameInput("checked out", "movie");
                        boolean checkoutm = user.checkOutMovie(moviename, bibliotecaLibrary);
                        if (checkoutm)
                            System.out.println("Thank You. Enjoy the movie.");
                        else
                            System.out.println("That movie is not available.");
                        break;

                    case 6:
                        user = userLogin(bibliotecaLibrary);
                        break;

                    case 7:
                        break;

                    default:
                        System.out.println("Select a valid option!!");
                }
        }while (choice != 7);
    }

    private static User userLogin(BibliotecaLibrary bibliotecaLibrary) {
        ArrayList<String> credentials = inputLoginCredentials();
        User user;
        if(bibliotecaLibrary.validateUser(credentials.get(0), credentials.get(1), credentials.get(2)))
            user = new User(credentials.get(0),credentials.get(1),credentials.get(2));
        else {
            System.out.println("Invalid login credentials!");
            return null;
        }
        return user;
    }

    private static ArrayList<String> inputLoginCredentials() {
        ArrayList<String> cred=new ArrayList<String>();
        System.out.println("Enter Login Credentials To Use The System.");
        System.out.println("User Name : ");
        Scanner input = new Scanner(System.in);
        cred.add(input.nextLine());
        System.out.println("Library Number : ");
        cred.add(input.nextLine());
        System.out.println("Password : ");
        cred.add(input.nextLine());
        return cred;
    }

    private static String getNameInput(String op, String item){
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
