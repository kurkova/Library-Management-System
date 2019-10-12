package com.project.library.repository;

import com.project.library.domain.BookCopy;
import com.project.library.domain.BookStatus;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookCopyRepository extends CrudRepository<BookCopy, Long> {
    @Override
    List<BookCopy> findAll();

    @Override
    BookCopy save (BookCopy bookCopy);


}
