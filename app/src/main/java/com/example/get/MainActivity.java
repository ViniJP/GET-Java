package com.example.get;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.util.PatternsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final ArrayList<Produto> produtos = new ArrayList<>();
    private final ArrayList<Produto> produtos2 = new ArrayList<>();
    private final ArrayList<Produto> produtos3 = new ArrayList<>();
    private final ArrayList<Produto> produtos4 = new ArrayList<>();
    private final ArrayList<Produto> produtos5 = new ArrayList<>();
    private String emailCadastrado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        if (!sharedPreferences.contains("jaAbriuApp")) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("jaAbriuApp", true);
            editor.apply();
            startActivity(new Intent(this, SlidesActivity.class));
        }

        CardView cardView = findViewById(R.id.cardView);
        CardView cardView2 = findViewById(R.id.cardView2);
        CardView cardView3 = findViewById(R.id.cardView3);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirEntrega(view);
            }
        });

        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirCaixaUmClique();
            }
        });

        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirCaixaInscricao();
            }
        });

        popularProdutos1();
        popularProdutos2();
        popularProdutos3();
        popularProdutos4();
        popularProdutos5();
    }


    private void popularProdutos1() {
        RecyclerView recyclerView;
        ProdutoRecycler adaptador;

        recyclerView = findViewById(R.id.recyclerView);
        adaptador = new ProdutoRecycler(produtos);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adaptador);

        Produto produto1 = new Produto(getString(R.string.title_switch_mario), getString(R.string.desc_switch_mario), getString(R.string.extra_switch_mario), R.drawable.switch_1_mario);
        Produto produto2 = new Produto(getString(R.string.title_switch_pokemon), getString(R.string.desc_switch_pokemon), getString(R.string.extra_switch_pokemon), R.drawable.switch_2_pokemon_shield);
        Produto produto3 = new Produto(getString(R.string.title_switch_dk), getString(R.string.desc_switch_dk), getString(R.string.extra_switch_dk), R.drawable.switch_3_donkey_kong);
        Produto produto4 = new Produto(getString(R.string.title_switch_megaman), getString(R.string.desc_switch_megaman), getString(R.string.extra_switch_megaman), R.drawable.switch_4_mega_man);
        Produto produto5 = new Produto(getString(R.string.title_switch_crash), getString(R.string.desc_switch_crash), getString(R.string.extra_switch_crash), R.drawable.switch_5_crash);

        produtos.add(produto1);
        produtos.add(produto2);
        produtos.add(produto3);
        produtos.add(produto4);
        produtos.add(produto5);
        adaptador.notifyDataSetChanged();

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Produto produto = produtos.get(position);
                Log.i("produtoDebug", String.valueOf(position));
                Log.i("produtoDebug", produtos.get(position).getTitulo());
                Log.i("produtoDebug", produtos.get(position).getDescricao());

                Intent intent = new Intent(MainActivity.this, ProdutoActivity.class);
                intent.putExtra("produto", produto);
                startActivity(intent);
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        }));
    }

    private void popularProdutos3() {
        RecyclerView recyclerView;
        ProdutoRecycler adaptador;

        recyclerView = findViewById(R.id.recyclerView2);
        adaptador = new ProdutoRecycler(produtos2);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adaptador);

        Produto produto1 = new Produto(getString(R.string.title_ps4_lastOfUs), getString(R.string.desc_ps4_lastOfUs), getString(R.string.extra_ps4_lastOfUs), R.drawable.ps4_1_last_of_us);
        Produto produto2 = new Produto(getString(R.string.title_ps4_daysGone), getString(R.string.desc_ps4_daysGone), getString(R.string.extra_ps4_daysGone), R.drawable.ps4_2_days_gone);
        Produto produto3 = new Produto(getString(R.string.title_ps4_redDead), getString(R.string.desc_ps4_redDead), getString(R.string.extra_ps4_redDead), R.drawable.ps4_3_red_dead);
        Produto produto4 = new Produto(getString(R.string.title_ps4_fifa21), getString(R.string.desc_ps4_fifa21), getString(R.string.extra_ps4_fifa21), R.drawable.ps4_4_fifa_21);
        Produto produto5 = new Produto(getString(R.string.title_ps4_watchDogs), getString(R.string.desc_ps4_watchDogs), getString(R.string.extra_ps4_watchDogs), R.drawable.ps4_5_watch_dogs_legion);

        produtos2.add(produto1);
        produtos2.add(produto2);
        produtos2.add(produto3);
        produtos2.add(produto4);
        produtos2.add(produto5);
        adaptador.notifyDataSetChanged();

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Produto produto = produtos2.get(position);
                Intent intent = new Intent(MainActivity.this, ProdutoActivity.class);
                intent.putExtra("produto", produto);
                startActivity(intent);
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        }));
    }

    private void popularProdutos2() {
        RecyclerView recyclerView;
        ProdutoRecycler adaptador;

        recyclerView = findViewById(R.id.recyclerView3);
        adaptador = new ProdutoRecycler(produtos3);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adaptador);

        Produto produto1 = new Produto(getString(R.string.title_ps5_demonSouls), getString(R.string.desc_ps5_demonSouls), getString(R.string.extra_ps5_demonSouls), R.drawable.ps5_1_demons_souls);
        Produto produto2 = new Produto(getString(R.string.title_ps5_spiderMan), getString(R.string.desc_ps5_spiderMan), getString(R.string.extra_ps5_spiderMan), R.drawable.ps5_2_spider_man_miles_morales);
        Produto produto3 = new Produto(getString(R.string.title_ps5_acValhala), getString(R.string.desc_ps5_acValhala), getString(R.string.extra_ps5_acValhala), R.drawable.ps5_3_assassin_creed_valhala);
        Produto produto4 = new Produto(getString(R.string.title_ps5_sackboy), getString(R.string.desc_ps5_sackboy), getString(R.string.extra_ps5_sackboy), R.drawable.ps5_4_sackboy);
        Produto produto5 = new Produto(getString(R.string.title_ps5_destruction), getString(R.string.desc_ps5_destruction), getString(R.string.extra_ps5_destruction), R.drawable.ps5_5_destruction_allstars);

        produtos3.add(produto1);
        produtos3.add(produto2);
        produtos3.add(produto3);
        produtos3.add(produto4);
        produtos3.add(produto5);
        adaptador.notifyDataSetChanged();

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Produto produto = produtos3.get(position);
                Intent intent = new Intent(MainActivity.this, ProdutoActivity.class);
                intent.putExtra("produto", produto);
                startActivity(intent);
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        }));
    }

    private void popularProdutos4() {
        RecyclerView recyclerView;
        ProdutoRecycler adaptador;

        recyclerView = findViewById(R.id.recyclerView4);
        adaptador = new ProdutoRecycler(produtos4);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adaptador);

        Produto produto1 = new Produto(getString(R.string.title_xboxOne_cyberphunk), getString(R.string.desc_xboxOne_cyberphunk), getString(R.string.extra_xboxOne_cyberphunk), R.drawable.xboxone_1_cyberphunk);
        Produto produto2 = new Produto(getString(R.string.title_xboxOne_pes21), getString(R.string.desc_xboxOne_pes21), getString(R.string.extra_xboxOne_pes21), R.drawable.xboxone_2_pes_21);
        Produto produto3 = new Produto(getString(R.string.title_xboxOne_marvel), getString(R.string.desc_xboxOne_marvel), getString(R.string.extra_xboxOne_marvel), R.drawable.xboxone_3_marvel_avengers);
        Produto produto4 = new Produto(getString(R.string.title_xboxOne_gta5), getString(R.string.desc_xboxOne_gta5), getString(R.string.extra_xboxOne_gta5), R.drawable.xboxone_4_gta5);
        Produto produto5 = new Produto(getString(R.string.title_xboxOne_witcher), getString(R.string.desc_xboxOne_witcher), getString(R.string.extra_xboxOne_witcher), R.drawable.xboxone_5_thewitcher3);

        produtos4.add(produto1);
        produtos4.add(produto2);
        produtos4.add(produto3);
        produtos4.add(produto4);
        produtos4.add(produto5);
        adaptador.notifyDataSetChanged();

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Produto produto = produtos4.get(position);
                Intent intent = new Intent(MainActivity.this, ProdutoActivity.class);
                intent.putExtra("produto", produto);
                startActivity(intent);
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        }));
    }

    private void popularProdutos5() {
        RecyclerView recyclerView;
        ProdutoRecycler adaptador;

        recyclerView = findViewById(R.id.recyclerView5);
        adaptador = new ProdutoRecycler(produtos5);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adaptador);

        Produto produto1 = new Produto(getString(R.string.title_xboxX_mortalKombat), getString(R.string.desc_xboxX_mortalKombat), getString(R.string.extra_xboxX_mortalKombat), R.drawable.xboxx_1_mortalkombat);
        Produto produto2 = new Produto(getString(R.string.title_xboxX_callDuty), getString(R.string.desc_xboxX_callDuty), getString(R.string.extra_xboxX_callDuty), R.drawable.xboxx_2_callofduty);
        Produto produto3 = new Produto(getString(R.string.title_xboxX_trainSim), getString(R.string.desc_xboxX_trainSim), getString(R.string.extra_xboxX_trainSim), R.drawable.xboxx_3_trainsimworld2);
        Produto produto4 = new Produto(getString(R.string.title_xboxX_farCry), getString(R.string.desc_xboxX_farCry), getString(R.string.extra_xboxX_farCry), R.drawable.xboxx_4_farcry6);
        Produto produto5 = new Produto(getString(R.string.title_xboxX_halo), getString(R.string.desc_xboxX_halo), getString(R.string.extra_xboxX_halo), R.drawable.xboxx_5_haloinfinite);

        produtos5.add(produto1);
        produtos5.add(produto2);
        produtos5.add(produto3);
        produtos5.add(produto4);
        produtos5.add(produto5);
        adaptador.notifyDataSetChanged();

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Produto produto = produtos5.get(position);
                Intent intent = new Intent(MainActivity.this, ProdutoActivity.class);
                intent.putExtra("produto", produto);
                startActivity(intent);
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        }));
    }

    private void abrirEntrega(View v){
        startActivity(new Intent(MainActivity.this, Entrega.class));
    }

    private void abrirCaixaInscricao() {
        AlertDialog.Builder caixaEmail = new AlertDialog.Builder(MainActivity.this);
        caixaEmail.setTitle("Inscreva-se");
        caixaEmail.setMessage("Olá, estamos na fase Beta, os produtos ainda não estão disponíveis para compra, cadastre seu email e informaremos quando a compra estiver disponível.");
        caixaEmail.setCancelable(false);
        final EditText emailCadastrar = new EditText(MainActivity.this);
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
                    Toast.makeText(MainActivity.this, emailCadastrado, Toast.LENGTH_LONG).show();

                }

            }
        });
        caixaEmail.create();
        caixaEmail.show();
    }


    private void abrirCaixaUmClique() {
        AlertDialog.Builder caixaEmail = new AlertDialog.Builder(MainActivity.this);
        caixaEmail.setTitle("Compra fácil");
        caixaEmail.setMessage("Compra fácil é a funcionalidade que facilita sua compra, depois de fazer cadastro e de efetuar uma compra a próxima será mais fácil, com um clique você faz sua compra e recebe seu produto em pouco tempo na caixa de correio de maneira discreta.");
        caixaEmail.setCancelable(true);
        caixaEmail.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                abrirCaixaInscricao();
            }
        });
        caixaEmail.create();
        caixaEmail.show();
    }
}