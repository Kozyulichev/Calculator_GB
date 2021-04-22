package com.example.calculator_gb;

public class Calculator {
    private int firstNumb;
    private int secondNumb;

    private StringBuilder inputStr = new StringBuilder();
    private int actionSelected;

    private State state;

    private enum State {
        firstNumbInput,
        secondNumbInput,
        resultShow
    }

    public Calculator() {
        state = State.firstNumbInput;
    }

    public void onNumPressed(int buttonId) {

        if (state == State.resultShow) {
            state = State.firstNumbInput;
            inputStr.setLength(0);
        }

        if (inputStr.length() < 9) {
            switch (buttonId) {
                case R.id.numb0:
                    if (inputStr.length() != 0) {
                        inputStr.append("0");
                    }
                    break;
                case R.id.nubm1:
                    inputStr.append("1");
                    break;
                case R.id.numb2:
                    inputStr.append("2");
                    break;
                case R.id.numb3:
                    inputStr.append("3");
                    break;
                case R.id.numb4:
                    inputStr.append("4");
                    break;
                case R.id.numb5:
                    inputStr.append("5");
                    break;
                case R.id.numb6:
                    inputStr.append("6");
                    break;
                case R.id.numb7:
                    inputStr.append("7");
                    break;
                case R.id.numb8:
                    inputStr.append("8");
                    break;
                case R.id.numb9:
                    inputStr.append("9");
                    break;
            }

        }
    }

    public void onActionPressed(int actionId) {
        if (actionId == R.id.numbSumm && state == State.secondNumbInput && inputStr.length() > 0) {
            secondNumb = Integer.parseInt(inputStr.toString());
            state = State.resultShow;
            inputStr.setLength(0);
            switch (actionSelected) {
                case R.id.numbPlus:
                    inputStr.append(firstNumb + secondNumb);
                    break;
                case R.id.numbMin:
                    inputStr.append(firstNumb - secondNumb);
                    break;
                case R.id.numbDel:
                    inputStr.append(firstNumb / secondNumb);
                    break;
                case R.id.numbX:
                    inputStr.append(firstNumb * secondNumb);
                    break;

            }

        } else if (inputStr.length() > 0 && state == State.firstNumbInput) {
            firstNumb = Integer.parseInt(inputStr.toString());
            state = State.secondNumbInput;
            inputStr.setLength(0);
            switch (actionId) {
                case R.id.numbPlus:
                    actionSelected = R.id.numbPlus;
                    break;
                case R.id.numbMin:
                    actionSelected = R.id.numbMin;
                    break;
                case R.id.numbDel:
                    actionSelected = R.id.numbDel;
                    break;
                case R.id.numbX:
                    actionSelected = R.id.numbX;
                    break;
                case R.id.numbSumm:
                    actionSelected = R.id.numbSumm;
                    break;
            }
        }

    }


    public String getText() {
        return inputStr.toString();
    }
}
