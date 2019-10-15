package com.project.library.mapper;

import com.project.library.domain.BookCopy;
import com.project.library.domain.BookHire;
import com.project.library.domain.BookTitle;
import com.project.library.dto.BookCopyDto;
import com.project.library.dto.BookHireDto;
import com.project.library.dto.BookTitleDto;
import com.project.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookMapper {

    @Autowired
    BookService bookService;

    public BookTitle mapToBookTitle(final BookTitleDto bookTitleDto) {
        return new BookTitle(
                bookTitleDto.getId(),
                bookTitleDto.getTitle(),
                bookTitleDto.getAuthor(),
                bookTitleDto.getYearOfPublication(),
                bookService.getAvailableBooksCopy(bookTitleDto.getTitle())
        );
    }

    public BookTitleDto mapToBookTitleDto(final BookTitle bookTitle) {
        return new BookTitleDto(
                bookTitle.getId(),
                bookTitle.getTitle(),
                bookTitle.getAuthor(),
                bookTitle.getYearOfPublication(),
                mapToBookCopyDtoList(bookTitle.getBooks())
        );
    }

    public BookCopy maptToBookCopy(final BookCopyDto bookCopyDto) {
        return new BookCopy(
                bookCopyDto.getId(),
                bookCopyDto.getBookTitleId(),
                bookCopyDto.getBookStatusId(),
                mapToBookHireList(bookCopyDto.getBookHires())
        );
    }

    public BookCopyDto mapToBookCopyDto(final BookCopy bookCopy) {
        return new BookCopyDto(
                bookCopy.getId(),
                bookCopy.getBookTitleId(),
                bookCopy.getBookStatus(),
                mapToBookHireDtoList(bookCopy.getBookHires())
        );
    }

    public BookCopy mapToBookCopy(final BookCopyDto bookCopyDto) {
        return new BookCopy(
                bookCopyDto.getId(),
                bookCopyDto.getBookTitleId(),
                bookCopyDto.getBookStatusId(),
                mapToBookHireList(bookCopyDto.getBookHires())
        );
    }


    public BookHireDto mapToBookHireDto(final BookHire bookHire) {
        return new BookHireDto(
                bookHire.getId(),
                bookHire.getUserId(),
                bookHire.getBookCopyId(),
                bookHire.getRentalDate(),
                bookHire.getReturnDate()
        );
    }

    public List<BookHire> mapToBookHireList(final List<BookHireDto> bookHireDtoList) {
        return bookHireDtoList.stream()
                .map(b -> new BookHire(b.getId(), b.getUserId(), b.getBookCopyId(), b.getRentalDate(), b.getReturnDate()))
                .collect(Collectors.toList());
    }

    public List<BookHireDto> mapToBookHireDtoList(final List<BookHire> bookHireList) {
        return bookHireList.stream()
                .map(this::mapToBookHireDto)
                .collect(Collectors.toList());
    }

    public List<BookCopy> mapToListBookCopyList(final List<BookCopyDto> booksCopyDtoList) {
        return booksCopyDtoList.stream()
                .map(this::mapToBookCopy)
                .collect(Collectors.toList());
    }

    public List<BookCopyDto> mapToBookCopyDtoList(final List<BookCopy> booksCopyList) {
        return booksCopyList.stream()
                .map(this::mapToBookCopyDto)
                .collect(Collectors.toList());
    }

    public List<BookTitle> mapToBookTitleDtoList(final List<BookTitleDto> booksTitleDto) {
        return booksTitleDto.stream()
                .map(this::mapToBookTitle)
                .collect(Collectors.toList());
    }

    public List<BookTitleDto> mapToBookTitleList(final List<BookTitle> booksTitleList) {
        return booksTitleList.stream()
                .map(this::mapToBookTitleDto)
                .collect(Collectors.toList());
    }
}
