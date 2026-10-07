package fi.haagahelia.bookstore;

import fi.haagahelia.bookstore.domain.Book;
import fi.haagahelia.bookstore.domain.Category;
import fi.haagahelia.bookstore.repository.BookRepository;
import fi.haagahelia.bookstore.repository.CategoryRepository;
import fi.haagahelia.bookstore.domain.User;
import fi.haagahelia.bookstore.repository.UserRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean // Spring Boot creates and manages this object automatically
	// CommandLineRunner runs automatically after the app starts
	public CommandLineRunner run(BookRepository bookRepository, CategoryRepository categoryRepository,
			UserRepository userRepository) {
		// Lambda expression that runs after the application starts
		// Method without a name
		return (args) -> {
			// Save some books to the database
			bookRepository.save(new Book("Don Quixote", "Miguel de Cervantes", 1605, "978-0060934347", 12.99));
			bookRepository.save(new Book("Harry Potter and the Philosopher's Stone", "J. K. Rowling", 1997,
					"978-0590353427", 14.99));
			bookRepository
					.save(new Book("The Little Prince", "Antoine de Saint-Exupery", 1943, "978-0156012195", 9.99));
			categoryRepository.save(new Category("Fantasy"));
			categoryRepository.save(new Category("Fiction"));
			categoryRepository.save(new Category("History"));
			User user1 = new User();
			user1.setUsername("user");
			user1.setPasswordHash("$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6");
			user1.setEmail("user@example.com");
			user1.setRole("ROLE_USER");
			userRepository.save(user1);

			User user2 = new User();
			user2.setUsername("admin");
			user2.setPasswordHash("$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C");
			user2.setEmail("admin@example.com");
			user2.setRole("ROLE_ADMIN");
			userRepository.save(user2);
		};
	}

}