package org.example;

import org.example.domain.Author;
import org.example.domain.Book;
import org.springframework.context.annotation.Bean;

public class AppCnfg {
    @Bean("Book1")
    public Book getBook1(){
        return new Book(101,"Mocking Bird",500.00);
    }

    @Bean("Book2")
    public Book getBook2(){
        return new Book(102,"Rich Dad",400);
    }

    @Bean("Auth1")
    public Author getAuthor1(){
        return new Author("Kalyan",566);
    }

    @Bean("Auth2")
    public Author getAuthor2(){
        return new Author("Ashok",5588);
    }
}
