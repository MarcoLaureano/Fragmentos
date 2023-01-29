package com.example.fragmentado1;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ArrayList<Entidades> entidades;
    RecyclerView bandeja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        correoAparece();

        }

    private void correo() {
        entidades.add(new Entidades("Google","Te damos la bienvenida a Gmail!"));
        entidades.add(new Entidades("Youtube","League of Legends ha subido un video"));
        entidades.add(new Entidades("Mama","Te has olvidado tu merienda"));

    }

    private void correoAparece(){
        bandeja = findViewById(R.id.reciclarCorreo);
        bandeja.setLayoutManager(new LinearLayoutManager(this));
        entidades = new ArrayList<>();

        correo();

        Adaptador adaptador = new Adaptador(entidades);
        adaptador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager= getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();

                bandejaFragments fragmento= new bandejaFragments();
                transaction.replace(R.id.linear, fragmento);
                transaction.commit();
            }
        });
        bandeja.setAdapter(adaptador);
    }

}

