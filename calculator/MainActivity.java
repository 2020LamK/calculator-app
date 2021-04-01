package edu.ysu.klam.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private final Calculator calculator;
    private EditText display;

    public MainActivity() {
        super();
        calculator = new Calculator();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = this.findViewById(R.id.display);

        // numbers
        Button button0 = this.findViewById(R.id.button0);
        button0.setOnClickListener(v -> handleInput(0));

        Button button1 = this.findViewById(R.id.button1);
        button1.setOnClickListener(v -> handleInput(1));

        Button button2 = this.findViewById(R.id.button2);
        button2.setOnClickListener(v -> handleInput(2));

        Button button3 = this.findViewById(R.id.button3);
        button3.setOnClickListener(v -> handleInput(3));

        Button button4 = this.findViewById(R.id.button4);
        button4.setOnClickListener(v -> handleInput(4));

        Button button5 = this.findViewById(R.id.button5);
        button5.setOnClickListener(v -> handleInput(5));

        Button button6 = this.findViewById(R.id.button6);
        button6.setOnClickListener(v -> handleInput(6));

        Button button7 = this.findViewById(R.id.button7);
        button7.setOnClickListener(v -> handleInput(7));

        Button button8 = this.findViewById(R.id.button8);
        button8.setOnClickListener(v -> handleInput(8));

        Button button9 = this.findViewById(R.id.button9);
        button9.setOnClickListener(v -> handleInput(9));

        // operators + - * /
        Button addButton = this.findViewById(R.id.addButton);
        addButton.setOnClickListener(v -> handleOperator(Operator.Add));

        Button subButton = this.findViewById(R.id.subButton);
        subButton.setOnClickListener(v -> handleOperator(Operator.Subtract));

        Button multButton = this.findViewById(R.id.multButton);
        multButton.setOnClickListener(v -> handleOperator(Operator.Multiply));

        Button divButton = this.findViewById(R.id.divButton);
        divButton.setOnClickListener(v -> handleOperator(Operator.Divide));

        // equals
        this.findViewById(R.id.equalButton).setOnClickListener(v -> {
            calculator.equals();
            display.setText(calculator.getInput());
        });

        // clear
        this.findViewById(R.id.acButton).setOnClickListener(v -> {
            calculator.clear();
            display.setText(calculator.getInput());
        });

        // posNeg
        this.findViewById(R.id.posNegButton).setOnClickListener(v-> {
            calculator.changeSign();
            display.setText(calculator.getInput());
        });

        // decimal
        this.findViewById(R.id.decButton).setOnClickListener(v -> {
            calculator.addDecimal();
            display.setText(calculator.getInput());
        });

        // percent
        this.findViewById(R.id.percentButton).setOnClickListener(v -> {
            calculator.percent();
            display.setText(calculator.getInput());
        });
    }

    private void handleInput(Integer number) {
        calculator.inputNumber(number);
        display.setText(calculator.getInput());
    }

    private void handleOperator(Operator operator) {
        calculator.inputOperator(operator);
        display.setText(calculator.getInput());
    }
}
