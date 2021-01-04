package com.senify.petronum;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.CycleInterpolator;
import android.widget.TextView;

public class MainActivity5Results extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity5_results);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent abrirMA5res = getIntent();
        Double resultadoDistanciaRecorrible = abrirMA5res.getDoubleExtra("resultadoDistancia", 0);
        Double resultadoGasolinaAusar = abrirMA5res.getDoubleExtra("resultadoGasolinaUsar", 0);

        // UPDATE TEXT VIEW: Create object of textViewM5res_DISTANCIA (resultado precio)
        TextView puedesRecorrerLABEL = (TextView)findViewById(R.id.textViewM5res_recorrer);
        puedesRecorrerLABEL.setText("- Utilizando " + resultadoGasolinaAusar + "L de gásolina, puedes recorrer:");

        // UPDATE TEXT VIEW: Create object of textViewM5res_DISTANCIA (resultado precio)
        TextView distanciaResLABEL = (TextView)findViewById(R.id.textViewM5res_DISTANCIA);
        distanciaResLABEL.setText(resultadoDistanciaRecorrible + "km");

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