package com.curso.pedrapapeltesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void pedra(View view){
        this.opcaoSelecionada("pedra");
    }

    public void papel(View view){
        this.opcaoSelecionada("papel");
    }

    public void tesoura(View view){
        this.opcaoSelecionada("tesoura");
    }

    public void opcaoSelecionada(String opcaoUsuario){

        ImageView imageResultado = findViewById(R.id.imageResultado); // pegando o id do image view
        TextView textResultado = findViewById(R.id.textResultado); // pegando o id do text view

        int numero = new Random().nextInt(3);

        String[] opcoes = {"pedra", "papel", "tesoura"}; // vetor de opcoes
        String opcaoApp = opcoes [numero]; // string recebendo um array com um numero aleatorio

        switch (opcaoApp){
            case "pedra" :
                imageResultado.setImageResource(R.drawable.pedra); // nova imagem a partir dos recursos q temos no program
                break;
            case "papel" :
                imageResultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura" :
                imageResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        if ((opcaoApp == "tesoura" && opcaoUsuario == "papel") || (opcaoApp == "papel" && opcaoUsuario == "pedra") || (opcaoApp == "pedra" && opcaoUsuario == "tesoura")){
            textResultado.setText("Você perdeu!"); // mudando o texto do textResultado
        }else if((opcaoUsuario == "tesoura" && opcaoApp == "papel") || (opcaoUsuario == "papel" && opcaoApp == "pedra") || (opcaoUsuario == "pedra" && opcaoApp == "tesoura")){
            textResultado.setText("Você ganhou!");
        }else{
            textResultado.setText("Empatamos!");
        }

        System.out.println("Item clicado: " + opcaoApp);
    }
}
