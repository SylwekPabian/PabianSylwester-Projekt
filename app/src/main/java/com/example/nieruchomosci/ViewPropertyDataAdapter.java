package com.example.nieruchomosci;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewPropertyDataAdapter extends RecyclerView.Adapter<ViewPropertyDataAdapter.MyViewHolder> {

    private ViewPropertyData[] dataset;
    private ViewPropertyActivity parentActivity;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView property_address;
        public TextView property_price;
        public Button details_button;

        public MyViewHolder(View rowItemView) {
            super(rowItemView);

            property_address = (TextView) rowItemView.findViewById(R.id.property_address);
            property_price = (TextView) rowItemView.findViewById(R.id.property_price);
            details_button = (Button) rowItemView.findViewById(R.id.details_button);
        }
    }

    public ViewPropertyDataAdapter(ViewPropertyData[] data, ViewPropertyActivity activity) {
        dataset = data;
        parentActivity = activity;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_property_row_layout, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.property_address.setText(dataset[position].propertyAddress);
        holder.property_price.setText(String.valueOf(dataset[position].propertyPrice) + " zł.");
        if (Session.instance.userType == Session.UserType.Anonymous) {
            holder.details_button.setVisibility(View.GONE);
        }
        holder.details_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(parentActivity, ViewPropertyDetailsActivity.class);
                intent.putExtra(ViewPropertyActivity.EXTRA_PROPERTY_ID, dataset[position].propertyId);
                Session.instance.selectedPropertyData = dataset[position];
                parentActivity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataset.length;
    }
}
