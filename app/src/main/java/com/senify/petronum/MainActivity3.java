package com.senify.petronum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void calcularPrecioViaje(View view) {
        // RETRIEVE AND PARSE DATA

        RadioButton radioButton3 = findViewById(R.id.radioButtonL100KM);
        RadioButton radioButton = findViewById(R.id.radioButtonKML);

            try {
                // If radioButton is checked -> calculate using km/L
                if(radioButton.isChecked()) {
                    // CONSUMO
                    // Create object of textBoxConsumo

                    EditText consumo = (EditText) findViewById(R.id.textBoxConsumo);
                    // Take the input and convert it to int
                    String consumoStr = consumo.getText().toString();
                    double consumoDouble = Double.parseDouble(consumoStr);

                    // CONSUMO
                    EditText distancia = (EditText) findViewById(R.id.textBoxDistancia);
                    String distanciaStr = distancia.getText().toString();
                    double distanciaDouble = Double.parseDouble(distanciaStr);

                    // Precio Sopa
                    EditText precioSopa = (EditText) findViewById(R.id.textBoxPrecioSopa);
                    String precioSopaStr = precioSopa.getText().toString();
                    double precioSopaDouble = Double.parseDouble(precioSopaStr);

                    // CALCULATE OUTPUTS
                    // GASOFA USADA
                    double gasolinaUsadaDouble = (distanciaDouble/consumoDouble);
                    double precioViajeDouble = (gasolinaUsadaDouble*precioSopaDouble);

                    // Convert double to a double with only 2 decimals
                    BigDecimal precioViajeBd = new BigDecimal(precioViajeDouble).setScale(2, RoundingMode.HALF_UP);
                    double precioViajeDouble2d = precioViajeBd.doubleValue();

                    // Convert double to a double with only 2 decimals
                    BigDecimal gasolinaReqBd = new BigDecimal(gasolinaUsadaDouble).setScale(2, RoundingMode.HALF_UP);
                    double gasolinaReqDouble2d = gasolinaReqBd.doubleValue();

                    // Open Results Activity
                    Intent abrirMA3res = new Intent(MainActivity3.this, MainActivity3Results.class);
                    abrirMA3res.putExtra("resultadoPrecio", precioViajeDouble2d); // lleva el resultado precio al activity resultado
                    abrirMA3res.putExtra("resultadoGasofaReq", gasolinaReqDouble2d);
                    startActivity(abrirMA3res);
                }
                // Calculate using L/100km
                else if(radioButton3.isChecked()) {
                    EditText consumo = (EditText) findViewById(R.id.textBoxConsumo);
                    // Take the input and convert it to int
                    String consumoStr = consumo.getText().toString();
                    double consumoDouble = Double.parseDouble(consumoStr);

                    // CONSUMO
                    EditText distancia = (EditText) findViewById(R.id.textBoxDistancia);
                    String distanciaStr = distancia.getText().toString();
                    double distanciaDouble = Double.parseDouble(distanciaStr);

                    // Precio Sopa
                    EditText precioSopa = (EditText) findViewById(R.id.textBoxPrecioSopa);
                    String precioSopaStr = precioSopa.getText().toString();
                    double precioSopaDouble = Double.parseDouble(precioSopaStr);

                    // CALCULATE OUTPUTS
                    // GASOFA USADA
                    double gasolinaUsadaDouble = ((consumoDouble*distanciaDouble)/100);
                    double precioViajeDouble = (gasolinaUsadaDouble*precioSopaDouble);

                    // Convert double to a double with only 2 decimals
                    BigDecimal precioViajeBd = new BigDecimal(precioViajeDouble).setScale(2, RoundingMode.HALF_UP);
                    double precioViajeDouble2d = precioViajeBd.doubleValue();

                    // Convert double to a double with only 2 decimals
                    BigDecimal gasolinaReqBd = new BigDecimal(gasolinaUsadaDouble).setScale(2, RoundingMode.HALF_UP);
                    double gasolinaReqDouble2d = gasolinaReqBd.doubleValue();

                    // Convert double to a double with only 2 decimals
                    BigDecimal distanciaBd = new BigDecimal(distanciaDouble).setScale(2, RoundingMode.HALF_UP);
                    double distanciaBdDouble2d = distanciaBd.doubleValue();

                    // Open Results Activity
                    Intent abrirMA3res = new Intent(MainActivity3.this, MainActivity3Results.class);
                    abrirMA3res.putExtra("resultadoPrecio", precioViajeDouble2d); // lleva el resultado precio al activity resultado
                    abrirMA3res.putExtra("resultadoGasofaReq", gasolinaReqDouble2d);
                    abrirMA3res.putExtra("resultadoDistancia", distanciaBdDouble2d);
                    startActivity(abrirMA3res);
                }


            } catch (Exception e)  {
                Toast.makeText(MainActivity3.this,"No has introducido todos los valores", Toast.LENGTH_LONG).show();
            }
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}