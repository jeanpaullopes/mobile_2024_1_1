package br.edu.uniritter.aula224_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

import br.edu.uniritter.aula224_1.adapters.UserAdapter;
import br.edu.uniritter.aula224_1.adapters.UserAdapter2;
import br.edu.uniritter.aula224_1.models.User;
import br.edu.uniritter.aula224_1.repositories.UserRepository;
import br.edu.uniritter.aula224_1.services.UserServices;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent  = getIntent();
        setContentView(R.layout.activity_second_rv);
        RecyclerView rv = findViewById(R.id.rv1);
        UserAdapter userAdapter = new UserAdapter(UserRepository.getInstance().getAllUsers());
        ArrayList<User> lista = new ArrayList<>();
        lista.addAll(UserRepository.getInstance().getAllUsers());
        lista.addAll(UserRepository.getInstance().getAllUsers());
        lista.addAll(UserRepository.getInstance().getAllUsers());
        lista.addAll(UserRepository.getInstance().getAllUsers());

        UserAdapter2 adp2 = new UserAdapter2(lista);
        findViewById(R.id.button3).setOnClickListener((v)->{
            if (rv.getAdapter() == userAdapter)
                rv.setAdapter(adp2);
            else
                rv.setAdapter(userAdapter);

        });
        LinearLayoutManager llm = new LinearLayoutManager(this);
        LinearLayoutManager llmH = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        StaggeredGridLayoutManager sglm = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        rv.setLayoutManager(llm);
        rv.setAdapter(userAdapter);





    }
    @Override
    protected void onStart() {
      super.onStart();
      String nomes = "";
      for (User u :UserRepository.getInstance().getAllUsers() ) {
            nomes += u.getName() + "\n";
        }


    }
}