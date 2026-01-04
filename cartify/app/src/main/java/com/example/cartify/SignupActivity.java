package com.example.cartify;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class SignupActivity extends AppCompatActivity {

    TextInputEditText etFullName, etEmail, etPassword;
    Button btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etFullName = findViewById(R.id.etFullName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnSignup = findViewById(R.id.btnSignup);

        btnSignup.setOnClickListener(v -> {
            String name = etFullName.getText().toString();
            String email = etEmail.getText().toString();
            String pass = etPassword.getText().toString();

            if (name.isEmpty() || email.isEmpty() || pass.isEmpty()) {
                Toast.makeText(this, "Fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            // TODO: Insert user into SQLite

            Toast.makeText(this, "Account created", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
