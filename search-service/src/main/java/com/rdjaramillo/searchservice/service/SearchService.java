package com.rdjaramillo.searchservice.service;

import com.rdjaramillo.searchservice.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {

    @Autowired
    RestTemplate restTemplate;

    public List<Book> getBooksTitle(String title){
        List<Book> books = restTemplate.getForObject("http://bookcatalog-service/book/title/"+title, List.class);
        return books;
     }

    public List<Book> getBooksAuthor(String author){
        List<Book> books = restTemplate.getForObject("http://bookcatalog-service/book/author/"+author, List.class);
        return books;
    }

    public List<Book> getBooksGender(String gender){
        List<Book> books = restTemplate.getForObject("http://bookcatalog-service/book/gender/"+gender, List.class);
        return books;
    }
}


