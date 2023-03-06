package com.example.myapplication.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.R;
import com.provisionpay.android.deeplinksdk.SoftposDeeplinkSdk;
import com.provisionpay.android.deeplinksdk.SoftposDeeplinkSdkListener;
import com.provisionpay.android.deeplinksdk.broadcastReceiver.BroadcastReceiverListener;
import com.provisionpay.android.deeplinksdk.model.InitializeConfig;
import com.provisionpay.android.deeplinksdk.model.IntentDataError;
import com.provisionpay.android.deeplinksdk.model.PaymentFailedResult;
import com.provisionpay.android.deeplinksdk.model.SoftposErrorType;
import com.provisionpay.android.deeplinksdk.model.Transaction;

public class PaymentFragment extends Fragment{
   public Button paymentButton;
   public EditText amount;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_payment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        paymentButton = view.findViewById(R.id.payment);
        SoftposDeeplinkSdk.Companion.initialize(new InitializeConfig("your_privateKey",requireActivity(),"softpos_url"));
        SoftposDeeplinkSdk.Companion.setDebugMode(true);

        paymentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            SoftposDeeplinkSdk.Companion.startPayment("your_paymentSessionToken","your_softposUrl");

            }
        });
      SoftposDeeplinkSdk.Companion.subscribe(new SoftposDeeplinkSdkListener() {
          @Override
          public void onPaymentDone(Transaction transaction, boolean b) {

          }

          @Override
          public void onOfflineDecline(PaymentFailedResult paymentFailedResult) {

          }

          @Override
          public void onCancel() {

          }

          @Override
          public void onError(Throwable throwable) {

          }

          @Override
          public void onTimeOut() {

          }

          @Override
          public void onSoftposError(SoftposErrorType softposErrorType, String s) {

          }

          @Override
          public void onIntentDataNotFound(IntentDataError intentDataError) {

          }
      });

      SoftposDeeplinkSdk.Companion.registerBroadcastReceiver("your_packageID", new BroadcastReceiverListener() {
          @Override
          public void onSoftposBroadcastReceived(int i, String s, String s1) {

          }
      });

    }

    @Override
    public void onPause() {
        super.onPause();
        SoftposDeeplinkSdk.Companion.unregisterBroadcastReceiver();
    }
}