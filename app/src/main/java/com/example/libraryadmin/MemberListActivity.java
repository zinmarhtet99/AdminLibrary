package com.example.libraryadmin;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.libraryadmin.Api.ApiInterface;
import com.example.libraryadmin.Api.ApiUtils;
import com.example.libraryadmin.model.Member;
import com.example.libraryadmin.Adapter.MemberAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MemberListActivity extends AppCompatActivity {

    ApiInterface apiInterface;
    RecyclerView recyclerView;
    MemberAdapter memberAdapter;
    List<Member> memberList;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memberlist_recyclerview);

        apiInterface = ApiUtils.getApi();
        Call<List<Member>> getMember = apiInterface.getAllMember();


        getMember.enqueue(new Callback<List<Member>>() {
            @Override
            public void onResponse(Call<List<Member>> call, Response<List<Member>> response) {
                LoadMemberList(response.body());
            }

            @Override
            public void onFailure(Call<List<Member>> call, Throwable t) {

            }
        });
    }
    public void LoadMemberList(List<Member>memberList){

        recyclerView=findViewById(R.id.memberlistrecyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(MemberListActivity.this));

        memberAdapter=new MemberAdapter(memberList,MemberListActivity.this);
        recyclerView.setAdapter(memberAdapter);
    }
}
