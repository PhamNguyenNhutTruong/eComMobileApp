package vn.edu.ecomapp.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

import vn.edu.ecomapp.R;

public class ForgotPasswordActivity extends AppCompatActivity {

   TextInputLayout editTextEmail;
   TextView goToLoginButton;
   Button sendEmailButton;
   String email;


    private  void initializeComponents() {
        this.editTextEmail = findViewById(R.id.edit_text_email);
        this.goToLoginButton = findViewById(R.id.goToLoginButton);
        this.sendEmailButton = findViewById(R.id.button_send_email);
        email = "";

        // Handle event
        goToLoginButton.setOnClickListener(view -> {
            startActivity(new Intent(ForgotPasswordActivity.this, LoginActivity.class));
            finish();
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        initializeComponents();
        handleSendEmailButtonClick();
    }

    private void handleSendEmailButtonClick() {
        this.sendEmailButton.setOnClickListener(view -> {
            email = Objects.requireNonNull(editTextEmail.getEditText()).getText().toString().trim();
            Toast.makeText(this, email, Toast.LENGTH_SHORT).show();
        });
    }
}