package com.project.library.repository;

import com.project.library.domain.BookTitle;
import org.springframework.data.repository.CrudRepository;

public interface BookTitleRepository extends CrudRepository<BookTitle, Long> {
    @Override
    BookTitle save (BookTitle bookTitle);
}
