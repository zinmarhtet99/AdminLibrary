package com.example.libraryadmin.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.libraryadmin.R;
import com.example.libraryadmin.model.Member;

import java.util.List;

public class MemberAdapter extends RecyclerView.Adapter<MemberAdapter.UserViewHolder> {

    List<Member> memberList;
    Context context;

    public MemberAdapter(List<Member> memberList, Context context) {
        this.memberList = memberList;
        this.context = context;
    }

    @NonNull
    @Override
    public MemberAdapter.UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.memberlist,parent,false);

        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MemberAdapter.UserViewHolder holder, int position) {
        holder.membername.setText(memberList.get(position).getStudentName());
        holder.memberrno.setText(memberList.get(position).getRollno());
        holder.memeberphno.setText(memberList.get(position).getPhnoeNo());

    }

    @Override
    public int getItemCount() {
        return memberList.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {

        TextView membername,memberrno,memeberphno;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            membername= itemView.findViewById(R.id.membername);
            memberrno=itemView.findViewById(R.id.memberrno);
            memeberphno=itemView.findViewById(R.id.memberphno);
        }


    }
}
