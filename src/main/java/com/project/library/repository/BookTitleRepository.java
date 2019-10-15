package com.project.library.repository;

import com.project.library.domain.BookTitle;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BookTitleRepository extends CrudRepository<BookTitle, Long> {
    @Override
    BookTitle save (BookTitle bookTitle);

    List<BookTitle> findAll();

    Optional<BookTitle> findByTitile(String title);
}
