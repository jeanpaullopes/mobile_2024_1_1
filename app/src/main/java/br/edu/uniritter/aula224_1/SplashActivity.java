package br.edu.uniritter.aula224_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import br.edu.uniritter.aula224_1.services.UserServices;

public class SplashActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Button btn = findViewById(R.id.buttonOK);


        btn.setOnClickListener(this);

        btn.setOnClickListener(view -> {
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("dado", "Meu nome não é zé pequeno!");
            startActivity(intent);

        });

        findViewById(R.id.button2).setOnClickListener(view -> {
            Toast.makeText(this, "Clicou no botão 2", Toast.LENGTH_LONG).show();
            Snackbar.make(view, "Clicou no botão 2", Snackbar.LENGTH_LONG).show();
        });

        UserServices.loadUsersFromRepository(this);

    }

    @Override
    public void onClick(View view) {
        Toast.makeText(this, "Clicou no botão 3", Toast.LENGTH_LONG).show();
        Snackbar.make(view, "Clicou no botão 3", Snackbar.LENGTH_LONG).show();
    }
}