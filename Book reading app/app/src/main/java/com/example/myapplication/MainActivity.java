package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.GridView;


import com.example.myapplication.adapter.BookAdapter;
import com.example.myapplication.object.book;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
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
    }

    private void init() {
        bookArrayList = new ArrayList<>();
        bookArrayList.add(new book("H", "Nick Arnold - Tony De Saulles", "https://nhasachmienphi.com/images/thumbnail/nhasachmienphi-horrible-science-vi-sinh-vat-vi-tinh.jpg"));
        bookArrayList.add(new book("H", "Phil Gates, Tony De Saulles", "https://nhasachmienphi.com/images/thumbnail/nhasachmienphi-horrible-science-vat-ly-cau-chuyen-cua-nhung-luc-bi-hiem.jpg"));
        bookArrayList.add(new book("A", "Phil Gates, Tony De Saulles", "https://nhasachmienphi.com/images/thumbnail/nhasachmienphi-horrible-science-thien-nhien-hoang-da.jpg"));
        bookArrayList.add(new book("H", "Nick Arnold - Tony De Saulles", "https://nhasachmienphi.com/images/thumbnail/nhasachmienphi-horrible-science-vi-sinh-vat-vi-tinh.jpg"));
        bookArrayList.add(new book("D", "Phil Gates, Tony De Saulles", "https://nhasachmienphi.com/images/thumbnail/nhasachmienphi-horrible-science-vat-ly-cau-chuyen-cua-nhung-luc-bi-hiem.jpg"));
        bookArrayList.add(new book("H", "Phil Gates, Tony De Saulles", "https://nhasachmienphi.com/images/thumbnail/nhasachmienphi-horrible-science-thien-nhien-hoang-da.jpg"));
        bookArrayList.add(new book("H", "Nick Arnold - Tony De Saulles", "https://nhasachmienphi.com/images/thumbnail/nhasachmienphi-horrible-science-vi-sinh-vat-vi-tinh.jpg"));
        bookArrayList.add(new book("H", "Phil Gates, Tony De Saulles", "https://nhasachmienphi.com/images/thumbnail/nhasachmienphi-horrible-science-vat-ly-cau-chuyen-cua-nhung-luc-bi-hiem.jpg"));
        bookArrayList.add(new book("H", "Phil Gates, Tony De Saulles", "https://nhasachmienphi.com/images/thumbnail/nhasachmienphi-horrible-science-thien-nhien-hoang-da.jpg"));

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

}