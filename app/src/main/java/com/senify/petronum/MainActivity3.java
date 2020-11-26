package com.senify.petronum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.math.RoundingMode;

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
            try {
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
                BigDecimal precioViajeBd = new BigDecimal(precioViajeDouble).setScale(3, RoundingMode.HALF_UP);
                double precioViajeDouble2d = precioViajeBd.doubleValue();

                // Convert double to a double with only 2 decimals
                BigDecimal gasolinaReqBd = new BigDecimal(gasolinaUsadaDouble).setScale(3, RoundingMode.HALF_UP);
                double gasolinaReqDouble2d = gasolinaReqBd.doubleValue();

                // UPDATE TEXT VIEW: Create object of textViewM3_resPrec (resultado precio)
                TextView precioViajeRes = (TextView)findViewById(R.id.textViewM3_lbl_precio);
                precioViajeRes.setText("Precio del viaje: " + precioViajeDouble2d + " €");

                // UPDATE TEXT VIEW: Create object of textViewM3_resGas (resultado gasofa usada)
                TextView precioGasRes = (TextView)findViewById(R.id.textViewM3_lbl_gaso);
                precioGasRes.setText("Gasolina requerida: " + gasolinaReqBd + " L");
            } catch (Exception e)  {
                Toast.makeText(MainActivity3.this,"No has introducido todos los valores", Toast.LENGTH_LONG).show();
            }
    }

    @Override
    public void onBackPressed() {
        Intent abrirMA2 = new Intent(MainActivity3.this, MainActivity2.class);
        startActivity(abrirMA2);
        finish();
    }
}