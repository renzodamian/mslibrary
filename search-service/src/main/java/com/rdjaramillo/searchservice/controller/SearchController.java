package com.rdjaramillo.searchservice.controller;

import com.rdjaramillo.searchservice.model.Book;
import com.rdjaramillo.searchservice.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    SearchService searchService;

    @GetMapping("/title/{title}")
    public ResponseEntity<List<Book>> getBookList(@PathVariable("title") String title){
        List<Book> books = searchService.getBooksTitle(title);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/author/{author}")
    public ResponseEntity<List<Book>> getBooksAuthor(@PathVariable("author") String author){
        List<Book> books = searchService.getBooksAuthor(author);
        return ResponseEntity.ok(books);
    }


    @GetMapping("/gender/{gender}")
    public ResponseEntity<List<Book>> getBooksGender(@PathVariable("gender") String gender){
        List<Book> books = searchService.getBooksGender(gender);
        return ResponseEntity.ok(books);
    }


}
