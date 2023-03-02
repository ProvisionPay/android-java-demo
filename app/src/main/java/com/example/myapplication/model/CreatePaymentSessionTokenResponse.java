package com.example.myapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CreatePaymentSessionTokenResponse {
    @SerializedName("PaymentSessionToken")
    @Expose
    public String PaymentSessionToken;
}
