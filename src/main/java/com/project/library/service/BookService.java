package com.project.library.service;

import com.project.library.controller.BookNotFoundException;
import com.project.library.controller.UserNotFoundException;
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


    public BookTitle saveBookTitle (BookTitle bookTitle){
        return bookTitleRepository.save(bookTitle);
    }

    public Book saveBookCopy (Book bookCopy){
        return bookRepository.save(bookCopy);
    }


    public List<Book> getAvailableBooksCopy (String title){

        List<Book> availableBooks = new ArrayList<>();
        BookTitle  bookTitle = bookTitleRepository.findByTitile(title).orElse(null);

        if (bookTitle != null){
            for (Book book: bookTitle.getBooks()){
                if (book.getBookStatus().equals(BookStatus.IN_LIBRARY)){
                    availableBooks.add(book);
                }

            }
        }
        return availableBooks;
    }

    public List<BookHire> getUserBooksHire(Long userId, Long bookHireId){
         bookHireRepository.findUsersBookHire(userId, bookHireId);
         return new ArrayList<>();
    }

    public void rentBook(Long userId, Long bookId) throws  BookNotFoundException, UserNotFoundException{
        Book book = bookRepository.findById(bookId).orElseThrow(BookNotFoundException::new);
        User user = userService.getUser(userId).orElseThrow(UserNotFoundException::new);

        if(book.getBookStatus().equals(BookStatus.IN_LIBRARY)){
            BookHire bookHire = new BookHire();
            bookHire.setBookId(book);
            bookHire.setUserId(user);
            bookHire.setRentalDate(LocalDate.now());
            bookHire.setReturnDate(LocalDate.now().plusDays(60));
            bookHireRepository.save(bookHire);
            book.setBookStatus(BookStatus.LOANED);
            bookRepository.save(book);
        } else {
            throw new BookNotFoundException();
        }
    }

    public void returnBook(Long userId, BookStatus bookStatus, Long bookId) throws BookNotFoundException{
        BookHire bookHire = bookHireRepository.findUsersBookHire(userId, bookId ).orElseThrow(BookNotFoundException::new);
        Book book = bookHire.getBookId();
        book.setBookStatus(bookStatus);
        bookHire.setReturnDate(LocalDate.now());
        bookRepository.save(book);
        bookHireRepository.save(bookHire);
    }
}
