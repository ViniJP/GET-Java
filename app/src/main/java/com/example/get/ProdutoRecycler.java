package com.example.get;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProdutoRecycler extends RecyclerView.Adapter<ProdutoRecycler.MyViewHolder> {

    private ArrayList<Produto> produtos;

    public ProdutoRecycler(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    @NonNull
    @Override
    public ProdutoRecycler.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_produto, parent, false);

        return new MyViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull ProdutoRecycler.MyViewHolder holder, int position) {

        Produto produto = produtos.get(position);

        try {
            holder.titulo.setText(produto.getTitulo());
            holder.imagem.setImageResource(produto.getImagem());
            holder.textoExtra.setText(produto.getExtra());
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return produtos.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView titulo;
        ImageView imagem;
        TextView textoExtra;

        MyViewHolder(View itemView) {
            super(itemView);

            titulo = itemView.findViewById(R.id.textoTitulo);
            imagem = itemView.findViewById(R.id.image);
            textoExtra = itemView.findViewById(R.id.textoExtra_adapter_produto);
        }
    }
}
