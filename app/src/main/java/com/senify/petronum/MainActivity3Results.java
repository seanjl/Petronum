package com.senify.petronum;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity3Results extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity3_results);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent abrirMA3res = getIntent();
        Double resultadoDistance = abrirMA3res.getDoubleExtra("resultadoDistancia", 0);
        Double resultadoPrecioGasolina = abrirMA3res.getDoubleExtra("resultadoPrecio", 0);
        Double resultadoGasolinaRequerida = abrirMA3res.getDoubleExtra("resultadoGasofaReq", 0);

        // UPDATE TEXT VIEW: Create object of textViewM3res_datosIntrod (resultado precio)
        TextView labelDatosIntrod = (TextView)findViewById(R.id.textViewM3res_datosIntrod);
        labelDatosIntrod.setText("Para un viaje de " + resultadoDistance + "km:");

        // UPDATE TEXT VIEW: Create object of textViewM3res_PRECIO (resultado precio)
        TextView precioViajeResLABEL = (TextView)findViewById(R.id.textViewM3res_PRECIO);
        precioViajeResLABEL.setText(resultadoPrecioGasolina + "€");

        // UPDATE TEXT VIEW: Create object of textViewM3res_GASO (resultado gasofa usada)
        TextView precioGasResLABEL = (TextView)findViewById(R.id.textViewM3res_GASO);
        precioGasResLABEL.setText(resultadoGasolinaRequerida + "L");

        // Animate car picture
        final View imageCar = findViewById(R.id.img_car);

        ObjectAnimator scaleDown = ObjectAnimator.ofPropertyValuesHolder(imageCar,
                PropertyValuesHolder.ofFloat("scaleX", 1.4f),
                PropertyValuesHolder.ofFloat("scaleY", 1.4f));
        scaleDown.setDuration(1700);

        scaleDown.setRepeatCount(ObjectAnimator.INFINITE);
        scaleDown.setRepeatMode(ObjectAnimator.REVERSE);

        scaleDown.start();
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}