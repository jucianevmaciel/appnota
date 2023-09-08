package com.example.appnote;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.content.Intent;


public class ResultMain extends AppCompatActivity {
    private TextView nomeAlunoTextView, nota1TextView, nota2TextView, nota3TextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_main);

        nomeAlunoTextView = findViewById(R.id.nomeAlunoTextView);
        nota1TextView = findViewById(R.id.nota1TextView);
        nota2TextView = findViewById(R.id.nota2TextView);
        nota3TextView = findViewById(R.id.nota3TextView);

        Intent intent = getIntent();
        String nome = intent.getStringExtra("nomeAluno");
        String note1 = intent.getStringExtra("nota1");
        String nota2 = intent.getStringExtra("nota2");
        String note3 = intent.getStringExtra("nota3");

        // Exiba os dados do aluno nas TextViews
        nomeAlunoTextView.setText("Nome do Aluno: " + nome);
        nota1TextView.setText("Nota N1: " + note1);
        nota2TextView.setText("Nota N2: " + nota2);
        nota3TextView.setText("Nota N3: " + note3);
    }
    }








