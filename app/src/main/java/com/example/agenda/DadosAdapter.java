package com.example.agenda;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class DadosAdapter extends RecyclerView.Adapter<DadosAdapter.DadosViewHolder> {

    private ArrayList<Contato> dadosLista;

    public DadosAdapter(ArrayList<Contato> dadosLista) {
        this.dadosLista = dadosLista;
    }

    @NonNull
    @Override
    public DadosAdapter.DadosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new DadosViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DadosAdapter.DadosViewHolder holder, int position) {

        Contato contatos = dadosLista.get(position);

        holder.id.setText(String.valueOf(contatos.getCodigo()));
        holder.nome.setText(String.valueOf(contatos.getNome()));
        holder.email.setText(String.valueOf(contatos.getEmail()));
        holder.fone.setText(String.valueOf(contatos.getFone()));

    }

    @Override
    public int getItemCount() {
        return dadosLista.size();
    }

    public class DadosViewHolder extends RecyclerView.ViewHolder {

        TextView id;
        TextView nome;
        TextView email;
        TextView fone;

        public DadosViewHolder(@NonNull View itemView){
            super(itemView);
            id = itemView.findViewById(R.id.iCodigo);
            nome = itemView.findViewById(R.id.iNome);
            email = itemView.findViewById(R.id.iEmail);
            fone = itemView.findViewById(R.id.iFone);
        }

    }





}
