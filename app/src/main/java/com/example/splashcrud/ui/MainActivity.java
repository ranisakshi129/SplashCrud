package com.example.splashcrud.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.splashcrud.R;
import com.example.splashcrud.ui.login.LoginActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);




                Intent intent= new Intent(MainActivity.this, LoginActivity.class);

                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {

                        Toast.makeText(MainActivity.this, "Welcome to JPR", Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                        finish();

                    }

                } ,3000);



}
        }
