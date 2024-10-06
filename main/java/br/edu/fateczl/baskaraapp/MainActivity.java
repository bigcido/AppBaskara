/*
@author: Alvaro Dias
RA: 110482223004
 */
package br.edu.fateczl.baskaraapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText ValorA;
    private EditText ValorB;
    private EditText ValorC;
    private TextView txtRes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ValorA = findViewById(R.id.ValorA);
        ValorA.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        ValorB = findViewById(R.id.ValorB);
        ValorB.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        ValorC = findViewById(R.id.ValorC);
        ValorC.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        txtRes = findViewById(R.id.txtRes);
        txtRes.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        Button btnCalc = findViewById(R.id.btnCalc);

        btnCalc.setOnClickListener(op -> calc());
    }

    private void calc(){
        float NumValorA = Float.parseFloat(ValorA.getText().toString());
        float NumValorB = Float.parseFloat(ValorB.getText().toString());
        float NumValorC = Float.parseFloat(ValorC.getText().toString());

        double delta = (float)((Math.pow(NumValorB, 2) - (4 * NumValorA * NumValorC)));
            if (delta < 0){
                String res = "Delta menor que zero. Não possuirá raizes";
                txtRes.setText(res);
            } else {
                float x1 = (float) (-(NumValorB) + Math.sqrt(delta) / (2 * NumValorA));
                float x2 = (float) (-(NumValorB) - Math.sqrt(delta) / (2 * NumValorA));
                String res = getString(R.string.Raizes) + "x1 = " +x1+ "x2 = " +x2;
                txtRes.setText(res);
            }
        ValorA.setText("");
        ValorB.setText("");
        ValorC.setText("");


    }

}