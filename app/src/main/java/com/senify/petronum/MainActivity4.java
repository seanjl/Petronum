package com.senify.petronum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
    }

    @Override
    public void onBackPressed() {
        Intent abrirMA2 = new Intent(MainActivity4.this, MainActivity2.class);
        startActivity(abrirMA2);
        finish();
    }
}