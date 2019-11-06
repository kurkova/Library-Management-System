package com.project.library.repository;
import com.project.library.domain.User;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    @Override
    List<User> findAll();

    Optional<User> findById(Long id);

    @Override
    User save (User user);
}
