package fi.haagahelia.bookstore.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import fi.haagahelia.bookstore.repository.BookRepository;
import fi.haagahelia.bookstore.repository.CategoryRepository;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import fi.haagahelia.bookstore.domain.Book;


@Controller
public class BookController {
    private final BookRepository bookRepository; // Repository instance used to access the database and fetch all books
    private final CategoryRepository categoryRepository;
    // Inject the BookRepository into the controller
    public BookController(BookRepository bookRepository, CategoryRepository categoryRepository) {
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/booklist")
    public String bookList(Model model) {
        // Add all books from the database to the model so they can be displayed
        model.addAttribute("books", bookRepository.findAll());
        return "booklist";
    }

    // Only allow users with the ADMIN role to access this method
    @PreAuthorize ("hasRole('ADMIN')")
    // Delete the book id from the URL and redirect to the booklist page
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
        return "redirect:/booklist";
    }

    @GetMapping("/add")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", categoryRepository.findAll());
        return "addbook";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Book book) {
        bookRepository.save(book);
        return "redirect:/booklist";
    }

    // Edit the book with the given id and redirect to the addbook page
    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable Long id, Model model) {
        model.addAttribute("book", bookRepository.findById(id).get()); // .get() extracts the actual book
        model.addAttribute("categories", categoryRepository.findAll());
        return "addbook";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
}
