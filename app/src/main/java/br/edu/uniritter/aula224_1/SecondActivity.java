package br.edu.uniritter.aula224_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

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
}