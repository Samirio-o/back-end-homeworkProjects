package fi.haagahelia.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import fi.haagahelia.bookstore.domain.Book;
import fi.haagahelia.bookstore.domain.Category;
import fi.haagahelia.bookstore.repository.BookRepository;
import fi.haagahelia.bookstore.repository.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean // Spring Boot creates and manages this object automatically
	// CommandLineRunner runs automatically after the app starts
	public CommandLineRunner run(BookRepository bookRepository, CategoryRepository categoryRepository) {
		// Lambda expression that runs after the application starts
		//Method without a name
		return (args) -> {
			// Save some books to the database
			bookRepository.save(new Book("Don Quixote", "Miguel de Cervantes", 1605, "978-0060934347", 12.99));
			bookRepository.save(new Book("Harry Potter and the Philosopher's Stone", "J. K. Rowling", 1997, "978-0590353427", 14.99));
			bookRepository.save(new Book("The Little Prince", "Antoine de Saint-Exupery", 1943, "978-0156012195", 9.99));
			categoryRepository.save(new Category("Fantasy"));
			categoryRepository.save(new Category("Fiction"));
			categoryRepository.save(new Category("History"));
		};
	}

}