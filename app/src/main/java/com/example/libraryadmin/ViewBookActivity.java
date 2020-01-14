package com.example.libraryadmin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.libraryadmin.Api.ApiInterface;
import com.example.libraryadmin.Api.ApiUtils;
import com.example.libraryadmin.model.Book;
import com.example.libraryadmin.Adapter.BookAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewBookActivity extends AppCompatActivity {

    TextView textView;
    RecyclerView recyclerView;
    List<Book>bookList;
    Book book;
    ApiInterface apiInterface;
    BookAdapter bookAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewbook_recyclerview);

        apiInterface= ApiUtils.getApi();
        Call<List<Book>> getBook1=apiInterface.getBook1();
        getBook1.enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                LoadBookList(response.body());
            }
            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {
              Toast.makeText(ViewBookActivity.this,t.toString(),Toast.LENGTH_LONG).show();
            }
        });

    }
    public void LoadBookList(List<Book>bookList){

        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(ViewBookActivity.this));

        bookAdapter=new BookAdapter(ViewBookActivity.this,bookList);
        recyclerView.setAdapter(bookAdapter);
    }
}
