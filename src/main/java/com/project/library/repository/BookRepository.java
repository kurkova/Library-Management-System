package com.project.library.repository;

import com.project.library.domain.Book;
import org.springframework.data.repository.CrudRepository;


import java.util.List;


public interface BookRepository extends CrudRepository<Book, Long> {
    @Override
    List<Book> findAll();

    @Override
    Book save (Book bookCopy);
}
