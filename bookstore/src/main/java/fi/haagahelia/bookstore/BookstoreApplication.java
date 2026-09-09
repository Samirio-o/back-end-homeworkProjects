package fi.haagahelia.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import fi.haagahelia.bookstore.domain.Book;
import fi.haagahelia.bookstore.repository.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean // Spring Boot creates and manages this object automatically
	// CommandLineRunner runs automatically after the app starts
	public CommandLineRunner run(BookRepository bookRepository) {
		return (args) -> {
			// Save some books to the database
			bookRepository.save(new Book("Book1", "Author1", 2025, "isbn1", 10.99));
			bookRepository.save(new Book("Book2", "Author2", 2026, "isbn2", 7.99));
		};
	}

}
