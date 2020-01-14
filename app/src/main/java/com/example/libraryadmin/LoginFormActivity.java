package com.example.libraryadmin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginFormActivity extends AppCompatActivity {

    EditText edname,edpass;
    Button btnlogin;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginform);
        edname=findViewById(R.id.name);
        edpass=findViewById(R.id.password);
        btnlogin=findViewById(R.id.login);


        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(LoginFormActivity.this, MainActivity.class);
//                startActivity(intent);
//                finish();
                if((edname.getText().toString().equals("Admin") ) && (edpass.getText().toString() .equals("admin123") )) {
                    Intent intent = new Intent(LoginFormActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Login Fail!",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
