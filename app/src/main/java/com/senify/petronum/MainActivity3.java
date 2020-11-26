package com.senify.petronum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }

    public void calcularPrecioViaje(View view) {
        // RETRIEVE AND PARSE DATA
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


            // UPDATE TEXT VIEW: Create object of textViewM3_4 (Gasolina Usada)
            TextView gasofaUsada = (TextView)findViewById(R.id.textViewM3_4);
            gasofaUsada.setText("Gasolina Usada: " + gasolinaUsadaDouble + " L");

            // UPDATE TEXT VIEW: Create object of textViewM3_4 (Gasolina Usada)
            TextView precioViaje = (TextView)findViewById(R.id.textViewM3_5);
        precioViaje.setText("Precio Viaje: " + precioViajeDouble + " €");


    }

    @Override
    public void onBackPressed() {
        Intent abrirMA2 = new Intent(MainActivity3.this, MainActivity2.class);
        startActivity(abrirMA2);
        finish();
    }
}