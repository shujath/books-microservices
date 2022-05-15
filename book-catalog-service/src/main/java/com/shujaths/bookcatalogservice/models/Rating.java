package com.shujaths.bookcatalogservice.models;

public class Rating {

    public String bookId;
    public int Rating;

    public Rating(String bookId, int rating) {
        this.bookId = bookId;
        Rating = rating;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public int getRating() {
        return Rating;
    }

    public void setRating(int rating) {
        Rating = rating;
    }
}
