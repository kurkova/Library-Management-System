package com.project.library.controller;

import com.project.library.dto.BookCopyDto;
import com.project.library.dto.BookTitleDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class BookController {

    @RequestMapping(method = RequestMethod.POST, value = "/bookTile")
    public void addBookTitle (BookTitleDto bookTitleDto){
    }

    @RequestMapping(method = RequestMethod.POST, value = "/bookCopy")
    public void addBookCopy (BookCopyDto bookCopyDto){
    }

    public List<BookCopyDto> getAvailableBooks (String title){
        return new ArrayList<>();
    }

    public void returnBook(Long id){

    }

    public void updateStatusBook(Long id){

    }
}
