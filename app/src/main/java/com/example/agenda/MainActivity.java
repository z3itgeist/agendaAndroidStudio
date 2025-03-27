package com.example.agenda;

import android.content.Intent;
import android.database.AbstractCursor;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase bancoDados;

    private RecyclerView recyclerViewDados;

    private DadosAdapter dadosAdapter;

    private ArrayList<Contato> listaDados;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

                recyclerViewDados = findViewById(R.id.RecyclerView);

                criarBancoDados();

                recyclerViewDados.setLayoutManager(new LinearLayoutManager(this));
                listaDados = new ArrayList<>();
                dadosAdapter = new DadosAdapter(listaDados);
                recyclerViewDados.setAdapter(dadosAdapter);

                listarDados();

            ImageView btnCad = findViewById(R.id.btnCad);

            btnCad.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent telaCadastro = new Intent ( MainActivity.this,Cadastro.class);
                    startActivity(telaCadastro);
                }
            });
            /*Primeiro teste de conexão de banco de dados, inserimos manualmente os dados para teste
            try{
                bancoDados = openOrCreateDatabase("crudapp", MODE_PRIVATE, null);

                bancoDados.execSQL("CREATE TABLE IF NOT EXISTS agenda(codigo INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR, email VARCHAR, fone VARCHAR )");
                bancoDados.execSQL("INSERT INTO agenda(nome,email,fone) VALUES ('Yasmin','yasmin@email.com','19919191919')");


                Cursor cursor = bancoDados.rawQuery("SELECT codigo, nome, email,fone from agenda", null);
                    int indiceCodigo = cursor.getColumnIndex("codigo");
                    int indiceNome = cursor.getColumnIndex("nome");
                    int indiceEmail = cursor.getColumnIndex("email");
                    int indiceFone = cursor.getColumnIndex("fone");
                    cursor.moveToFirst();

                    while (cursor !=null){
                        Log.i("Resultado - codigo: ", String.valueOf(cursor.getInt(indiceCodigo)));
                        Log.i("Resultado - nome: ", cursor.getString(indiceNome));
                        Log.i("Resultado - email: ",cursor.getString(indiceEmail));
                        Log.i("Resultado - fone: ", cursor.getString(indiceFone));

                            cursor.moveToNext();
                    }
            } catch (Exception e) {
                e.printStackTrace();
            }*/

            return insets;
        });
    }

    public void criarBancoDados() {
        try{
            bancoDados = openOrCreateDatabase("crudapp", MODE_PRIVATE, null);

            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS agenda(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "nome VARCHAR, email VARCHAR, fone VARCHAR)");
            bancoDados.close();
        } catch (Exception e){
            e.printStackTrace();
        }}

        public void listarDados(){
            try {
                bancoDados = openOrCreateDatabase("crudapp", MODE_PRIVATE, null);

                Cursor meuCursor = bancoDados.rawQuery("SELECT id, nome, email, fone FROM agenda", null);
                listaDados.clear();

                while (meuCursor.moveToNext()){
                    int id = meuCursor.getInt(0);
                    String nome = meuCursor.getString(1);
                    String email = meuCursor.getString(2);
                    String fone = meuCursor.getString(3);

                        listaDados.add(new Contato(id, nome, email, fone));
                }

                dadosAdapter.notifyDataSetChanged();
                bancoDados.close();


            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        protected void onResume(){
            super.onResume();
            listarDados();
        }

    }
