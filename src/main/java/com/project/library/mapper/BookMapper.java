package com.project.library.mapper;
import com.project.library.controller.Exception.BookNotFoundException;
import com.project.library.controller.Exception.UserNotFoundException;
import com.project.library.domain.Book;
import com.project.library.domain.BookHire;
import com.project.library.domain.BookTitle;
import com.project.library.dto.BookDto;
import com.project.library.dto.BookHireDto;
import com.project.library.dto.BookTitleDto;
import com.project.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookMapper {
    private BookService bookService;

    public BookMapper(BookService bookService) {
        this.bookService = bookService;
    }

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
                book.getBookTitleId(),
                book.getBookStatus(),
                mapToBookHireDtoList(book.getBookHires())
        );
    }

    public Book mapToBook(final BookDto bookDto) throws BookNotFoundException, UserNotFoundException{
        return new Book(
                bookDto.getId(),
                bookDto.getBookTitleId(),
                bookDto.getBookStatusId(),
                mapToBookHireList(bookDto.getBookHires())
        );
    }

    public BookHireDto mapToBookHireDto(final BookHire bookHire) {
        return new BookHireDto(
                bookHire.getId(),
                bookHire.getUserId(),
                bookHire.getBookId(),
                bookHire.getRentalDate(),
                bookHire.getReturnDate()
        );
    }

    public List<BookHire> mapToBookHireList(final List<BookHireDto> bookHireDtoList)  {
        return bookHireDtoList.stream()
                .map(b -> new BookHire(b.getId(), b.getUserId(), b.getBookId(), b.getRentalDate(), b.getReturnDate()))
                .collect(Collectors.toList());
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
