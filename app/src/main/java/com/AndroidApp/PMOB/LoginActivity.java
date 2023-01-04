package com.AndroidApp.PMOB;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText Nim, Pass;
    private Button Signin, Signup;
    private DataBaseHelper db;
    private Preferences session;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new DataBaseHelper(this);
        session = new Preferences(this);
        Signin = (Button)findViewById(R.id.signin);
        Signup = (Button)findViewById(R.id.signup);
        Nim = (EditText)findViewById(R.id.nim);
        Pass = (EditText)findViewById(R.id.password);
        Signin.setOnClickListener(this);
        Signup.setOnClickListener(this);

        if(session.loggedin()){
            startActivity(new Intent(LoginActivity.this,MainActivity.class));
            finish();
        }
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.signin:
                login();
                break;
            case R.id.signup:
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
                break;
            default:

        }
    }

    private void login(){
        String nim = Nim.getText().toString();
        String pass = Pass.getText().toString();

        if(db.getUser(nim, pass)){
            session.setLoggedin(true);
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        }else{
            Toast.makeText(getApplicationContext(), "Nim/Password Salah",Toast.LENGTH_SHORT).show();
        }
    }
}