package com.project.library.controller;

import com.project.library.controller.Exception.BookNotFoundException;
import com.project.library.controller.Exception.BookTitleNotFoundException;
import com.project.library.controller.Exception.UserNotFoundException;
import com.project.library.domain.BookStatus;
import com.project.library.dto.BookDto;
import com.project.library.dto.BookTitleDto;
import com.project.library.mapper.BookMapper;

import com.project.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1/book")
public class BookController {

    private BookMapper bookMapper;
    private BookService bookService;

    public BookController(BookMapper bookMapper, BookService bookService) {
        this.bookMapper = bookMapper;
        this.bookService = bookService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/add_BookTitle", consumes = APPLICATION_JSON_VALUE)
    public void addBookTitle (BookTitleDto bookTitleDto){
        bookService.addBookTitle(bookMapper.mapToBookTitle(bookTitleDto));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/add_BookCopy", consumes = APPLICATION_JSON_VALUE)
    public void addBook (@RequestBody BookDto bookCopyDto) throws BookNotFoundException, UserNotFoundException, BookTitleNotFoundException {
        bookService.saveBook(bookMapper.mapToBook(bookCopyDto));
    }

    @RequestMapping(method =  RequestMethod.GET, value = "/getAvailableBooks")
    public List<BookDto> getAvailableBooks (@RequestParam String title){
        return bookMapper.mapToBookDtoList(bookService.getAvailableBooks(title));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "rentBook")
    public void rentBook (@RequestParam Long userId, @RequestParam Long bookId) throws UserNotFoundException, BookNotFoundException{
            bookService.rentBook(userId, bookId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "returnBook")
    public void returnBook (@RequestParam Long userId, @RequestParam Long bookId, @RequestParam BookStatus bookStatus) throws BookNotFoundException, UserNotFoundException{
        bookService.returnBook(userId, bookId, bookStatus);
    }

}
