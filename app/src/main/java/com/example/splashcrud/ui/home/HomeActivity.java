package com.example.splashcrud.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.splashcrud.R;
import com.example.splashcrud.ui.createstudent.CreateActivity;

public class HomeActivity extends AppCompatActivity {

    private Button createBtn,allBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

    createBtn = findViewById(R.id.createBtn);
    allBtn = findViewById(R.id.allBtn);


   createBtn.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           Intent intent=new Intent(HomeActivity.this, CreateActivity.class);
           startActivity(intent);
       }
   });

    }


    }
