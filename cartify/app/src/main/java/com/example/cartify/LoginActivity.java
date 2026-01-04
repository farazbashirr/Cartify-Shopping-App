package com.example.cartify;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText etEmail, etPassword;
    Button btnSignIn;
    TextView tvSignup, tvForgot;
    CheckBox cbRemember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnSignIn = findViewById(R.id.btnSignIn);
        tvSignup = findViewById(R.id.tvSignup);
        tvForgot = findViewById(R.id.tvForgot);
        cbRemember = findViewById(R.id.cbRemember);

        btnSignIn.setOnClickListener(v -> {
            String email = etEmail.getText().toString();
            String pass = etPassword.getText().toString();

            if (email.isEmpty() || pass.isEmpty()) {
                Toast.makeText(this, "Fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            // TODO: Add SQLite login logic

            startActivity(new Intent(this, HomeActivity.class));
            finish();
        });

        tvSignup.setOnClickListener(v ->
                startActivity(new Intent(this, SignupActivity.class))
        );
    }
}
