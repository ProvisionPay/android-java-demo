package com.example.myapplication;

public interface IDeepLinkHostListener {
    public void onCallSoftPosEvent(String paymentSessionToken);
    public void onError(String error);
}

