package com.example.myapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AuthenticateResponse {
    @SerializedName("Token")
    @Expose
    private  String Token;
}
