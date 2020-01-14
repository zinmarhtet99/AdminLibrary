package com.example.libraryadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.libraryadmin.Api.ApiInterface;
import com.example.libraryadmin.Api.ApiUtils;
import com.example.libraryadmin.model.Member;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReturnBookActivity extends AppCompatActivity {

    Spinner spstuName;
    List<Member> memberList;
    EditText edtrNo,edtreturndate;
    ArrayAdapter<Member> memberArrayAdapter;
    Button btnreturn;
    ApiInterface apiInterface;
    String rno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_return_book);

        edtrNo=findViewById(R.id.rNo1);
        spstuName=findViewById(R.id.stuName1);
        btnreturn=findViewById(R.id.return1);
        edtreturndate=findViewById(R.id.date);

        SimpleDateFormat sdf=new SimpleDateFormat("yyy.MM.dd");
        String currentDateandTime=sdf.format(new Date());
        edtreturndate.setText(currentDateandTime);

        apiInterface= ApiUtils.getApi();
        Call<List<Member>> getMember=apiInterface.getAllMember();

        getMember.enqueue(new Callback<List<Member>>() {
            @Override
            public void onResponse(Call<List<Member>> call, Response<List<Member>> response) {
                memberList=response.body();
                memberArrayAdapter=new ArrayAdapter(ReturnBookActivity.this,android.R.layout.simple_spinner_item,memberList);
                memberArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spstuName.setAdapter(memberArrayAdapter);

                spstuName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        Member member=(Member)spstuName.getSelectedItem();
                        rno=member.getRollno();
                        edtrNo.setText(rno);
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

        btnreturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ReturnBookActivity.this,ReturnBookListActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("rno",rno);

                startActivity(intent);
            }
        });
    }
}
