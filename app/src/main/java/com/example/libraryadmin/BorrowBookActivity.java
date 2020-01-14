package com.example.libraryadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.libraryadmin.Api.ApiInterface;
import com.example.libraryadmin.Api.ApiUtils;
import com.example.libraryadmin.Utils.FontEmbedder;
import com.example.libraryadmin.model.Book;
import com.example.libraryadmin.model.Member;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BorrowBookActivity extends AppCompatActivity {

    EditText edtrollno,edtAuthor,edtDate,edtmember_id,edtbook_id;
    Spinner sp_member_name,sp_book_Title;
    Button btnBorrow;
    ApiInterface apiInterface;
    List<Member>memberList;
    List<Book> bookList;
    ArrayAdapter<Member>memberArrayAdapter;
    ArrayAdapter<Book>book1ArrayAdapter;
    String stName,stTitle,srollno,sauthor;
    int memberid,bookid;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.borrow_book_activity);

        sp_member_name=findViewById(R.id.spnStuName);
        edtrollno=findViewById(R.id.rNo);
        sp_book_Title=findViewById(R.id.spnborrowtitle);
        edtAuthor=findViewById(R.id.borrowauthor);
        edtDate=findViewById(R.id.date);
        btnBorrow=findViewById(R.id.borrow);
        edtmember_id=findViewById(R.id.txtmemberid);
        edtbook_id=findViewById(R.id.book_id);

        SimpleDateFormat sdf=new SimpleDateFormat("yyy.MM.dd");
        String currentDateandTime=sdf.format(new Date());
        edtDate.setText(currentDateandTime);
        edtDate.setEnabled(true);

        apiInterface=ApiUtils.getApi();
        Call<List<Member>> getMember=apiInterface.getAllMember();

        getMember.enqueue(new Callback<List<Member>>() {
            @Override
            public void onResponse(Call<List<Member>> call, Response<List<Member>> response) {
                memberList=response.body();
                memberArrayAdapter=new ArrayAdapter(BorrowBookActivity.this, android.R.layout.simple_spinner_item,memberList);
                memberArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                sp_member_name.setAdapter(memberArrayAdapter);
                sp_member_name.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        Member member=(Member) sp_member_name.getSelectedItem();
                        stName=member.getStudentName();
                        srollno=member.getRollno();
                        memberid=member.getId();
                        edtrollno.setText(srollno);
                        edtmember_id.setText(memberid+"");
                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {
                    }
                });
            }
            @Override
            public void onFailure(Call<List<Member>> call, Throwable t) {

            }
        });

        Call<List<Book>> getBook=apiInterface.getBook1();

        getBook.enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                bookList =response.body();
                book1ArrayAdapter=new ArrayAdapter(BorrowBookActivity.this, android.R.layout.simple_spinner_item, bookList);
                book1ArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                sp_book_Title.setAdapter(book1ArrayAdapter);

                sp_book_Title.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        Book book =(Book) sp_book_Title.getSelectedItem();
                        stTitle= book.getTitle();
                        sauthor= book.getAuthor().getName();
                        bookid= book.getId();
                        FontEmbedder.force(edtAuthor,sauthor);
                        edtbook_id.setText(bookid+"");
                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {
                    }
                });

            }
            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {
            }
        });

        btnBorrow.setOnClickListener(new View.OnClickListener() {
            String stuName,rollNo,title,author,date;
            int member_id,book_id;
            @Override
            public void onClick(View view) {
                rollNo=edtrollno.getText().toString();
                title=sp_book_Title.getSelectedItem().toString();
                stuName=sp_member_name.getSelectedItem().toString();
                member_id=Integer.parseInt(edtmember_id.getText().toString());
                book_id=Integer.parseInt(edtbook_id.getText().toString());
                author=edtAuthor.getText().toString();
                date=edtDate.getText().toString();

                apiInterface= ApiUtils.getApi();
                Call<String>EntryBorrowBook=apiInterface.EntryBorrowBook(stuName,rollNo,title,author,member_id,book_id,date);

                EntryBorrowBook.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        Toast.makeText(getApplicationContext(),response.body()+"",Toast.LENGTH_LONG).show();
                        finish();
                    }
                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                    }
                });
            }
        });
    }
}
