package com.example.calculator_gb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private Calculator calculator;
    private TextView text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY);


        int[] numbers = new int[]{
                R.id.numb0,
                R.id.nubm1,
                R.id.numb2,
                R.id.numb3,
                R.id.numb4,
                R.id.numb5,
                R.id.numb6,
                R.id.numb7,
                R.id.numb8,
                R.id.numb9,
                R.id.numbDot,
                R.id.numbPlusOrMinus
        };

        int[] actions = new int[]{
                R.id.numbX,
                R.id.numbPlus,
                R.id.numbMin,
                R.id.numbDel,
                R.id.numbSumm,
                R.id.numbProcent

        };
        text = findViewById(R.id.summ);


        calculator = new Calculator();

        View.OnClickListener numberButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.onNumPressed(v.getId());
                text.setText(calculator.getText());
            }
        };

        View.OnClickListener actionButtonOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.onActionPressed(v.getId());
                text.setText(calculator.getText());
            }
        };

        for (int i = 0; i < numbers.length; i++) {
            findViewById(numbers[i]).setOnClickListener(numberButtonClickListener);
        }
        for (int i = 0; i < actions.length; i++) {
            findViewById(actions[i]).setOnClickListener(actionButtonOnClickListener);

        }

        findViewById(R.id.numbAC).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.reset();
                text.setText(calculator.getText());
            }
        });


        TextView textView = findViewById(R.id.summ);
        Button btn1 = findViewById(R.id.nubm1);
        Button btn2 = findViewById(R.id.numb2);
        Button btn3 = findViewById(R.id.numb3);
        Button btn4 = findViewById(R.id.numb4);
        Button btn5 = findViewById(R.id.numb5);
        Button btn6 = findViewById(R.id.numb6);
        Button btn7 = findViewById(R.id.numb7);
        Button btn8 = findViewById(R.id.numb8);
        Button btn9 = findViewById(R.id.numb9);

        Button[] btns = {btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9};

        Intent getIntent = getIntent();

        if (getIntent.hasExtra(Intent.EXTRA_TEXT) && getIntent.hasExtra(Intent.EXTRA_COMPONENT_NAME)) {
            int getColorFromSettings = getIntent.getIntExtra(Intent.EXTRA_TEXT, 0);
            int colorForButtons = getIntent.getIntExtra(Intent.EXTRA_COMPONENT_NAME, 0);
            textView.setBackgroundColor(getColorFromSettings);

            for (int i = 0; i < btns.length; i++) {
                btns[i].setBackgroundColor(colorForButtons);
            }
        } else if (getIntent.hasExtra(Intent.EXTRA_PACKAGE_NAME) && getIntent.hasExtra(Intent.EXTRA_REFERRER)) {
            int getColorFromSettings = getIntent.getIntExtra(Intent.EXTRA_PACKAGE_NAME, 0);
            int colorForButtons = getIntent.getIntExtra(Intent.EXTRA_REFERRER, 0);
            textView.setBackgroundColor(getColorFromSettings);

            for (int i = 0; i < btns.length; i++) {
                btns[i].setBackgroundColor(colorForButtons);

            }

        }
    }

    public void ChangeToSettingsActivity(View view) {
        Intent intent = new Intent(MainActivity.this, settings.class);
        startActivity(intent);
    }

}
