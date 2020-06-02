package com.example.sportfootball;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sportfootball.Database.Akun;
import com.example.sportfootball.Database.AppDatabase;

public class RegisterActivity extends AppCompatActivity {
    EditText etUserDaftar,etPassDaftar,etEmailDaftar;
    String username,password,email;
    Button btnnDaftar, btnCancel;
    private AppDatabase appDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        appDatabase = AppDatabase.iniDb(getApplicationContext());

        etUserDaftar = findViewById(R.id.user_daftar);
        etPassDaftar = findViewById(R.id.pass_daftar);
        etEmailDaftar = findViewById(R.id.email_daftar);

        btnnDaftar = findViewById(R.id.register_activity_daftar);
        btnCancel = findViewById(R.id.register_activity_cancel);


        btnnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    username = etUserDaftar.getText().toString();
                    password = etPassDaftar.getText().toString();
                    email = etEmailDaftar.getText().toString();
                    if (!username.equals("") || !password.equals("")){
                        Akun[] reg = appDatabase.dao().checkUser(username);
                        if (reg[0] != null){
                            etUserDaftar.setError("Userame telah terdaftar");
                        }
                    }
                    else if (!username.equals("")){
                        etPassDaftar.setError("This Field is required");
                    }
                    else if (!password.equals("")){
                        etUserDaftar.setError("This Field is Required");
                    }
                    else {
                        etPassDaftar.setError("This Field is required");
                        etUserDaftar.setError("This Field is Required");
                    }
                }catch (Exception e){
                    inserData();
                    finish();
                }

            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    public void inserData(){
        Akun registrasi = new Akun();
        registrasi.setUsername(username);
        registrasi.setPassword(password);
        registrasi.setEmail(email);
        appDatabase.dao().daftarAkun(registrasi);
        finish();
    }
}
