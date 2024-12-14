package main.com.library.controller;


import main.com.library.entity.Book;
import main.com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    // Endpoint to get all books
    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/search")
    public List<Book> getBooksByAuthor(@RequestParam String author) {
        return bookRepository.findByAuthorContainingIgnoreCase(author);
    }

    // Other CRUD methods...
}