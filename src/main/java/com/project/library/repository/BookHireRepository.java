package com.project.library.repository;

import com.project.library.domain.BookHire;
import org.springframework.data.repository.CrudRepository;


import java.util.Optional;

public interface BookHireRepository extends CrudRepository <BookHire, Long> {

    Optional<BookHire> findUsersBookHire (Long bookHireId, Long userId);
}
