package com.example.myapplication;



import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.R;
import android.content.Intent;
import android.os.Bundle;

import com.example.myapplication.fragment.PaymentFragment;
import com.provisionpay.android.deeplinksdk.SoftposDeeplinkSdk;
import com.provisionpay.android.deeplinksdk.SoftposDeeplinkSdkListener;
import com.provisionpay.android.deeplinksdk.model.IntentDataError;
import com.provisionpay.android.deeplinksdk.model.PaymentFailedResult;
import com.provisionpay.android.deeplinksdk.model.SoftposErrorType;
import com.provisionpay.android.deeplinksdk.model.Transaction;

import java.util.function.Function;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.main_activity,new PaymentFragment()).commit();

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        SoftposDeeplinkSdk.Companion.handleDeeplinkTransaction();
    }
}