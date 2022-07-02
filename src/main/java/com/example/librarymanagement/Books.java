package com.example.librarymanagement;

public class Books {
    private String ISBN;
    private String BookName;
    private String author;
    private double price;
    private boolean state;

    public Books(String isbn, String bookName, String author, double p) {
        this.ISBN = isbn;
        this.BookName = bookName;
        this.author = author;
        this.price = p;
    }

    @Override
    public String toString() {
        return  "Books{" +
                "ISBN='" + ISBN + '\'' +
                ", BookName='" + BookName + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", state=" + state +
                '}';
    }

    public String getISBN() {
        return ISBN;
    }

    public String getBookName() {
        return BookName;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public boolean isState() {
        return state;
    }
}
