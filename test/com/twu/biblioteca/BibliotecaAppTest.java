package com.twu.biblioteca;

import org.junit.Assert;
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
        assertEquals(12, bibliotecaLibrary.getBooksList().size());
        assertFalse(bibliotecaLibrary.getIsEmptyMovieList());
        assertEquals(4,bibliotecaLibrary.getMovieList().size());
        assertFalse(bibliotecaLibrary.getIsEmptyUserList());
        assertEquals(4,bibliotecaLibrary.getUserList().size());
    }

    @Test
    public void testValidateUserInput() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        assertFalse(bibliotecaApp.validateUserInput(4));
        assertTrue(bibliotecaApp.validateUserInput(2));
        assertTrue(bibliotecaApp.validateUserInput(1));
    }

    @Test
    public void testCheckOutUserBook() {
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

    @Test
    public void testMovie() {
        Movie movie = new Movie("Movie Name",2015,"Director Name",4.3f);
        assertEquals("Movie Name",movie.getName());
        assertEquals(2015, movie.getYear());
        assertEquals("Director Name", movie.getDirector());
        assertEquals(4.3f, movie.getRating(), 0.01);
        assertFalse(movie.getIsCheckedOut());

        Movie movie2 = new Movie("Movie 2",2009,"Director 2",4);
        assertEquals("Movie 2", movie2.getName());
        assertEquals(2009, movie2.getYear());
        assertEquals("Director 2", movie2.getDirector());
        assertEquals(4f, movie2.getRating(), 0.01);
        movie2.setIsCheckedOut();
        assertTrue(movie2.getIsCheckedOut());
    }

    @Test
    public void testCheckOutUserMovie() {
        User user = new User();
        String moviename="Tollywood Movie";
        BibliotecaLibrary bibliotecaLibrary = new BibliotecaLibrary();
        user.setIsSet();
        user.setUserName("muskan1");
        assertFalse(user.checkOutMovie(moviename, bibliotecaLibrary));

        bibliotecaLibrary.initializeLibrary();
        assertFalse(bibliotecaLibrary.getIsEmptyMovieList());
        assertTrue(user.checkOutMovie(moviename, bibliotecaLibrary));
    }

    @Test
    public void testCheckOutMovie() {
        BibliotecaLibrary bibliotecaLibrary = new BibliotecaLibrary();
        String moviename="Tollywood Movie";
        Movie movie = bibliotecaLibrary.checkOutMovie(moviename);
        assertEquals(null, movie);

        bibliotecaLibrary.initializeLibrary();
        movie=bibliotecaLibrary.checkOutMovie(moviename);
        assertEquals(true, movie.getIsCheckedOut());
    }

    @Test
    public void testUser() {
        User user = new User("User Name","123-4567","password","email",987654321);
        assertEquals("User Name",user.getUserName());
        assertEquals("123-4567",user.getLibraryNumber());
        assertEquals("password",user.getPassword());
        assertEquals("email",user.getEmail());
        assertEquals(987654321,user.getContact());

        User user2 = new User("User 2","123-4568","password2","email2",07654321);
        assertEquals("User 2", user2.getUserName());
        assertEquals("123-4568", user2.getLibraryNumber());
        assertEquals("password2", user2.getPassword());
        assertEquals("email2",user2.getEmail());
        assertEquals(07654321,user2.getContact());
    }

    @Test
    public void testValidateUser() {
        BibliotecaLibrary bibliotecaLibrary=new BibliotecaLibrary();
        ArrayList a = bibliotecaLibrary.validateUser("User1","678-6789","password");
        assertEquals(a.get(0), false);
        ArrayList b = bibliotecaLibrary.validateUser("User1", "123-1234", "password1");
        assertEquals(b.get(0), false);

        bibliotecaLibrary.initializeLibrary();
        ArrayList c = bibliotecaLibrary.validateUser("User1","678-6789","password");
        assertEquals(c.get(0), false);
        ArrayList d = bibliotecaLibrary.validateUser("User1","123-1234","password1");
        assertEquals(d.get(0), true);
    }
}
