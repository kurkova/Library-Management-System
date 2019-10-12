package com.project.library.mapper;

import com.project.library.domain.BookTitle;
import com.project.library.dto.BookTitleDto;
import com.project.library.repository.BookTitleRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookMapper {

//    public BookTitle mapToBookTitle (final BookTitleDto bookTitleDto){
//        return new BookTitle(
//                bookTitleDto.getId(),
//                bookTitleDto.getTitle(),
//                bookTitleDto.getAuthor(),
//                bookTitleDto.getYearOfPublication()
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

}
