package com.example.bookstore.model;

public class BooksFactory {
    public  IBookDA getModel(){
        return new BookDA();
    }
}
