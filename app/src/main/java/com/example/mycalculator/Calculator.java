package com.example.mycalculator;

public class Calculator {

    private final StringBuilder builder;
    private float firstNumber;
    private State state;
    private int actionSelected;
    private boolean dotInsert;

    public Calculator() {
        state = State.FIRST_STAT;
        builder = new StringBuilder();
    }

    public void pressButtonNumber(int idButton) {
        if (state == State.SHOW_RESULT_STATE) {
            state = State.FIRST_STAT;
        }
        if (builder.length() < 10) {
            switch (idButton) {
                case R.id.btn_0:
                    if (builder.length() != 0)
                        builder.append("0");
                    break;
                case R.id.btn_1:
                    builder.append("1");
                    break;
                case R.id.btn_2:
                    builder.append("2");
                    break;
                case R.id.btn_3:
                    builder.append("3");
                    break;
                case R.id.btn_4:
                    builder.append("4");
                    break;
                case R.id.btn_5:
                    builder.append("5");
                    break;
                case R.id.btn_6:
                    builder.append("6");
                    break;
                case R.id.btn_7:
                    builder.append("7");
                    break;
                case R.id.btn_8:
                    builder.append("8");
                    break;
                case R.id.btn_9:
                    builder.append("9");
                    break;
            }
        }
    }

    public void pressButtonOperation(int idButton) {
        if (idButton == R.id.btn_equal && state == State.SECOND_STATE) {
            float secondNumber = Float.parseFloat(builder.toString());
            state = State.SHOW_RESULT_STATE;
            builder.setLength(0);
            switch (actionSelected) {
                case R.id.btn_plus:
                    builder.append(firstNumber + secondNumber);
                    break;
                case R.id.btn_minus:
                    builder.append(firstNumber - secondNumber);
                    break;
                case R.id.btn_divide:
                    if (secondNumber != 0)
                        builder.append(firstNumber / secondNumber);
                    break;
                case R.id.btn_multi:
                    builder.append(firstNumber * secondNumber);
                    break;

            }

        } else if (builder.length() > 0 && state == State.FIRST_STAT) {
            firstNumber = Float.parseFloat(builder.toString());
            state = State.SECOND_STATE;
            builder.setLength(0);
        }

        switch (idButton) {
            case R.id.btn_plus:
                actionSelected = R.id.btn_plus;
                break;
            case R.id.btn_minus:
                actionSelected = R.id.btn_minus;
                break;
            case R.id.btn_divide:
                actionSelected = R.id.btn_divide;
                break;
            case R.id.btn_multi:
                actionSelected = R.id.btn_multi;
                break;
        }

    }

    public void presClear() {
        state = State.FIRST_STAT;
        builder.setLength(0);

    }

    public void presBackSpace() {
        if (builder.length() > 0) {
            builder.deleteCharAt(builder.length() - 1);
        }
    }

    public void pressPoint() {
        if (builder.length() == 0) {
            builder.append("0.");
            dotInsert = true;
        } else if (!dotInsert || state == State.SECOND_STATE) {
            builder.append(".");
            dotInsert = true;
        }
    }

    public String getText() {
        return builder.toString();
    }

    private enum State {
        FIRST_STAT,
        SECOND_STATE,
        SHOW_RESULT_STATE
    }

}
