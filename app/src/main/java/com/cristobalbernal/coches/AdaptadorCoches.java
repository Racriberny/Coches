package com.cristobalbernal.coches;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdaptadorCoches extends RecyclerView.Adapter<AdaptadorCoches.CochesViewHolder>{
    private final Coche[] coches;
    private final IOnClickListener listener;

    public AdaptadorCoches(Coche[] coches, IOnClickListener listener) {
        this.coches = coches;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CochesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_coches,parent,false);
        return new CochesViewHolder(itemView,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull CochesViewHolder holder, int position) {
        Coche coche = coches[position];
        holder.bindCoches(coche);
    }

    @Override
    public int getItemCount() {
        return coches.length;
    }

    public static class CochesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private final TextView marca;
        private final TextView color;
        private final IOnClickListener listener;
        public CochesViewHolder(@NonNull View itemView, IOnClickListener listener) {
            super(itemView);
            marca = itemView.findViewById(R.id.tvMarcaDato);
            color = itemView.findViewById(R.id.tvColorDato);
            this.listener = listener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (listener !=null){
                listener.IOnClick(getAdapterPosition());
            }
        }

        public void bindCoches(Coche coche) {
            marca.setText(coche.getMarca());
            color.setText(coche.getColor());
        }
    }
}
