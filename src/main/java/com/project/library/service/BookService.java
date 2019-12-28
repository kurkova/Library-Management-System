package com.project.library.service;

import com.project.library.controller.Exception.BookNotFoundException;
import com.project.library.controller.Exception.BookTitleNotFoundException;
import com.project.library.controller.Exception.UserNotFoundException;
import com.project.library.domain.*;
import com.project.library.repository.BookHireRepository;
import com.project.library.repository.BookRepository;
import com.project.library.repository.BookTitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookTitleRepository bookTitleRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookHireRepository bookHireRepository;

    @Autowired
    private UserService userService;

    public BookTitle getBookTitle(Long id) throws BookTitleNotFoundException {
        return bookTitleRepository.findById(id).orElseThrow(BookTitleNotFoundException::new);
    }

    public Book getBook(Long id) throws BookNotFoundException {
        return bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
    }

    public BookTitle saveBookTitle(BookTitle bookTitle) {
        return bookTitleRepository.save(bookTitle);
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }


    public List<Book> getAvailableBooks(String title) {

        List<Book> availableBooks = new ArrayList<>();
        BookTitle bookTitle = bookTitleRepository.findByTitle(title).orElse(null);

        if (bookTitle != null) {
            for (Book book : bookTitle.getBooks()) {
                if (book.getBookStatus().equals(BookStatus.AVAILABLE)) {
                    availableBooks.add(book);
                }
            }
        }
        return availableBooks;
    }


    public void rentBook(Long userId, Long bookId) throws BookNotFoundException, UserNotFoundException {
        Book book = bookRepository.findById(bookId).orElseThrow(BookNotFoundException::new);
        User user = userService.getUser(userId);


        if (book.getBookStatus().equals(BookStatus.AVAILABLE)) {
            BookHire bookHire = new BookHire();
            bookHire.setBook(book);
            bookHire.setUser(user);
            bookHire.setRentalDate(LocalDate.now());
            bookHire.setReturnDate(LocalDate.now().plusDays(60));
            bookHireRepository.save(bookHire);
            book.setBookStatus(BookStatus.UNAVAILABLE);
            bookRepository.save(book);
        } else {
            throw new BookNotFoundException();
        }
    }

    public void returnBook(Long userId, Long bookId, BookStatus bookStatus) throws BookNotFoundException, UserNotFoundException {
        BookHire bookHire = bookHireRepository.findByUserIdAndBookId(userId, bookId).orElseThrow(BookNotFoundException::new);
        Book book = bookHire.getBook();
        book.setBookStatus(bookStatus);
        bookHire.setReturnDate(LocalDate.now());
        bookRepository.save(book);
        bookHireRepository.save(bookHire);
    }
}
