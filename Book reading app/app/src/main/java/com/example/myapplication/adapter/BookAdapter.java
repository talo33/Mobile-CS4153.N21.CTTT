package com.example.myapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.example.myapplication.object.book;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class BookAdapter extends ArrayAdapter<book> {
    private Context ct;
    private ArrayList<book> arr;

    public BookAdapter(Context context, int resource, List<book> objects) {
        super(context, resource, objects);
        this.ct = context;
        this.arr = new ArrayList<>(objects);
    }

    public void sortBook(String s) {
        s = s.toUpperCase();
        int k = 0;
        for (int i = 0; i < arr.size(); i++) {
            book b = arr.get(i);
            String name = b.getBookName().toUpperCase();
            if (name.indexOf(s) >= 0) {
                arr.set(i, arr.get(k));
                arr.set(k, b);
                k++;
            }
        }
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.items_book, null);
        }

        if (arr.size() > 0) {
            book bk = this.arr.get(position);

            TextView bookname = convertView.findViewById(R.id.txvBookname);
            TextView booknum = convertView.findViewById(R.id.txvBooknum);
            ImageView bookimg = convertView.findViewById(R.id.imgBookimg);

            bookname.setText(bk.getBookName());
            booknum.setText(bk.getBooknum());
            Glide.with(this.ct).load(bk.getPicLink()).into(bookimg);
        }
        return convertView;
    }
}