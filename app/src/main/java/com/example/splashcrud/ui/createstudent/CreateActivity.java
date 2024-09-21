package com.example.splashcrud.ui.createstudent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.splashcrud.R;
import com.example.splashcrud.ui.createstudent.model.CreateStudentRequestModel;
import com.example.splashcrud.ui.createstudent.model.CreateStudentResponseModel;
import com.example.splashcrud.ui.home.HomeActivity;
import com.example.splashcrud.utils.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateActivity extends AppCompatActivity {

    private Button submitBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_create);

        EditText nameEdt = findViewById(R.id.name);
        EditText phoneEdt= findViewById(R.id.phone);
        EditText emailEdt = findViewById(R.id.email);
        EditText addressEdt = findViewById(R.id.address);
        submitBtn=findViewById(R.id.submit);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name =nameEdt.getText().toString();
                String phone =phoneEdt.getText().toString();
                String email =emailEdt.getText().toString();
                String address =addressEdt.getText().toString();
                CreateStudentRequestModel createStudentRequestModel = new CreateStudentRequestModel();
                createStudentRequestModel.setName(name);
                createStudentRequestModel.setPhone(phone);
                createStudentRequestModel.setEmail(email);
                createStudentRequestModel.setAddress(address);

                Call<CreateStudentResponseModel> call = RetrofitClient.getInstance().getApiInterface().addstudent(createStudentRequestModel);
                call.enqueue(new Callback<CreateStudentResponseModel>()
                {
                @Override
                public void onResponse(Call<CreateStudentResponseModel> call, Response<CreateStudentResponseModel> response) {
                    if (response.isSuccessful()){
                        CreateStudentResponseModel studentResponseModel = response.body();
                        if (studentResponseModel.getStatus()) {
                            Intent intent =new Intent(CreateActivity.this, HomeActivity.class);
                            startActivity(intent);
                            Toast.makeText(CreateActivity.this,studentResponseModel.getMessage(), Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(CreateActivity.this,studentResponseModel.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                        }
                    }
                @Override
                public void onFailure(Call<CreateStudentResponseModel> call, Throwable t) {

                }
            });
            }
        });

    }
}