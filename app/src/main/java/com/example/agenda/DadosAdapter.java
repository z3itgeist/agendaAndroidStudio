package com.example.agenda;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DadosAdapter extends RecyclerView.Adapter<DadosAdapter.DadosViewHolder> {

    private ArrayList<Contato> lista;

    public DadosAdapter(ArrayList<Contato> lista) {
        this.lista = lista;
    }

    @NonNull
    @Override
    public DadosAdapter.DadosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new DadosViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class DadosViewHolder extends RecyclerView.ViewHolder {

        public DadosViewHolder(@NonNull View itemView){
            super(itemView);
        }

    }





}
