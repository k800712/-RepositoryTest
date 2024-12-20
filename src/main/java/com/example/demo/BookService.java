package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book create(CreateBookRequest request) {
        Book book = new Book(request.title(), request.author(),
                request.isbn(), request.price(), request.publishedYear());
       bookRepository.save(book);
        return book;
    }

    public List<Book> bookList(){
        return bookRepository.findAll();
    }
}
