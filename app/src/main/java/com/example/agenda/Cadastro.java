package com.example.agenda;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Cadastro extends AppCompatActivity {

        SQLiteDatabase bancoDados;
        EditText nome;
        EditText email;
        EditText fone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cadastro);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            nome = findViewById(R.id.cNome);
            email = findViewById(R.id.cEmail);
            fone = findViewById(R.id.cFone);
            ImageView btnSalvar = findViewById(R.id.cSalvar);

            Button btnVoltar = findViewById(R.id.cVoltar);

            btnVoltar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent telaPrincipal = new Intent ( Cadastro.this,MainActivity.class);
                    startActivity(telaPrincipal);
                }
            });

            btnSalvar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    try {

                        if (nome.getText().toString().trim().isEmpty()) {
                            throw new Exception("Nome não pode estar vazio");
                        }
                        if (email.getText().toString().trim().isEmpty()){
                            throw new Exception("Email não pode estar vazio");
                        }
                        if (fone.getText().toString().trim().isEmpty()){
                           throw new Exception("Fone não pode estar vazio");
                        } else {
                            cadastrar();
                        }

                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(),e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });

            return insets;

        });
    }

    public void cadastrar(){
        try {
            bancoDados = openOrCreateDatabase(("crudapp",MODE_PRIVATE, null));
            String sql = "INSERT INTO agenda (nome,email, fone) VALUES (?,?,?)";
            SQLiteStatement stmt = bancoDados.compileStatement(sql);
            stmt.bindString(1, nome.getText().toString());
            stmt.bindString(2, email.getText().toString());
            stmt.bindString(3, fone.getText().toString());
            stmt.executeInsert();
            bancoDados.close();
            finish();

        } catch (Exception e){
            e.printStackTrace();
        }
    }

}