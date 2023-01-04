package com.AndroidApp.PMOB;



import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText Nim, Pass, Nama;
    private TextView Login;
    private Button Register;
    private DataBaseHelper db;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DataBaseHelper(this);
        Register = (Button)findViewById(R.id.register);
        Login = (TextView)findViewById(R.id.login);
        Nim = (EditText)findViewById(R.id.nim);
        Nama = (EditText)findViewById(R.id.nama);
        Pass = (EditText)findViewById(R.id.pass);
        Register.setOnClickListener(this);
        Login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.register:
                register();
                break;
            case R.id.login:
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                finish();
                break;
            default:

        }
    }

    private void register(){
        String nim = Nim.getText().toString();
        String nama = Nama.getText().toString();
        String pass = Pass.getText().toString();
        if(nim.isEmpty() || pass.isEmpty() || nim.isEmpty()){
            displayToast("Isi Semua Inputan");
        }else{
            db.addUser(nim, nama, pass);
            displayToast("User registered");
            finish();
        }
    }

    private void displayToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}