package com.provisionpay.javademo;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import com.provisionpay.android.deeplinksdk.SoftposDeeplinkSdk;
import com.provisionpay.javademo.fragment.PaymentFragment;

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