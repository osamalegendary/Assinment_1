package com.example.bookstore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.bookstore.model.Book;
import com.example.bookstore.model.BooksFactory;
import com.example.bookstore.model.IBookDA;

import java.util.List;

public class MainActivity extends AppCompatActivity {
private Spinner spinner ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);
        populateSpinner();
    }

    private void populateSpinner() {
        BooksFactory factory =new BooksFactory();
        IBookDA objbook = factory.getModel();

        String [] cats = objbook.getCategories();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,cats);
        spinner.setAdapter(adapter);

    }

    public void btnGetBooks(View view) {

        BooksFactory factory =new BooksFactory();
        IBookDA objbook = factory.getModel();
        String item = "";
        item=spinner.getSelectedItem().toString();
        List<Book> books = objbook.getBooks( item);


        String str = "";
        for (Book b : books)
            str+=b.getTitle() + "\n";
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();

    }

}