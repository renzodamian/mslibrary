package com.rdjaramillo.bookcatalogservice.service;

import com.rdjaramillo.bookcatalogservice.entity.Book;
import com.rdjaramillo.bookcatalogservice.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService{
    @Autowired
    BookRepository  bookRepository;

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
    public Book getBookById (int id){
        return bookRepository.findById(id).orElse(null);
    }

    public Book save(Book book) {
        Book newBook = bookRepository.save(book);
        return newBook;
    }
    public List<Book> getTitleBook(String title){
        return bookRepository.findByTitle(title);
    }

    public List<Book> getAuthorBook(String author){
        return bookRepository.findByAuthor(author);
    }

    public List<Book> getGenderBook(String gender){
        return bookRepository.findByGender(gender);
    }
}
