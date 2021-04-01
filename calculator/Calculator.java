package edu.ysu.klam.calculator;

public class Calculator {
    private static final String INITIAL_VALUE = "0";

    private String input;
    private String previousInput;
    private Operator operator;
    private Boolean clearInput;

    public Calculator() {
        this.input = INITIAL_VALUE;
        this.previousInput = INITIAL_VALUE;
        this.clearInput = false;
    }

    public void inputNumber(Integer number) {
        if (clearInput) {
            previousInput = input;
            input = number.toString();
            clearInput = false;
        } else if (input.equals(INITIAL_VALUE)) {
            input = number.toString();
        } else {
            input += number.toString();
        }
    }

    public void inputOperator(Operator operator) {
        if (this.operator != null && this.clearInput != true ) {
            this.calculateTotal();
        }
        this.operator = operator;
        this.clearInput = true;
    }

    public void equals() {
        if (previousInput.equals(INITIAL_VALUE)) {
            previousInput = input;
        }
        if (this.operator != null) {
            calculateTotal();
        }
        this.clearInput = true;
    }

    public void clear() {
        input = INITIAL_VALUE;
        previousInput = INITIAL_VALUE;
        clearInput = false;
        operator = null;
    }

    public void changeSign() {
        Double val = Double.parseDouble(input);
        val *= -1;
        input = val.toString();
    }

    public void addDecimal() {
        if (!input.contains(".")) {
            input = input + '.';
        }
    }

    public void percent() {
        Double val = Double.parseDouble(input);
        val = val / 100;
        input = val.toString();
    }

    private void calculateTotal() {
        Double total = 0.0;
        Double valueOne = Double.parseDouble(previousInput);
        Double valueTwo = Double.parseDouble(input);

        switch (operator) {
            case Add:
                total = valueOne + valueTwo;
                break;
            case Subtract:
                total = valueOne - valueTwo;
                break;
            case Multiply:
                total = valueOne * valueTwo;
                break;
            case Divide:
                total = valueOne / valueTwo;
                break;
        }
        input = total.toString();
    }

    public String getInput() {
        return this.input;
    }
}
