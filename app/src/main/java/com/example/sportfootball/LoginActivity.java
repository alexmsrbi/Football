package com.example.sportfootball;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sportfootball.Database.Akun;
import com.example.sportfootball.Database.AppDatabase;

public class LoginActivity extends AppCompatActivity {

    EditText etUser,etPassword;
    public String user,pass;
    Button btnSignIn, btnSignUp;
    Akun[] acc;
    AppDatabase appDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        appDatabase = AppDatabase.iniDb(getApplicationContext());

        etUser=findViewById(R.id.Username);
        etPassword=findViewById(R.id.Password);
        btnSignIn = findViewById(R.id.btnLogin);
        btnSignUp = findViewById(R.id.btnDaftar);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    user = etUser.getText().toString();
                    pass = etPassword.getText().toString();
                    acc = appDatabase.dao().getDataLogin(user,pass);

                    if (acc[0]!=null){
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                    }
                    else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(getBaseContext());
                        builder.setTitle("Warning");
                        builder.setMessage("Username atau Password Salah");
                        builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                    }
                }catch (Exception e){
                    if (etUser.getText().toString().equals("") || etPassword.getText().toString().equals("")) {
                        Toast.makeText(getApplicationContext(), "Username/Password belum terisi", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        etUser.setError("Username wrong");
                        etPassword.setError("Password Wrong");
                    }
                }
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tambah = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(tambah);
            }
        });
    }

}
