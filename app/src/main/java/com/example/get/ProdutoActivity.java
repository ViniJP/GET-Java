package com.example.get;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.PatternsCompat;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ProdutoActivity extends AppCompatActivity {

    private Produto produto;
    private String emailCadastrado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto);

        ImageView imageView = findViewById(R.id.imagem_act_produto);
        TextView titulo = findViewById(R.id.titulo_act_produto);
        TextView textoExtra = findViewById(R.id.extra_act_produto);
        TextView descricao = findViewById(R.id.descricao_act_produto);
        Button botao = findViewById(R.id.botaoComprar);

        Intent extra = getIntent();
        if (extra != null) {
            produto = (Produto) extra.getSerializableExtra("produto");
            Log.i("produtoDebug", "extra nao deu null");
        }


        try {
            imageView.setImageResource(produto.getImagem());
            titulo.setText(produto.getTitulo());
            textoExtra.setText(produto.getExtra());
            descricao.setText(produto.getDescricao());
        }catch (Exception e){
            e.printStackTrace();
        }

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirCaixaInscricao();
            }
        });


    }

    private void abrirCaixaInscricao() {
        AlertDialog.Builder caixaEmail = new AlertDialog.Builder(ProdutoActivity.this);
        caixaEmail.setTitle("Inscreva-se");
        caixaEmail.setMessage("Olá, estamos na fase Beta, os produtos ainda não estão disponíveis para compra, cadastre seu email e informaremos quando a compra estiver disponível.");
        caixaEmail.setCancelable(false);
        final EditText emailCadastrar = new EditText(ProdutoActivity.this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        emailCadastrar.setLayoutParams(lp);
        caixaEmail.setView(emailCadastrar);
        caixaEmail.setNegativeButton("cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        caixaEmail.setPositiveButton("enviar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        emailCadastrado = emailCadastrar.getText().toString();

                        if (PatternsCompat.EMAIL_ADDRESS.matcher(emailCadastrado).matches()){
                            Toast.makeText(ProdutoActivity.this, emailCadastrado, Toast.LENGTH_LONG).show();

                        }
                    }
                });
                caixaEmail.create();
                caixaEmail.show();
    }
}