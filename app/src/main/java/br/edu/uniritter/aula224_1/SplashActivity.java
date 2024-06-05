package br.edu.uniritter.aula224_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;
import java.util.concurrent.Executors;

import br.edu.uniritter.aula224_1.database.Cliente;
import br.edu.uniritter.aula224_1.databinding.ActivitySplashBinding;
import br.edu.uniritter.aula224_1.models.Post;
import br.edu.uniritter.aula224_1.services.ClienteServices;
import br.edu.uniritter.aula224_1.services.UserServices;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

public class SplashActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_splash);
        ActivitySplashBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_splash);

        Post p = new Post(null,1, "Titulo", "Corpo do post.");
        binding.setPost(p);
        binding.setActivity(this);

        Button btn = findViewById(R.id.buttonOK);
        //List<Cliente> clientes = ClienteServices.getInstance(this).getAll();

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
        Executors.newSingleThreadExecutor().execute(() -> {
            Cliente cli = new Cliente();
            cli.nomeFantasia = "Fantasia";
            cli.razaoSocial = "Razão";
            cli.cnpj = "123456789";
            cli.telefone = "51999999999";
            ClienteServices.getInstance(getApplicationContext()).insert(cli);
            Log.d("", "onClick: "+cli.id+ " - "+cli.nomeFantasia);
            List<Cliente> clientes = ClienteServices.getInstance(this).getAll();
            for (Cliente cliente : clientes) {
                Log.d("", "for: "+cliente.id+ " - "+cliente.nomeFantasia);

            }
            Log.d("",clientes+"");
        });

    }
}