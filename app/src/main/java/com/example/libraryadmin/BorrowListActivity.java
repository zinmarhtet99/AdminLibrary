package com.example.libraryadmin;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.libraryadmin.Api.ApiInterface;
import com.example.libraryadmin.Api.ApiUtils;
import com.example.libraryadmin.model.BorrowBook;
import com.example.libraryadmin.Adapter.ReturnAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BorrowListActivity extends AppCompatActivity {
    ApiInterface apiInterface;
    RecyclerView recyclerView;
    ReturnAdapter returnAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_return_book_list);

        apiInterface= ApiUtils.getApi();
        Call<List<BorrowBook>> getBorrowBook=apiInterface.getBorrowBook();

        getBorrowBook.enqueue(new Callback<List<BorrowBook>>() {
            @Override
            public void onResponse(Call<List<BorrowBook>> call, Response<List<BorrowBook>> response) {
                LoadBorrowBookList(response.body());
            }
            @Override
            public void onFailure(Call<List<BorrowBook>> call, Throwable t) {

            }
        });


    }
    public void LoadBorrowBookList(List<BorrowBook> borrowBookList){

        recyclerView=findViewById(R.id.returnrecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(BorrowListActivity.this));

        returnAdapter =new ReturnAdapter(BorrowListActivity.this, borrowBookList);
        recyclerView.setAdapter(returnAdapter);
    }
}