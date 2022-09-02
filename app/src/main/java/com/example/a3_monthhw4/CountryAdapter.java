package com.example.a3_monthhw4;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {
    private ArrayList<Country> countries;
    private OnItemClick onItemClick;

    public CountryAdapter(ArrayList<Country> countries, OnItemClick onItemClick) {
        this.countries = countries;
        this.onItemClick = onItemClick;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CountryViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_country, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        holder.bind(countries.get(position));
    }


    @Override
    public int getItemCount() {
        return countries.size();
    }


    class CountryViewHolder extends RecyclerView.ViewHolder {
        private ImageView flag;
        private TextView name;

        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);
            flag = itemView.findViewById(R.id.flag);
            name = itemView.findViewById(R.id.name);
        }

        public void bind(Country country) {
            name.setText(country.getName());
            flag.setImageResource(country.getImage());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClick.openNewActivity(countries.get(getLayoutPosition()));
                }
            });
        }
    }
}
