package com.example.splashcrud.ui.signup;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import com.example.splashcrud.R;
import com.example.splashcrud.ui.login.LoginActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    private EditText nameEdt, phoneEdt, emailEdt, passwordEdt, confirmpasswordEdt;
    private Button signUpBtn;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);


        nameEdt = findViewById(R.id.nameEdt);
        phoneEdt = findViewById(R.id.phoneEdt);
        emailEdt = findViewById(R.id.emailEdt);
        passwordEdt = findViewById(R.id.passwordEdt);
        confirmpasswordEdt = findViewById(R.id.confirmpasswordEdt);
        signUpBtn = findViewById(R.id.signUpBtn);



        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = nameEdt.getText().toString();
                String phone = phoneEdt.getText().toString();
                String email = emailEdt.getText().toString();
                String password = passwordEdt.getText().toString();
                String cPassword = confirmpasswordEdt.getText().toString();

                if (name.isEmpty()) {
                    Toast.makeText(SignUpActivity.this, "Name can not be empty", Toast.LENGTH_SHORT).show();
                } else if (!name.matches("[a-zA-Z]+")) {
                    Toast.makeText(SignUpActivity.this, "Enter only alphabetical character", Toast.LENGTH_SHORT).show();
                }else if (phone.isEmpty()) {
                    Toast.makeText(SignUpActivity.this, "Phone can not be empty", Toast.LENGTH_SHORT).show();
                } else if (!phone.matches("^[+][0-9]{10,13}$")) {
                    Toast.makeText(SignUpActivity.this, "Correct Format :+92**", Toast.LENGTH_SHORT).show();
                }
                if (email.isEmpty()) {
                    Toast.makeText(SignUpActivity.this, "Email can not be empty", Toast.LENGTH_SHORT).show();
                } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Toast.makeText(SignUpActivity.this, "Please enter valid email", Toast.LENGTH_SHORT).show();
                } else if (password.isEmpty()) {
                    Toast.makeText(SignUpActivity.this, "Password can not be empty", Toast.LENGTH_SHORT).show();
                } else if (password.length() < 8 || !password.matches("(.[A-Z].)") || !password.matches("(.[0-9].)")) {
                    Toast.makeText(SignUpActivity.this, "Please enter valid Password", Toast.LENGTH_SHORT).show();
                } else if (!password.equals(cPassword)) {
                    Toast.makeText(SignUpActivity.this, "Password would not be matched", Toast.LENGTH_SHORT).show();
                } else if (!password.equals(cPassword)) {
                    Toast.makeText(SignUpActivity.this, "Password matched", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SignUpActivity.this, "Signup successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                    startActivity(intent);
                }


            }
      });


}

}
