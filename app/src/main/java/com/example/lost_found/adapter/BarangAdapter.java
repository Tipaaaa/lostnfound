package com.example.lost_found.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lost_found.MainActivity;
import com.example.lost_found.R;
import com.example.lost_found.model.Barang;

import java.util.ArrayList;

public class BarangAdapter extends RecyclerView.Adapter<BarangAdapter.BarangViewHolder> {



    ArrayList<Barang> listData = new ArrayList<>();

    public class BarangViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{

        TextView textNamaBarang, textKategori, klikDetails;
        ImageView gambarBarang;


        //ITEM BARANG  di recycle view
        public BarangViewHolder(@NonNull View itemView) {
            super(itemView);

            gambarBarang = itemView.findViewById(R.id.imageBarang);

            textNamaBarang = itemView.findViewById(R.id.textNamaBarang);
            textKategori = itemView.findViewById(R.id.textKategori);
            klikDetails = itemView.findViewById(R.id.klikDetails);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(listener != null){
                listener.onClick(v, listData.get(getAdapterPosition()));
            }

        }
    }

    // Click Listener
    OnBarangHolderClickListener listener = null;

    public interface OnBarangHolderClickListener{
        void onClick(View v,  Barang barang);

    }

    public void setListener(OnBarangHolderClickListener listener) {
        this.listener = listener;
    }

    public void setListData(ArrayList<Barang> listData) {
        this.listData = listData;
        notifyDataSetChanged();
    }

    @NonNull
    @Override


    public BarangViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_barang, parent, false);
        return new BarangViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BarangViewHolder holder, int position) {
        Barang barang = listData.get(position);
        holder.textNamaBarang.setText(barang.nama);
        holder.textKategori.setText(barang.Kategori);
        holder.klikDetails.setText(barang.lokasi);
        String namaGambar = barang.gambarB;

        int[] namaGB = {R.drawable.iphone};

        holder.gambarBarang.setImageResource(namaGB[0]);

    }
    public static int getImageId(Context context, String imageName) {
        return context.getResources().getIdentifier("drawable/" + imageName, null, context.getPackageName());
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }


}
