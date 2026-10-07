package fi.haagahelia.bookstore.repository;

import fi.haagahelia.bookstore.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
