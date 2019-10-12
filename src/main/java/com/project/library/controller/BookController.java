package com.project.library.controller;

import com.project.library.dto.BookCopyDto;
import com.project.library.dto.BookTitleDto;
import com.project.library.repository.BookCopyRepository;
import com.project.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1")
public class BookController {
    @Autowired
    private BookCopyRepository bookCopyRepository;

    @Autowired
    private BookService bookService;

    @RequestMapping(method = RequestMethod.POST, value = "/add_BookTitle")
    public void addBookTitle (BookTitleDto bookTitleDto){
    }

    @RequestMapping(method = RequestMethod.POST, value = "/add_BookCopy", consumes = APPLICATION_JSON_VALUE)
    public void addBookCopy (@RequestBody BookCopyDto bookCopyDto){

    }

    public List<BookCopyDto> getAvailableBooks (String title){
        return new ArrayList<>();
    }

    public void returnBook(Long id){

    }

    public void updateStatusBook(Long id){

    }
}
