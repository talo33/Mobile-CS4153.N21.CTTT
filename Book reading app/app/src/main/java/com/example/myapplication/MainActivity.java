package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;


import com.example.myapplication.adapter.BookAdapter;
import com.example.myapplication.api.ApiGetBook;
import com.example.myapplication.interfaces.GetBook;
import com.example.myapplication.object.book;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements GetBook {
    GridView gdvListOfBook;
    BookAdapter badapter;
    ArrayList<book> bookArrayList;
    EditText edtSort;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        mapping();
        setup();
        setClick();
        new ApiGetBook(this).execute();
    }

    private void init() {
        bookArrayList = new ArrayList<>();


        badapter = new BookAdapter(this, 0, bookArrayList);
    }

    ;

    private void mapping() {

        gdvListOfBook = findViewById(R.id.gdvListOfBook);
        edtSort = findViewById(R.id.edtSort);
    }

    ;

    private void setup() {
        gdvListOfBook.setAdapter(badapter);
    }

    ;

    private void setClick() {
        edtSort.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String s = edtSort.getText().toString();
                badapter.sortBook(s);
            }
        });
    }

    @Override
    public void start() {
        Toast.makeText(this, "getting start", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void end(String data) {
        try {
            bookArrayList.clear();
            JSONArray arr = new JSONArray(data);
            for(int i=0; i<arr.length(); i++){
                JSONObject o = arr.getJSONObject(i);
                bookArrayList.add(new book(o));
            }
            badapter = new BookAdapter(this, 0, bookArrayList);
            gdvListOfBook.setAdapter(badapter);
        }catch (JSONException e){

        }
    }

    @Override
    public void err() {
        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
    }
}