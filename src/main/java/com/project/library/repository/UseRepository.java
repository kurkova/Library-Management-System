package com.project.library.repository;

import com.project.library.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UseRepository extends CrudRepository<User, Long> {
    @Override
    List<User> findAll();
}
