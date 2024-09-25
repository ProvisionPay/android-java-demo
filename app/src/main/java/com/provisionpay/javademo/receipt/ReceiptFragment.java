package com.provisionpay.javademo.receipt;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.provisionpay.android.deeplinksdk.model.ReceiptDetail;
import com.provisionpay.android.deeplinksdk.model.Transaction;
import com.provisionpay.javademo.R;

import java.util.ArrayList;
import java.util.Map;

public class ReceiptFragment extends DialogFragment {
    private Transaction transaction;
    private ReceiptAdapter adapter;

    public ReceiptFragment(Transaction transaction) {
        this.transaction = transaction;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_Material_Light_NoActionBar_Fullscreen);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_receipt, container, false);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        adapter = new ReceiptAdapter();
        RecyclerView recyclerView = view.findViewById(R.id.receipt_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.requireContext()));

        ArrayList<ReceiptRowItem> list = createPaymentDoneReceipt(transaction);
        adapter.submitList(list);
        recyclerView.setAdapter(adapter);
        super.onViewCreated(view, savedInstanceState);
    }

    private ArrayList<ReceiptRowItem> createPaymentDoneReceipt(Transaction paymentResponse) {
        ArrayList<ReceiptRowItem> list = new ArrayList<>();

        if (paymentResponse.getReceipt() != null && paymentResponse.getReceipt().getDetail() != null) {
            for (ReceiptDetail entry : paymentResponse.getReceipt().getDetail()) {
                boolean isApproved = entry.getKey().equals("Status") && paymentResponse.getReceipt().getApproved();
                list.add(new ReceiptRowItem(entry.getKey(), entry.getValue()));
            }
        }

        return list;
    }
}
