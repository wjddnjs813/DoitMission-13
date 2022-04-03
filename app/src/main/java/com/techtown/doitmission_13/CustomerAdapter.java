package com.techtown.doitmission_13;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.ViewHolder> {
    ArrayList<Customer> items = new ArrayList<Customer>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.customer_item, viewGroup, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Customer item = items.get(position);
        viewHolder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(Customer item) {
        items.add(item);
    }

    public void setItems(ArrayList<Customer> items) {
        this.items = items;
    }

    public Customer getItem(int position) {
        return items.get(position);
    }

    public void setItem(int position, Customer item) {
        items.set(position, item);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        TextView textView2;
        TextView textView3;

        public ViewHolder(View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.textView);
            textView2 = itemView.findViewById(R.id.textView2);
            textView3 = itemView.findViewById(R.id.textView3);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION) {
                        Toast.makeText(view.getContext(), items.get(pos).getName() + items.get(pos).getBirthDate() + "\n" + items.get(pos).getPhoneNum(), Toast.LENGTH_SHORT).show();

                        notifyItemChanged(pos);
                    }
                }
            });
        }

        public void setItem(Customer item) {
            textView.setText(item.getName());
            textView2.setText(item.getBirthDate());
            textView3.setText(item.getPhoneNum());
        }
    }
}
