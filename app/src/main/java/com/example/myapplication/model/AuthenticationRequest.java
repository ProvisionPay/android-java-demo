package com.example.myapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AuthenticationRequest {
    @SerializedName("ApplicationLoginID")
    @Expose
    private String ApplicationLoginID;

    @SerializedName("Password")
    @Expose
    private String Password;

public AuthenticationRequest(String applicationLoginID, String password){
    this.ApplicationLoginID=applicationLoginID;
    this.Password = password;

}



}
