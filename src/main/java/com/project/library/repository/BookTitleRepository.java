package com.project.library.repository;
import com.project.library.domain.BookTitle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;


public interface BookTitleRepository extends CrudRepository<BookTitle, Long> {
    @Override
    List<BookTitle> findAll();

    Optional<BookTitle> findByTitle(String title);
}
