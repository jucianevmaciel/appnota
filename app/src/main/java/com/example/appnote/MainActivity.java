package com.example.appnote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.content.SharedPreferences;
import android.content.Intent;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    EditText textnome, nota1, note2, nota3;
    //Button btnsalvar, btneditar, btnremover, btncarregar;
    private Context context;
    private File internal;
    private SharedPreferences sharedPrefs;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context =getApplicationContext();
        setContentView(R.layout.activity_main);
        sharedPrefs = getSharedPreferences("myPrefs", Context.MODE_PRIVATE);




    }
    public void salvar ( View view){
        textnome = findViewById(R.id.textnome);
        nota1 = findViewById(R.id.nota1);
        nota3 = findViewById(R.id.nota3);
        note2 = findViewById(R.id.note2);


        String nome = textnome.getText().toString();
        String note1 = nota1.getText().toString();
        String nota2 = note2.getText().toString();
        String note3 = nota3.getText().toString();

        Intent intent = new Intent(this, ResultMain.class);

        // Coloque os dados do aluno no Intent como extras
        intent.putExtra("nomeAluno", nome);
        intent.putExtra("nota1", note1);
        intent.putExtra("nota2", nota2);
        intent.putExtra("nota3", note3);

        // Inicie a ResultActivity
        startActivity(intent);

        if (nome.equals("")) {
            Toast.makeText(context, "Digite um nome", Toast.LENGTH_SHORT).show();
            return;
        }

        if (nota1.equals("") || note2.equals("") || nota3.equals("")) {
            Toast.makeText(context, "Digite todas as notas", Toast.LENGTH_SHORT).show();
            return;
        }

        // Salva os dados em SharedPreferences
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString(nome, note1 + "," + nota2 + "," + note3);
        editor.apply();





    }
}