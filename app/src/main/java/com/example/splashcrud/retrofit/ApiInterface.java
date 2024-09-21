package com.example.splashcrud.retrofit;

import com.example.splashcrud.ui.createstudent.model.CreateStudentRequestModel;
import com.example.splashcrud.ui.createstudent.model.CreateStudentResponseModel;
import com.example.splashcrud.ui.login.model.LoginRequestModel;
import com.example.splashcrud.ui.login.model.LoginResponseModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInterface {
    @POST("/api/loginUser")
    Call<LoginResponseModel> login(@Body LoginRequestModel loginRequestModel);


    @POST("/api/addStudent")
    Call<CreateStudentResponseModel> addstudent(@Body CreateStudentRequestModel createStudentRequestModel);




}
