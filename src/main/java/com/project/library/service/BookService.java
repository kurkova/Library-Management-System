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

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BookService {
    private BookTitleRepository bookTitleRepository;
    private BookRepository bookRepository;
    private BookHireRepository bookHireRepository;
    private UserService userService;


    public BookService(BookTitleRepository bookTitleRepository, BookRepository bookRepository, BookHireRepository bookHireRepository, UserService userService) {
        this.bookTitleRepository = bookTitleRepository;
        this.bookRepository = bookRepository;
        this.bookHireRepository = bookHireRepository;
        this.userService = userService;
    }

    public BookTitle addBookTitle (BookTitle bookTitle){
        return bookTitleRepository.save(bookTitle);
    }

    public Book saveBook (Book book){
        return bookRepository.save(book);
    }


    public List<Book> getAvailableBooks (String title){

        List<Book> availableBooks = new ArrayList<>();
        BookTitle  bookTitle = bookTitleRepository.findByTitle(title).orElse(null);

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
        User user = userService.getUser(userId);


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

    public void returnBook(Long userId, Long bookId, BookStatus bookStatus) throws BookNotFoundException, UserNotFoundException{
        BookHire bookHire = bookHireRepository.findUsersBookHire(userId, bookId ).orElseThrow(BookNotFoundException::new);
        Book book = bookHire.getBookId();
        book.setBookStatus(bookStatus);
        bookHire.setReturnDate(LocalDate.now());
        bookRepository.save(book);
        bookHireRepository.save(bookHire);
    }

    public BookTitle getBookTitle(Long id) throws BookTitleNotFoundException {
        return bookTitleRepository.findById(id).orElseThrow(BookTitleNotFoundException::new);
    }

    public Book getBook(Long id) throws BookNotFoundException {
        return bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
    }
}
