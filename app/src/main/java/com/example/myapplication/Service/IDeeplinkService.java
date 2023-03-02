package com.example.myapplication.Service;

import com.example.myapplication.model.AuthenticateResponse;
import com.example.myapplication.model.AuthenticationRequest;
import com.example.myapplication.model.CreatePaymentSessionTokenRequest;
import com.example.myapplication.model.CreatePaymentSessionTokenResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface IDeeplinkService {

    @POST("authorize")
    public Call<AuthenticateResponse> authenticate(@Body AuthenticationRequest request);

    @POST("createpaymentsessiontoken")
    public Call<CreatePaymentSessionTokenResponse> createpaymentsessiontoken(@Header("Authorization")String token, @Body CreatePaymentSessionTokenRequest request);
}