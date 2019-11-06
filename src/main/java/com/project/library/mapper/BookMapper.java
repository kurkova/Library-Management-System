package com.project.library.mapper;

import com.project.library.controller.Exception.BookNotFoundException;
import com.project.library.controller.Exception.BookTitleNotFoundException;
import com.project.library.controller.Exception.UserNotFoundException;
import com.project.library.domain.Book;
import com.project.library.domain.BookHire;
import com.project.library.domain.BookTitle;
import com.project.library.dto.BookDto;
import com.project.library.dto.BookHireDto;
import com.project.library.dto.BookTitleDto;
import com.project.library.service.BookService;
import com.project.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookMapper {

    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

    public BookTitle mapToBookTitle(final BookTitleDto bookTitleDto) {
        return new BookTitle(
                bookTitleDto.getId(),
                bookTitleDto.getTitle(),
                bookTitleDto.getAuthor(),
                bookTitleDto.getYearOfPublication(),
                bookService.getAvailableBooks(bookTitleDto.getTitle())
        );
    }

    public BookDto mapToBookDto(final Book book) {
        return new BookDto(
                book.getId(),
                book.getBookTitleId().getId(),
                book.getBookStatus(),
                mapToBookHireDtoList(book.getBookHires())
        );
    }

    public Book mapToBook(final BookDto bookDto) throws BookTitleNotFoundException, BookNotFoundException, UserNotFoundException {
        return new Book(
                bookDto.getId(),
                bookService.getBookTitle(bookDto.getBookTitleId()),
                bookDto.getBookStatusId(),
                mapToBookHireList(bookDto.getBookHires())
        );
    }

    public BookHireDto mapToBookHireDto(final BookHire bookHire) {
        return new BookHireDto(
                bookHire.getId(),
                bookHire.getUserId().getId(),
                bookHire.getBookId().getId(),
                bookHire.getRentalDate(),
                bookHire.getReturnDate()
        );
    }

    public BookHire mapToBookHire(final BookHireDto bookHireDto) throws BookNotFoundException, UserNotFoundException {
        return new BookHire(
                bookHireDto.getId(),
                userService.getUser(bookHireDto.getUserId()),
                bookService.getBook(bookHireDto.getBookId()),
                bookHireDto.getRentalDate(),
                bookHireDto.getReturnDate()
        );
    }


    public List<BookHire> mapToBookHireList(final List<BookHireDto> booksHireDtoList) throws BookNotFoundException, UserNotFoundException {
        List<BookHire> booksHire = new ArrayList<>();

        for (BookHireDto book : booksHireDtoList) {
            booksHire.add(mapToBookHire(book));
        }

        return booksHire;

    }

    public List<BookHireDto> mapToBookHireDtoList(final List<BookHire> bookHireList) {
        return bookHireList.stream()
                .map(this::mapToBookHireDto)
                .collect(Collectors.toList());
    }

    public List<BookDto> mapToBookDtoList(final List<Book> booksList) {
        return booksList.stream()
                .map(this::mapToBookDto)
                .collect(Collectors.toList());
    }
}
