package com.project.library.repository;
import com.project.library.domain.BookHire;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface BookHireRepository extends CrudRepository <BookHire, Long> {
    @Override
    List<BookHire> findAll();


    Optional<BookHire> findByUserIdAndBookId(Long userId, Long BookId);
}
