package com.example.libraryadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.libraryadmin.Api.ApiInterface;
import com.example.libraryadmin.Api.ApiUtils;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateIdActivity extends AppCompatActivity {

    EditText edtStuname,edtRno,edtExp,edtphno;
    Button btncreate;
    ApiInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_id);

        edtStuname=findViewById(R.id.stuname);
        edtRno=findViewById(R.id.rno);
        edtExp=findViewById(R.id.expdate);
        edtphno=findViewById(R.id.phno);
        btncreate=findViewById(R.id.create);

        edtExp.setOnClickListener(new View.OnClickListener() {
            Calendar c;
            DatePickerDialog datePickerDialog;
            @Override
            public void onClick(View view) {
                c = Calendar.getInstance();
                int day = c.get(Calendar.DAY_OF_YEAR);
                int month = c.get(Calendar.MONTH);
                int year = c.get(Calendar.YEAR);
                datePickerDialog = new DatePickerDialog(CreateIdActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int day, int month, int year) {
                        edtExp.setText(day + "/" + month+ "/" + year);

                    }
                }, day, month, year);
                datePickerDialog.show();
            }
        });

        btncreate.setOnClickListener(new View.OnClickListener() {
            String cardid,stuname,rno,expdate,edphno;


            @Override
            public void onClick(View view) {
                stuname=edtStuname.getText().toString();
                rno=edtRno.getText().toString();
                expdate=edtExp.getText().toString();
                edphno=edtphno.getText().toString();

                apiInterface= ApiUtils.getApi();
                Call<String> entryMember=apiInterface.EntryMember(stuname,rno,expdate,edphno);

                entryMember.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        Toast.makeText(getApplicationContext(),response.body().toString(),Toast.LENGTH_LONG).show();
                        edtStuname.setText("");
                        edtRno.setText("");
                        edtExp.setText("");
                        edtphno.setText("");
                    }
                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),t.toString(),Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}
