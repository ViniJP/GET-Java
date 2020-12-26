package com.example.get;

import java.io.Serializable;

public class Produto implements Serializable {
    private String titulo, descricao, extra;
    private int imagem;

    public Produto(String titulo, String descricao, String extra, int imagem) {
        this.titulo = titulo;
        this.imagem = imagem;
        this.descricao = descricao;
        this.extra = extra;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getExtra() {
        return extra;
    }

    public int getImagem() {
        return imagem;
    }
}
