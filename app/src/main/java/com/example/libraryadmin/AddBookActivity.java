package com.example.libraryadmin;

import androidx.appcompat.app.AppCompatActivity;

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
import com.example.libraryadmin.model.Author;
import com.example.libraryadmin.model.Category;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddBookActivity extends AppCompatActivity{
    EditText edtTitle,edtEdition,edtPublisher,edtRecommand;
    Spinner sp_category_name,sp_author_name;
    Button btnSubmit;
    ApiInterface apiInterface;
    List<Author> authorList;
    List<Category> categoryList;
    ArrayAdapter<Author> authorArrayAdapter;
    ArrayAdapter<Category> categoryArrayAdapter;
    int author_id,category_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addbook);

        edtTitle=findViewById(R.id.title);
        sp_author_name=findViewById(R.id.spnauthor);
        edtEdition=findViewById(R.id.edition);
        edtPublisher=findViewById(R.id.publisher);
        edtRecommand=findViewById(R.id.recommand);
        sp_category_name=findViewById(R.id.category_name);

        btnSubmit=findViewById(R.id.submit);

        apiInterface= ApiUtils.getApi();
        Call<List<Author>> getAuthor=apiInterface.getAllAuthor();
        Call<List<Category>> getCategory=apiInterface.getAllCategory();

        getAuthor.enqueue(new Callback<List<Author>>() {
            @Override
            public void onResponse(Call<List<Author>> call, Response<List<Author>> response) {
                authorList=response.body();
                authorArrayAdapter=new ArrayAdapter(AddBookActivity.this,android.R.layout.simple_spinner_item,authorList);
                authorArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                sp_author_name.setAdapter(authorArrayAdapter);

                sp_author_name.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override

                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        Author author=(Author)sp_author_name.getSelectedItem();
                        author_id=author.getId();
                        Toast.makeText(getApplicationContext(),author_id+"",Toast.LENGTH_LONG).show();
                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });
            }
            @Override
            public void onFailure(Call<List<Author>> call, Throwable t) {

            }
        });

        getCategory.enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                categoryList=response.body();
                categoryArrayAdapter=new ArrayAdapter(AddBookActivity.this,android.R.layout.simple_spinner_item,categoryList);
                categoryArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                sp_category_name.setAdapter(categoryArrayAdapter);

                sp_category_name.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        Category category=(Category)sp_category_name.getSelectedItem();
                        category_id=category.getId();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {
                    }
                });
            }
            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {

            String edttitle,edtedition,edtpublisher,edtrecommand;
            @Override
            public void onClick(View view) {
                edttitle=edtTitle.getText().toString();
                edtedition=edtEdition.getText().toString();
                edtpublisher=edtPublisher.getText().toString();
                edtrecommand=edtRecommand.getText().toString();

                apiInterface= ApiUtils.getApi();
                Call<String>EntryBook=apiInterface.EntryBook(edttitle,author_id,edtedition,edtpublisher,edtrecommand,category_id);

                EntryBook.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        Toast.makeText(getApplicationContext(),response.body().toString(),Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {

                    }
                });



            }
        });

    }
}
