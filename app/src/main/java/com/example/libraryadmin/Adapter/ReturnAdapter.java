package com.example.libraryadmin.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.libraryadmin.Api.ApiInterface;
import com.example.libraryadmin.Api.ApiUtils;
import com.example.libraryadmin.R;
import com.example.libraryadmin.Utils.FontEmbedder;
import com.example.libraryadmin.model.BorrowBook;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReturnAdapter extends RecyclerView.Adapter<ReturnAdapter.UserViewHolder> {

    List<BorrowBook> borrowBookList;
    Context context;
    ApiInterface apiInterface;

    public ReturnAdapter(Context context,List<BorrowBook> borrowBookList) {
        this.borrowBookList = borrowBookList;
        this.context = context;
    }


    @NonNull
    @Override
    public ReturnAdapter.UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.returnedborrowbook,parent,false);

        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReturnAdapter.UserViewHolder holder, final int position) {
        FontEmbedder.force(holder.returnAuthor, borrowBookList.get(position).getAuthor());
        FontEmbedder.force(holder.returntitle, borrowBookList.get(position).getTitle());
        holder.returnDate.setText(borrowBookList.get(position).getDate());
        Glide.with(context)
                .load("https://culibrary1.000webhostapp.com/"+ borrowBookList.get(position).getBook().getImage())
                .into(holder.returnimage);
        holder.btn_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int book_id= borrowBookList.get(position).getBookId();
                int pos= borrowBookList.get(position).getId();

                apiInterface= ApiUtils.getApi();
                Call<String> returnBorrowBook=apiInterface.ReturnBorrowBook(pos,book_id,"19/8/2019");
                returnBorrowBook.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        Toast.makeText(context,response.body().toString(),Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {

                    }
                });




            }
        });

}

    @Override
    public int getItemCount() {
        return borrowBookList.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder{
        TextView returntitle,returnAuthor,returnDate;
        ImageView returnimage;
        Button btn_return;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            returnAuthor=itemView.findViewById(R.id.returnauthor);
            returntitle=itemView.findViewById(R.id.returntitle);
            returnDate=itemView.findViewById(R.id.returndate);

            returnimage=itemView.findViewById(R.id.returnimg);
            btn_return=itemView.findViewById(R.id.btn_return);

        }
    }
}
