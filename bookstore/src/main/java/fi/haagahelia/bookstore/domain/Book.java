package fi.haagahelia.bookstore.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // It tells to JPA that the class will be mapped to a table in the database
public class Book {
    private String title;
    private String author;
    private int publicationYear;
    private String isbn;
    private double price;
    @Id // Identifies the primary key of the table
    @GeneratedValue(strategy = GenerationType.AUTO) // The value of id will be generated automatically
    private Long id; // Unique identifier for each book, Long is used because can be null

    public Book(String title, String author, int publicationYear, String isbn, double price) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.price = price;
    }

    public Book() {
    
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public String getIsbn() {
        return isbn;
    }

    public double getPrice() {
        return price;
    }

    public Long getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}