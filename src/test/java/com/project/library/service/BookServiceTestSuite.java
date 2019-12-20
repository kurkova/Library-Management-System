package com.project.library.service;

import com.project.library.controller.Exception.BookNotFoundException;
import com.project.library.controller.Exception.BookTitleNotFoundException;
import com.project.library.controller.Exception.UserNotFoundException;
import com.project.library.domain.Book;
import com.project.library.domain.BookStatus;
import com.project.library.domain.BookTitle;
import com.project.library.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class BookServiceTestSuite {

    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

    @Test
    public void getBookTitleTest() throws BookTitleNotFoundException {
        //Given
        BookTitle bookTitleOne = new BookTitle(1L, "Pan Tadeusz", "nieznnay", 1991, new ArrayList<>());
        bookService.saveBookTitle(bookTitleOne);
        //When
        BookTitle bookTitle = bookService.getBookTitle(1L);
        //Then
        assertEquals(bookTitleOne, bookTitle);
    }


    @Test
    public void getBookTest() throws BookNotFoundException {
        //Given
        BookTitle bookTitleOne = new BookTitle(1L, "Pan Tadeusz", "nieznnay", 1991, new ArrayList<>());
        bookService.saveBookTitle(bookTitleOne);

        Book book = new Book(1L, bookTitleOne, BookStatus.AVAILABLE, new ArrayList<>());
        bookService.saveBook(book);
        //When
        Book savedBook = bookService.getBook(1L);
        //Then
        assertEquals(bookTitleOne.getId(), savedBook.getBookTitle().getId());
    }


    @Test
    public void saveBookTest() {
        //Given
        BookTitle bookTitleOne = new BookTitle(1L, "Pan Tadeusz", "nieznnay", 1991, new ArrayList<>());
        bookService.saveBookTitle(bookTitleOne);
        Book book = new Book(1L, bookTitleOne, BookStatus.AVAILABLE, new ArrayList<>());
        //When
        Book savedBook = bookService.saveBook(book);
        //Then
        assertEquals(book.getBookTitle(), savedBook.getBookTitle());
    }


    @Test
    public void getAvailableBooks() {
        //Given
        BookTitle bookTitleOne = new BookTitle(1L, "Pan Tadeusz", "nieznnay", 1991, new ArrayList<>());
        BookTitle bookTitleTwo = new BookTitle(2L, "Peter", "nieznnay", 1991, new ArrayList<>());
        bookService.saveBookTitle(bookTitleOne);
        bookService.saveBookTitle(bookTitleTwo);

        Book bookOne = new Book(3L, bookTitleOne, BookStatus.UNAVAILABLE, new ArrayList<>());
        Book bookTwo = new Book(4L, bookTitleOne, BookStatus.AVAILABLE, new ArrayList<>());
        Book bookThree = new Book(5L, bookTitleTwo, BookStatus.AVAILABLE, new ArrayList<>());
        //When
        bookService.saveBook(bookOne);
        bookService.saveBook(bookTwo);
        bookService.saveBook(bookThree);
        int availableBooks = bookService.getAvailableBooks("Peter").size();
        //Then
        assertEquals(1, availableBooks);
    }

    @Test
    public void rentBookTest() throws BookNotFoundException, UserNotFoundException {
        //Given
        BookTitle bookTitleOne = new BookTitle(1L, "Pan Tadeusz", "nieznnay", 1991, new ArrayList<>());
        bookService.saveBookTitle(bookTitleOne);

        Book book = new Book(1L, bookTitleOne, BookStatus.AVAILABLE, new ArrayList<>());
        bookService.saveBook(book);

        User user = new User(1L, "paula", "kurkova", LocalDate.now(), new ArrayList<>());
        userService.saveUser(user);
        //When
        bookService.rentBook(user.getId(), book.getId());
        BookStatus bookRentedStatus = bookService.getBook(1L).getBookStatus();
        //Then
        assertEquals(BookStatus.UNAVAILABLE, bookRentedStatus);
    }

    @Test
    public void returnBookTest() throws BookNotFoundException, UserNotFoundException {
        //Given
        BookTitle bookTitleOne = new BookTitle(1L, "Pan Tadeusz", "nieznnay", 1991, new ArrayList<>());
        bookService.saveBookTitle(bookTitleOne);

        Book book = new Book(1L, bookTitleOne, BookStatus.UNAVAILABLE, new ArrayList<>());
        bookService.saveBook(book);

        User user = new User(1L, "paula", "kurkova", LocalDate.now(), new ArrayList<>());
        userService.saveUser(user);

        //When
        bookService.returnBook(1L, 1L, BookStatus.AVAILABLE);
        BookStatus bookStatusAfter = bookService.getBook(1L).getBookStatus();
        //Then
        assertEquals(BookStatus.AVAILABLE, bookStatusAfter);

    }
}

