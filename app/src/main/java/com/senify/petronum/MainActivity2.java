package com.senify.petronum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void goCalcularPrecioViaje(View view) {
        Intent abrirMA3 = new Intent(MainActivity2.this, MainActivity3.class);
        startActivity(abrirMA3);
        finish();
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed(); // No se puede ir hacia atrás
    }

    public void goAboutApp(View view) {
        Intent abrirMA4 = new Intent(MainActivity2.this, MainActivity4.class);
        startActivity(abrirMA4);
        finish();
    }
}