package fi.haagahelia.bookstore.repository;

import org.springframework.data.repository.CrudRepository;
import fi.haagahelia.bookstore.domain.Book;

// Handles database access for book (CRUD opretations) and is automatically implemented by Spring Data JPA
public interface BookRepository extends CrudRepository<Book, Long> {

}
