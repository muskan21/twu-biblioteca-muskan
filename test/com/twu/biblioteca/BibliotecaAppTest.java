package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

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

        Books book2=new Books("Book 2","Book 2 Author",2);
        assertEquals("Book 2",book2.getBookName());
        assertEquals("Book 2 Author",book2.getBookAuthor());
        assertEquals(2,book2.getYearPublished());
    }
}
