package com.bsanju.bookstore.controller;

import com.bsanju.bookstore.kafka.BookEventProducer;
import com.bsanju.bookstore.model.Book;
import com.bsanju.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookEventProducer bookEventProducer;

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        Book saved = bookRepository.save(book);
        String event = "NEWBOOK " + book.getTitle() + " by " + book.getAuthor() +" for $ " +book.getPrice()+ " added.";
        bookEventProducer.sendEvent(event);
        return saved;
    }

    @PostMapping("/{id}/purchase")
    public String purchaseBook(@PathVariable Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        String event = "PURCHASE '" + book.getTitle() + "' was purchased.";
        bookEventProducer.sendEvent(event);
        return "Book purchased: " + book.getTitle();
    }
}
