package com.example.myapplication.api;

import android.os.AsyncTask;

import com.example.myapplication.interfaces.GetBook;

import org.json.JSONException;

import java.io.IOException;

import okhttp3.OkHttp;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class ApiGetBook extends AsyncTask<Void, Void, Void> {
    String data;
    GetBook getBook;

    public ApiGetBook(GetBook getBook) {
        this.getBook = getBook;
        this.getBook.start();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.myjson.online/v1/records/61f5b5b8-d522-4bb3-ba27-204e72351099")
                .build();
        data = null;
        try {
            Response response = client.newCall(request).execute();
            ResponseBody body = response.body();
            data = body.string();
        }catch (IOException e) {
            data = null;
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        if(data == null){
            this.getBook.err();
        }else {
            this.getBook.end(data);
        }
    }
}
