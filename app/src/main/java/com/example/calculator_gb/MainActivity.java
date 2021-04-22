package com.example.calculator_gb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Calculator calculator;
    private TextView text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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
                R.id.numbDot
        };

        int[] actions = new int[]{
                R.id.numbX,
                R.id.numbPlus,
                R.id.numbMin,
                R.id.numbDel,
                R.id.numbSumm

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

    }
}
