package com.rdjaramillo.bookcatalogservice.controller;

import com.rdjaramillo.bookcatalogservice.entity.Book;
import com.rdjaramillo.bookcatalogservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping()
    public ResponseEntity<List<Book>> getAll(){
        List<Book> books = bookService.getAllBooks();
        if (books.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id")int id) {
        Book book = bookService.getBookById(id);
        if (book == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(book);
    }

    @PostMapping()
    public ResponseEntity<Book> addUser(@RequestBody Book book) {
        Book newUser = bookService.save(book);
        return ResponseEntity.ok(newUser);
    }
    @GetMapping("/title/{title}")
    public ResponseEntity<List<Book>> getTitleBook(@PathVariable("title")String title) {
        List<Book> books= bookService.getTitleBook(title);
        if (books == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(books);
    }

    @GetMapping("/author/{author}")
    public ResponseEntity<List<Book>> getAuthorBook(@PathVariable("author")String author) {
        List<Book> books= bookService.getAuthorBook(author);
        if (books == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(books);
    }


    @GetMapping("/gender/{gender}")
    public ResponseEntity<List<Book>> getGenderBook(@PathVariable("gender")String gender) {
        List<Book> books= bookService.getGenderBook(gender);
        if (books == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(books);
    }

}
