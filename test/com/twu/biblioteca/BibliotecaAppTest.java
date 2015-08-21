package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by muskan on 21/8/15.
 */
public class BibliotecaAppTest {
    @Test
    public void testWelcome() {
        String testString="Welcome to Bangalore Public Library.\nBiblioteca is available for your assistance.\n(Press Enter To Continue.)";
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        assertEquals(testString, bibliotecaApp.welcome());
    }
    @Test
    public void testBook() {
        Books books=new Books("Book Name","Book Author",2015);
        assertEquals("Book Name",books.getBookName());
        assertEquals("Book Author",books.getBookAuthor());
        assertEquals(2015,books.getYearPublished());
        assertEquals(false,books.getIsCheckedOut());

        Books book2=new Books("Book 2","Book 2 Author",2);
        assertEquals("Book 2",book2.getBookName());
        assertEquals("Book 2 Author",book2.getBookAuthor());
        assertEquals(2,book2.getYearPublished());
        assertEquals(false,book2.getIsCheckedOut());
    }

    public void testInitializeLibrary() {
        BibliotecaLibrary bibliotecaLibrary=new BibliotecaLibrary();
        boolean b = bibliotecaLibrary.initializeLibrary();
        assertEquals(true, b);
        assertFalse(bibliotecaLibrary.getIsEmptyBookList());
    }

    @Test
    public void testValidateUserInput() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        assertFalse(bibliotecaApp.validateUserInput(4));
        assertTrue(bibliotecaApp.validateUserInput(2));
        assertTrue(bibliotecaApp.validateUserInput(1));
    }

    @Test
    public void testCheckOut() {
        User user = new User();
        String bookname="Computer Science";
        BibliotecaLibrary bibliotecaLibrary = new BibliotecaLibrary();
        user.setIsSet();
        user.setUserName("muskan1");
        assertFalse(user.checkOutBook(bookname, bibliotecaLibrary));

        bibliotecaLibrary.initializeLibrary();
        assertFalse(bibliotecaLibrary.getIsEmptyBookList());
        assertTrue(user.checkOutBook(bookname, bibliotecaLibrary));
    }

    @Test
    public void testCheckOutBook() {
        BibliotecaLibrary bibliotecaLibrary = new BibliotecaLibrary();
        String bookname="Computer Science";
        Books book = bibliotecaLibrary.checkOutBook(bookname);
        assertEquals(null, book);

        bibliotecaLibrary.initializeLibrary();
        book=bibliotecaLibrary.checkOutBook(bookname);
        assertEquals(true, book.getIsCheckedOut());
    }

    @Test
    public void testReturnBook() {
        User user = new User();
        String bookname="Computer Science";
        user.setIsSet();
        user.setUserName("muskan1");
        BibliotecaLibrary bibliotecaLibrary=new BibliotecaLibrary();
        assertFalse(user.returnBook(bookname,bibliotecaLibrary));

        bibliotecaLibrary.initializeLibrary();
        assertFalse(user.returnBook(bookname, bibliotecaLibrary));

        user.checkOutBook(bookname, bibliotecaLibrary);
        assertTrue(user.returnBook(bookname, bibliotecaLibrary));
    }
}
