package com.project.library.service;

import com.project.library.domain.BookCopy;
import com.project.library.domain.BookTitle;
import com.project.library.repository.BookCopyRepository;
import com.project.library.repository.BookTitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    private BookTitleRepository bookTitleRepository;

    @Autowired
    private BookCopyRepository bookCopyRepository;

    private BookTitle saveBookTitle (BookTitle bookTitle){
        return bookTitleRepository.save(bookTitle);
    }

    private BookCopy saveBookCopy (BookCopy bookCopy){
        return bookCopyRepository.save(bookCopy);
    }

}
