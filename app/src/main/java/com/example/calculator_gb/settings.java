package com.example.calculator_gb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class settings extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


    }

    public void changeThemeFirstActivty(View view) {

        int newColorForBack = Color.RED;
        int colorForButtons = Color.BLUE;

        Intent intent = new Intent(settings.this, MainActivity.class);

        intent.putExtra(Intent.EXTRA_TEXT, newColorForBack);
        intent.putExtra(Intent.EXTRA_COMPONENT_NAME, colorForButtons);


        startActivity(intent);

    }

    public void standartThemeForClack(View view) {
        int standartColorForBack = Color.BLACK;
        int standartColorForButton = Color.DKGRAY;

        Intent intent = new Intent(settings.this, MainActivity.class);

        intent.putExtra(Intent.EXTRA_PACKAGE_NAME, standartColorForBack);
        intent.putExtra(Intent.EXTRA_REFERRER, standartColorForButton);

        startActivity(intent);
    }
}