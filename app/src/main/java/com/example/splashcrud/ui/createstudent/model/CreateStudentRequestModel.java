package com.example.splashcrud.ui.createstudent.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class CreateStudentRequestModel {

@SerializedName("name")
@Expose
private String name;
@SerializedName("email")
@Expose
private String email;
@SerializedName("phone")
@Expose
private String phone;
@SerializedName("address")
@Expose
private String address;

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public String getEmail() {
return email;
}

public void setEmail(String email) {
this.email = email;
}

public String getPhone() {
return phone;
}

public void setPhone(String phone) {
this.phone = phone;
}

public String getAddress() {
return address;
}

public void setAddress(String address) {
this.address = address;
}

}