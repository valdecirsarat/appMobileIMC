package com.example.appimc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etPeso;
    private EditText etAltura;
    private Button btCalcular;
    private Button btLimpar;
    private TextView tvResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPeso = (EditText) findViewById(R.id.etPeso);
        etAltura = (EditText) findViewById(R.id.etAltura);
        tvResultado = (TextView) findViewById(R.id.tvResultado);
        btCalcular = (Button) findViewById(R.id.btCalcular);
        btLimpar = (Button) findViewById(R.id.btLimpar);

        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btCalcularOnClick();
            }
        });

        btLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btLimparOnClick();
            }
        });

    }

    public void btCalcularOnClick() {
        if (etPeso.getText().toString().equals("")) {
            Toast.makeText(this, getString(R.string.erropeso), Toast.LENGTH_LONG).show();
            etPeso.requestFocus();
            return;
        }
        if (etAltura.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), getString(R.string.erroaltura), Toast.LENGTH_LONG).show();
            etAltura.requestFocus();
            return;
        }
        double peso = Double.parseDouble(etPeso.getText().toString());
        double altura = Double.parseDouble(etAltura.getText().toString());
        double imc = 0;

        if (Locale.getDefault().getLanguage().equals("en")) {
            imc = peso * 703 / Math.pow(altura, 2);
        } else {
            imc = peso / Math.pow(altura, 2);
        }

//        tvResultado.setText(new DecimalFormat("0.00").format(imc));

        NumberFormat nf = NumberFormat.getNumberInstance(Locale.getDefault());
        DecimalFormat df = (DecimalFormat) nf;
        tvResultado.setText(df.format(imc));
    }
    private void btLimparOnClick() {
        etPeso.setText("");
        etAltura.setText("");
        tvResultado.setText(getString(R.string.zeros));
    }



}