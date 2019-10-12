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

//    public BookTitle mapToBookTitle (final BookTitleDto bookTitleDto){
//        return new BookTitle(
//                bookTitleDto.getId(),
//                bookTitleDto.getTitle(),
//                bookTitleDto.getAuthor(),
//                bookTitleDto.getYearOfPublication(),
//        );
//    }

    public BookTitleDto mapToBookTitleDto (final BookTitle bookTitle){
        return new BookTitleDto(
                bookTitle.getId(),
                bookTitle.getTitle(),
                bookTitle.getAuthor(),
                bookTitle.getYearOfPublication()
        );
    }

    public List<BookTitleDto> mapToBookTitleDtoList (final List<BookTitle> bookTitlesList){
        return bookTitlesList.stream()
                .map(b-> new BookTitleDto(b.getId(), b.getTitle(), b.getAuthor(), b.getYearOfPublication()))
                .collect(Collectors.toList());
    }

//    public BookCopy mapToBookCopy (final BookCopyDto bookCopyDto){
//        return new BookCopy(
//                bookCopyDto.getId(),
//                bookCopyDto.getBookTitleId(),
//                bookCopyDto.getBookStatusId()
//        );
//    }

    public BookCopyDto mapToBookCopyDto (final BookCopy bookCopy){
        return new BookCopyDto(
                bookCopy.getId(),
                bookCopy.getBookTitleId(),
                bookCopy.getBookStatus()
        );
    }

    public List<BookCopyDto> mapToBookCopyDtoList (final List<BookCopy> bookCopyList){
        return bookCopyList.stream()
                .map(b -> new BookCopyDto(b.getId(), b.getBookTitleId(), b.getBookStatus()))
                .collect(Collectors.toList());
    }

    public BookHire mapToBookHire (final BookHireDto bookHireDto){
        return new BookHire(
                bookHireDto.getId(),
                bookHireDto.getUserId(),
                bookHireDto.getBookCopyId(),
                bookHireDto.getRentalDate(),
                bookHireDto.getReturnDate()
        );
    }

    public BookHireDto mapToBookHireDto (final BookHire bookHire){
        return new BookHireDto(
                bookHire.getId(),
                bookHire.getUserId(),
                bookHire.getBookCopyId(),
                bookHire.getRentalDate(),
                bookHire.getReturnDate()
        );
    }

    public List<BookHireDto> mapToBookHireDto (final List<BookHire> bookHireList){
        return bookHireList.stream()
                .map(b -> new BookHireDto(b.getId(), b.getUserId(), b.getBookCopyId(), b.getRentalDate(), b.getReturnDate()))
                .collect(Collectors.toList());
    }
}
