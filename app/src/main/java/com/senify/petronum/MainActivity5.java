package com.senify.petronum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MainActivity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public void calcularDistanciaCanRec(View view) {
        // RETRIEVE AND PARSE DATA

        RadioButton radioButton = findViewById(R.id.radioButtonKML);
        RadioButton radioButton3 = findViewById(R.id.radioButtonL100KM);

        try {
            // If radioButton is checked -> calculate using km/L
            if(radioButton.isChecked()) {
                // CONSUMO
                // Create object of textBoxConsumo

                EditText consumo = (EditText) findViewById(R.id.textBoxConsumo);
                // Take the input and convert it to int
                String consumoStr = consumo.getText().toString();
                double consumoDouble = Double.parseDouble(consumoStr);

                // GASOLINA USAR
                EditText gasolinaUsar = (EditText) findViewById(R.id.textBoxDeposito);
                String gasolinaUsarStr = gasolinaUsar.getText().toString();
                double gasolinaUsarDouble = Double.parseDouble(gasolinaUsarStr);

                // CALCULATE OUTPUTS
                double distanciaDouble = (gasolinaUsarDouble*consumoDouble);

                // Convert double to a double with only 2 decimals
                BigDecimal distanciaDoubleBd = new BigDecimal(distanciaDouble).setScale(2, RoundingMode.HALF_UP);
                double distanciaDouble2d = distanciaDoubleBd.doubleValue();

                // Convert double to a double with only 2 decimals
                BigDecimal gasolinaUsarDoubleBd = new BigDecimal(gasolinaUsarDouble).setScale(2, RoundingMode.HALF_UP);
                double gasolinaUsarDouble2d = gasolinaUsarDoubleBd.doubleValue();

                // Open Results Activity
                Intent abrirMA5res = new Intent(MainActivity5.this, MainActivity5Results.class);
                abrirMA5res.putExtra("resultadoDistancia", distanciaDouble2d); // lleva el resultado precio al activity resultado
                abrirMA5res.putExtra("resultadoGasolinaUsar", gasolinaUsarDouble2d);
                startActivity(abrirMA5res);
            }
            // Calculate using L/100km
            else if(radioButton3.isChecked()) {
                // CONSUMO
                // Create object of textBoxConsumo

                EditText consumo = (EditText) findViewById(R.id.textBoxConsumo);
                // Take the input and convert it to int
                String consumoStr = consumo.getText().toString();
                double consumoDouble = Double.parseDouble(consumoStr);

                // GASOLINA USAR
                EditText gasolinaUsar = (EditText) findViewById(R.id.textBoxDeposito);
                String gasolinaUsarStr = gasolinaUsar.getText().toString();
                double gasolinaUsarDouble = Double.parseDouble(gasolinaUsarStr);

                // CALCULATE OUTPUTS
                // GASOFA USADA
                double distanciaDouble = (gasolinaUsarDouble*100)/consumoDouble;

                // Convert double to a double with only 2 decimals
                BigDecimal distanciaDoubleBd = new BigDecimal(distanciaDouble).setScale(2, RoundingMode.HALF_UP);
                double distanciaDouble2d = distanciaDoubleBd.doubleValue();

                // Convert double to a double with only 2 decimals
                BigDecimal gasolinaUsarDoubleBd = new BigDecimal(gasolinaUsarDouble).setScale(2, RoundingMode.HALF_UP);
                double gasolinaUsarDouble2d = gasolinaUsarDoubleBd.doubleValue();

                // Open Results Activity
                Intent abrirMA5res = new Intent(MainActivity5.this, MainActivity5Results.class);
                abrirMA5res.putExtra("resultadoDistancia", distanciaDouble2d); // lleva el resultado precio al activity resultado
                abrirMA5res.putExtra("resultadoGasolinaUsar", gasolinaUsarDouble2d);
                startActivity(abrirMA5res);
            }


        } catch (Exception e)  {
            Toast.makeText(MainActivity5.this,"No has introducido todos los valores", Toast.LENGTH_LONG).show();
        }
    }


    @Override
    public void onBackPressed() {
        finish();
    }
}