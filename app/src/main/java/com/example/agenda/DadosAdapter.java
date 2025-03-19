package com.example.agenda;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DadosAdapter extends RecyclerView.Adapter<> {

    private ArrayList<Contato> lista;

    public DadosAdapter(ArrayList<Contato> lista) {
        this.lista = lista;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
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
