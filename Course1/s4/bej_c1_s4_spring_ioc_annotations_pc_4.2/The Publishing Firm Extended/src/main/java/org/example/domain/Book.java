package org.example.domain;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Book {
    private int bookId;
    private String bookName;
    private double bookPrice;

    @Autowired
    private List<Author> author;

    public Book() {
    }

    public Book(int bookId, String bookName, double bookPrice) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookPrice = bookPrice;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

//    public Author getAuthor() {
//        return author;
//    }
//    //@Autowired
//    public void setAuthor(Author author) {
//        this.author = author;
//    }


    public List<Author> getAuthor() {
        return author;
    }

    public void setAuthor(List<Author> author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", bookPrice=" + bookPrice +
                ", author=" + author +
                '}';
    }
}