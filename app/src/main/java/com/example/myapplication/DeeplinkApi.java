package com.example.myapplication;

import com.example.myapplication.Service.*;
import com.example.myapplication.model.AuthenticateResponse;
import com.example.myapplication.model.AuthenticationRequest;
import com.example.myapplication.model.CreatePaymentSessionTokenRequest;
import com.example.myapplication.model.CreatePaymentSessionTokenResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DeeplinkApi{
public IDeepLinkHostListener iDeepLinkHostListener;

public static String your_url_service;
public DeeplinkApi(IDeepLinkHostListener deepLinkHostListener){
  this.iDeepLinkHostListener = deepLinkHostListener;
}
private Gson gsonBuilder = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
            .setLenient()
            .serializeNulls()
            .create();
private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(your_url_service)
            .addConverterFactory(GsonConverterFactory.create(gsonBuilder))
            .build();

public IDeeplinkService iDeeplinkService = retrofit.create(IDeeplinkService.class);

  public void callAuthenticateAndCreatePaymentSessionService() {
    Call<AuthenticateResponse> callAuthentication = iDeeplinkService.authenticate(new AuthenticationRequest("applicationLoginId", "password"));
    callAuthentication.enqueue(new Callback<AuthenticateResponse>() {
      @Override
      public void onResponse(Call<AuthenticateResponse> call, Response<AuthenticateResponse> response) {
        if (response.code() == 200) {
          callCreatePaymentSessionService();
        }
      }
      @Override
      public void onFailure(Call<AuthenticateResponse> call, Throwable t) {

      }
    });
  }

public void callCreatePaymentSessionService (){
  Call<CreatePaymentSessionTokenResponse> callSessionId = iDeeplinkService.createpaymentsessiontoken("your_token", new CreatePaymentSessionTokenRequest());
  callSessionId.enqueue(new Callback<CreatePaymentSessionTokenResponse>() {
    @Override
    public void onResponse(Call<CreatePaymentSessionTokenResponse> call, Response<CreatePaymentSessionTokenResponse> response) {


      if (response.code() == 200) {
        iDeepLinkHostListener.onCallSoftPosEvent("your_paymentSessionToken");
      }
      else if  (response.code() == 500){
        iDeepLinkHostListener.onError("response code 500");
      }

    }

    @Override
    public void onFailure(Call<CreatePaymentSessionTokenResponse> call, Throwable t) {

    }
  });
}
}
