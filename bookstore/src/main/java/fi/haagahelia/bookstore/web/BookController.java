package fi.haagahelia.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import fi.haagahelia.bookstore.repository.BookRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import fi.haagahelia.bookstore.domain.Book;



@Controller
public class BookController {
    private final BookRepository bookRepository; // Repository instance used to access the database and fetch all books

    // Inject the BookRepository into the controller
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/booklist")
    public String bookList(Model model) {
        // Add all books from the database to the model so they can be displayed
        model.addAttribute("books", bookRepository.findAll());
        return "booklist";
    }

    // Delete the book id from the URL and redirect to the booklist page
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
        return "redirect:/booklist";
    }

    @GetMapping("/add")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        return "addbook";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Book book) {
        bookRepository.save(book);
        return "redirect:/booklist";
    }
    
    
}
