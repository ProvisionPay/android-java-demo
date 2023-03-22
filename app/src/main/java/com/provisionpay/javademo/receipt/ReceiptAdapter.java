package com.provisionpay.javademo.receipt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import com.provisionpay.javademo.R;

import java.util.ArrayList;
import java.util.List;

class ReceiptAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<ReceiptRowItem> items = new ArrayList<>();

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ReceiptViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.receipt_list_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ReceiptViewHolder) {
            ((ReceiptViewHolder) holder).bind(items.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void submitList(List<ReceiptRowItem> receiptList) {
        items = receiptList;
    }

    public static class ReceiptViewHolder extends RecyclerView.ViewHolder {

        private final TextView caption;
        private final TextView label;

        public ReceiptViewHolder(View itemView) {
            super(itemView);
            caption = itemView.findViewById(R.id.caption);
            label = itemView.findViewById(R.id.label);
        }

        public void bind(ReceiptRowItem receiptBind) {
            caption.setText(receiptBind.caption);
            label.setText(receiptBind.label);
        }
    }
}
