package br.edu.uniritter.aula224_1;

import androidx.appcompat.app.AppCompatActivity;

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

import java.util.Iterator;

import br.edu.uniritter.aula224_1.models.User;
import br.edu.uniritter.aula224_1.repositories.UserRepository;
import br.edu.uniritter.aula224_1.services.UserServices;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent  = getIntent();
        setContentView(R.layout.activity_second);
        TextView tv = findViewById(R.id.textoCentral);
        tv.setText(intent.getStringExtra("dado"));

        tv.setOnClickListener(v->{
            LinearLayout ll = findViewById(R.id.layoutVertical);
            for (int i = 1; i <= 10; i++) {
                TextView tv2 = new TextView(this);
                tv2.setText("Linha " + i);
                EditText ed = new EditText(this);
                ed.setHint("Digite algo");

                ll.addView(tv2);
                ll.addView(ed);
            }
        });

    }
    @Override
    protected void onStart() {
      super.onStart();
      String nomes = "";
      for (User u :UserRepository.getInstance().getAllUsers() ) {
            nomes += u.getName() + "\n";
        }
        TextView tv = findViewById(R.id.textoCentral);
        tv.setText(nomes);

    }
}