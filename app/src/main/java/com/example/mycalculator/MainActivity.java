package com.example.mycalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText text;
    private Calculator calculator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculator = new Calculator();
        text = findViewById(R.id.calculate);

        int[] numbers = new int[]{
                R.id.btn_0,
                R.id.btn_1,
                R.id.btn_2,
                R.id.btn_3,
                R.id.btn_4,
                R.id.btn_5,
                R.id.btn_6,
                R.id.btn_7,
                R.id.btn_8,
                R.id.btn_9

        };

        View.OnClickListener onClickListenerNumber = view -> {
            calculator.pressButtonNumber(view.getId());
            text.setText(calculator.getText());
        };

        for (int number : numbers) {
            findViewById(number).setOnClickListener(onClickListenerNumber);
        }

        int[] operate = new int[]{
                R.id.btn_plus,
                R.id.btn_minus,
                R.id.btn_multi,
                R.id.btn_divide,
                R.id.btn_equal,
        };

        View.OnClickListener onClickListenerOperate = view -> {
            calculator.pressButtonOperation(view.getId());
            text.setText(calculator.getText());
        };

        for (int item : operate) {
            findViewById(item).setOnClickListener(onClickListenerOperate);
            text.setText(calculator.getText());
        }

        findViewById(R.id.btn_clear).setOnClickListener(view -> {
            calculator.presClear();
            text.setText(calculator.getText());
        });

        findViewById(R.id.btn_backspace).setOnClickListener(view -> {
            calculator.presBackSpace();
            text.setText(calculator.getText());
        });

        findViewById(R.id.btn_point).setOnClickListener(view -> {
            calculator.pressPoint();
            text.setText(calculator.getText());
        });

    }

}