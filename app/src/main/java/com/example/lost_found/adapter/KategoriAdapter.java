package com.example.lost_found.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lost_found.R;
import com.example.lost_found.model.Kategori;

import java.util.ArrayList;

public class KategoriAdapter extends RecyclerView.Adapter<KategoriAdapter.KategoriViewHolder> {

    ArrayList<Kategori> listData = new ArrayList<>();

    public class KategoriViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView textNamaKategori;
        public KategoriViewHolder(@NonNull View itemView) {
            super(itemView);
            textNamaKategori = itemView.findViewById(R.id.textNamaKategori);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            if(listener != null){
                listener.onClick(view, listData.get(getAdapterPosition()));
            }
        }
    }



    OnKategoriHolderClickListener listener = null;

    public interface OnKategoriHolderClickListener{
        void onClick(View view, Kategori kategori);

    }

    public void setListener(OnKategoriHolderClickListener listener) {
        this.listener = listener;
    }

    public void setListData(ArrayList<Kategori> listData) {
        this.listData = listData;
    }

    @NonNull
    @Override
    public KategoriViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_category, parent, false);
        return new KategoriViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KategoriViewHolder holder, int position) {
        Kategori kategori = listData.get(position);
        holder.textNamaKategori.setText(kategori.nama);
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }




}
