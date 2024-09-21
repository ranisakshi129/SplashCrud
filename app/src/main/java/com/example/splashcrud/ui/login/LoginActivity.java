package com.example.splashcrud.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.splashcrud.R;
import com.example.splashcrud.ui.login.model.LoginRequestModel;
import com.example.splashcrud.ui.login.model.LoginResponseModel;
import com.example.splashcrud.ui.home.HomeActivity;
import com.example.splashcrud.ui.signup.SignUpActivity;
import com.example.splashcrud.retrofit.ApiInterface;
import com.example.splashcrud.utils.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private TextView emailEdt;
    private TextView passwordEdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        emailEdt = findViewById(R.id.emailEdt);
        passwordEdt = findViewById(R.id.passwordEdt);
        Button loginBtn = findViewById(R.id.loginBtn);


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ApiInterface apiInterface=RetrofitClient.getInstance().getApiInterface();
                LoginRequestModel loginRequestModel = new LoginRequestModel(emailEdt.getText().toString(), passwordEdt.getText().toString());

//               Call<LoginResponseModel> call=apiInterface.loginUser(loginRequestModel);
//                call.enqueue(new Callback<LoginResponseModel>(){
//                    @Override
//                    public void onResponse(Call<LoginResponseModel> call, @NonNull Response<LoginResponseModel> response) {
//                        if (response.isSuccessful()) {
//                            LoginResponseModel loginResponse = response.body();
//
//                            if (loginResponse.getStatus()) {
//                                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
//                                startActivity(intent);
//                                Toast.makeText(LoginActivity.this, loginResponse.getMessage(), Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                    }
//                    @Override
//                    public void onFailure( Call<LoginResponseModel> call, Throwable t) {
//             }
//                });
                Call<LoginResponseModel>call=apiInterface.login(loginRequestModel);
                call.enqueue(new Callback<LoginResponseModel>() {
                    @Override
                    public void onResponse(Call<LoginResponseModel> call, Response<LoginResponseModel> response) {
                        if (response.isSuccessful()){
                            LoginResponseModel loginResponse = response.body();
                            if(loginResponse.getStatus()){
                                Intent intent=new Intent(LoginActivity.this, HomeActivity.class);
                                startActivity(intent);
                            }

                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResponseModel> call, Throwable t) {

                    }
                });
          }
        });


        TextView signUpBtn = findViewById(R.id.signUpBtn);
                signUpBtn.setOnClickListener(v ->

            {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            });


        }}
