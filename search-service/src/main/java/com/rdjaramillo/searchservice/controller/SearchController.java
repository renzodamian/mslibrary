package com.rdjaramillo.searchservice.controller;

import com.rdjaramillo.searchservice.model.Book;
import com.rdjaramillo.searchservice.service.SearchService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    SearchService searchService;

    @CircuitBreaker(name = "titleCB", fallbackMethod = "fallbackListTitles")
    @GetMapping("/title/{title}")
    public ResponseEntity<List<Book>> getBookList(@PathVariable("title") String title){
        List<Book> books = searchService.getBooksTitle(title);
        return ResponseEntity.ok(books);
    }

    @CircuitBreaker(name = "authorCB", fallbackMethod = "fallbackListAuthors")
    @GetMapping("/author/{author}")
    public ResponseEntity<List<Book>> getBooksAuthor(@PathVariable("author") String author){
        List<Book> books = searchService.getBooksAuthor(author);
        return ResponseEntity.ok(books);
    }


    @CircuitBreaker(name = "genderCB", fallbackMethod = "fallbackListGenders")
    @GetMapping("/gender/{gender}")
    public ResponseEntity<List<Book>> getBooksGender(@PathVariable("gender") String gender){
        List<Book> books = searchService.getBooksGender(gender);
        return ResponseEntity.ok(books);
    }
    private ResponseEntity<List<Book>> fallbackListTitles(@PathVariable("title") String title, RuntimeException e) {
        return new ResponseEntity("El titulo " + title + " no esta registrado en la biblioteca", HttpStatus.OK);
    }


    private ResponseEntity<List<Book>> fallbackListAuthors(@PathVariable("author") String author, RuntimeException e) {
        return new ResponseEntity("El autor " + author + " no esta registra  en la biblioteca", HttpStatus.OK);
    }

    private ResponseEntity<List<Book>> fallbackListGenders(@PathVariable("gender") String gender, RuntimeException e) {
        return new ResponseEntity("El genero " + gender + " no esta registra  en la biblioteca", HttpStatus.OK);
    }


}
