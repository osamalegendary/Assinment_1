package com.example.bookstore.model;

import java.util.ArrayList;
import java.util.List;

 class BookDA implements IBookDA{

    private ArrayList<Book> books = new ArrayList<>();

    public BookDA(){
        books.add(new Book(300 , "thinking in java ","Java"));
        books.add(new Book(450 , "thinking in C# ","C#"));

    }

    public List<Book> getBooks (String cat){

        ArrayList<Book> data = new ArrayList<>();
        for(Book b : books)
            if(b.getCategory().equals(cat))
            {
                data.add(b);
            }
        return data ;
    }

     @Override
     public String [] getCategories() {
         String [] cats = new String[]{ "Java","C#","C++"};
         return cats;
     }

 }
