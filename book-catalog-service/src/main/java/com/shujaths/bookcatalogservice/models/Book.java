package com.shujaths.bookcatalogservice.models;

public class Book {

    public String bookId;
    public String name;

    public Book() {
    }

    public Book(String bookId, String name) {
        this.bookId = bookId;
        this.name = name;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
