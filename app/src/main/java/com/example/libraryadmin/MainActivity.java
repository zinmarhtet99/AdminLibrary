package com.example.libraryadmin;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.libraryadmin.model.Book;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    List<Book>bookList;
    AlertDialog.Builder builder;


    Button btnborrow,btnreturn,btnadd,btnview,btnid,btnmemeber,btnborrowlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        builder=new AlertDialog.Builder(this);

        btnborrow=findViewById(R.id.borrowbook);
        btnreturn=findViewById(R.id.returnbook);
        btnadd=findViewById(R.id.addbook);
        btnview=findViewById(R.id.viewbook);
        btnid=findViewById(R.id.createidcard);
        btnmemeber=findViewById(R.id.memberlist);
        btnborrowlist=findViewById(R.id.borrowlist);

        btnborrowlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BorrowListActivity.class);
                startActivity(intent);
            }
        });


        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddBookActivity.class);
                startActivity(intent);
            }
        });

        btnid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CreateIdActivity.class);
                startActivity(intent);
            }
        });

        btnborrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.setMessage("Have you Id Card?").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(MainActivity.this, BorrowBookActivity.class);
                        startActivity(intent);
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(MainActivity.this, CreateIdActivity.class);
                        startActivity(intent);
                    }
                });
                AlertDialog alertDialog=builder.create();
                alertDialog.setTitle("ID CARD");
                alertDialog.show();
            }
        });

        btnreturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ReturnBookActivity.class);
                startActivity(intent);
            }
        });

        btnview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(MainActivity.this, ViewBookActivity.class);
                startActivity(intent);
            }
        });
        btnmemeber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,MemberListActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
    }
}
