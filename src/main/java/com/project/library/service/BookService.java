package com.project.library.service;

import com.project.library.domain.BookCopy;
import com.project.library.domain.BookHire;
import com.project.library.domain.BookStatus;
import com.project.library.domain.BookTitle;
import com.project.library.repository.BookCopyRepository;
import com.project.library.repository.BookHireRepository;
import com.project.library.repository.BookTitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookTitleRepository bookTitleRepository;

    @Autowired
    private BookCopyRepository bookCopyRepository;

    @Autowired
    private BookHireRepository bookHireRepository;

    public BookTitle saveBookTitle (BookTitle bookTitle){
        return bookTitleRepository.save(bookTitle);
    }

    public BookCopy saveBookCopy (BookCopy bookCopy){
        return bookCopyRepository.save(bookCopy);
    }


    public List<BookCopy> getAvailableBooksCopy (String title){

        List<BookCopy> availableBooks = new ArrayList<>();
        BookTitle  bookTitle = bookTitleRepository.findByTitile(title).orElse(null);

        if (bookTitle != null){
            for (BookCopy bookCopy: bookTitle.getBooks()){
                if (bookCopy.getBookStatus().equals(BookStatus.IN_LIBRARY)){
                    availableBooks.add(bookCopy);
                }

            }
        }
        return new ArrayList<>();
    }

    public List<BookHire> getUserBooksHire(Long userId, Long bookHireId){
         bookHireRepository.findUsersBookHire(userId, bookHireId);
         return new ArrayList<>();
    }
}
