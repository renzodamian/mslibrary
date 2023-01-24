package com.rdjaramillo.searchservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@NoArgsConstructor @AllArgsConstructor
public class Book {

    private String title;
    private String author;
    private String gender;
    private String description;
    private String publisher;
    private int  stock;
    private int availability;
}
