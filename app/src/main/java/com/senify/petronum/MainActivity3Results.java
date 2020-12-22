package com.senify.petronum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity3Results extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity3_results);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent abrirMA3res = getIntent();
        Double resultadoPrecioGasolina = abrirMA3res.getDoubleExtra("resultadoPrecio", 0);
        Double resultadoGasolinaRequerida = abrirMA3res.getDoubleExtra("resultadoGasofaReq", 0);

        // UPDATE TEXT VIEW: Create object of textViewM3_resPrec (resultado precio)
        TextView precioViajeRes = (TextView)findViewById(R.id.textViewM3res_lbl_precio);
        precioViajeRes.setText("Precio del viaje:");

        // UPDATE TEXT VIEW: Create object of textViewM3res_PRECIO (resultado precio)
        TextView precioViajeResLABEL = (TextView)findViewById(R.id.textViewM3res_PRECIO);
        precioViajeResLABEL.setText(resultadoPrecioGasolina + "€");

        // UPDATE TEXT VIEW: Create object of textViewM3_resGas (resultado gasofa usada)
        TextView precioGasRes = (TextView)findViewById(R.id.textViewM3res_lbl_gaso);
        precioGasRes.setText("Gasolina requerida:");

        // UPDATE TEXT VIEW: Create object of textViewM3res_GASO (resultado gasofa usada)
        TextView precioGasResLABEL = (TextView)findViewById(R.id.textViewM3res_GASO);
        precioGasResLABEL.setText(resultadoGasolinaRequerida + "L");

    }

    @Override
    public void onBackPressed() {
        finish();
    }
}