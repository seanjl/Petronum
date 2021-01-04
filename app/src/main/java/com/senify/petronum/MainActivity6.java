package com.senify.petronum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MainActivity6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public void calcularCuantosLhay(View view) {
        try {
            // Get value from seekBar
            SeekBar seekBar = findViewById(R.id.seekBarMA6);
            double sbTanqueUsado = seekBar.getProgress();
            int sbTanqueUsadoInt = seekBar.getProgress();

            // Get value from EditText
            EditText capacidadDeposito = (EditText) findViewById(R.id.editTextMA6capDeposito);
            // Take the input and convert it to int, then to double
            String capDepositoStr = capacidadDeposito.getText().toString();
            double capDepositoDouble = Double.parseDouble(capDepositoStr);

            // CALCULATE OUTPUT
            double gasolinaRestante = (capDepositoDouble*(sbTanqueUsado/100));

            // Convert double to a double with only 2 decimals
            BigDecimal gasolinaRestanteBd = new BigDecimal(gasolinaRestante).setScale(2, RoundingMode.HALF_UP);
            double gasolinaRestante2d = gasolinaRestanteBd.doubleValue();

            // UPDATE TEXT VIEW: Create object of textViewM6_3 (litros en el deposito)
            TextView litrosRestantesLABEL = (TextView)findViewById(R.id.textViewM6_3);
            litrosRestantesLABEL.setText("Hay " + gasolinaRestante2d + "L de gásolina en el depósito (" + sbTanqueUsadoInt + "%)" );


        } catch (Exception e)  {
            Toast.makeText(MainActivity6.this,"No has introducido todos los valores", Toast.LENGTH_LONG).show();
        }
    }

    public void calcularDondeLlegar(View view) {
        try {
            // Get value from seekBar
            SeekBar seekBar = findViewById(R.id.seekBarMA6);
            double sbTanqueUsado = seekBar.getProgress();
            int sbTanqueUsadoInt = seekBar.getProgress();

            // Get value from EditText
            EditText capacidadDeposito = (EditText) findViewById(R.id.editTextMA6capDeposito);
            // Take the input and convert it to int, then to double
            String capDepositoStr = capacidadDeposito.getText().toString();
            double capDepositoDouble = Double.parseDouble(capDepositoStr);

            // CALCULATE OUTPUT
            double gasolinaRestante = (capDepositoDouble*(sbTanqueUsado/100));

            // Convert double to a double with only 2 decimals
            BigDecimal gasolinaRestanteBd = new BigDecimal(gasolinaRestante).setScale(2, RoundingMode.HALF_UP);
            double gasolinaRestante2d = gasolinaRestanteBd.doubleValue();

            // UPDATE TEXT VIEW: Create object of textViewM6_3 (litros en el deposito)
            TextView litrosRestantesLABEL = (TextView)findViewById(R.id.textViewM6_3);
            litrosRestantesLABEL.setText("Hay " + gasolinaRestante2d + "L de gásolina en el depósito (" + sbTanqueUsadoInt + "%)" );

            // Open Results Activity
            Intent abrirMA3 = new Intent(MainActivity6.this, MainActivity5.class);
            abrirMA3.putExtra("litrosParaUsar", sbTanqueUsadoInt); // lleva el resultado sbTanqueUsadoInt al activity5 para calcular cómo de lejos puede llegar con la gasolina que queda
            startActivity(abrirMA3);

        } catch (Exception e)  {
            Toast.makeText(MainActivity6.this,"No has introducido todos los valores", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}