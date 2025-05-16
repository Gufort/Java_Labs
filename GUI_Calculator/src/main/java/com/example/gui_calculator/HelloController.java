package com.example.gui_calculator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class HelloController {
    @FXML
    private TextField display;

    @FXML
    protected void handleNumberButton(ActionEvent event) {
        Button button = (Button) event.getSource();
        display.setText(display.getText() + button.getText());
    }

    @FXML
    protected void handleEqualButton(ActionEvent event) {
        String expression = display.getText();
        expression = expression.replaceAll("\\s+", "");

        while(expression.contains("(")){
            int indexOpen = expression.lastIndexOf("(");
            int indexClose = expression.indexOf(")", indexOpen);

            if(indexClose == -1) display.setText("Error!!!");
            String sub = expression.substring(indexOpen+1, indexClose);
            double subResult = simpleExpression(sub);

            expression = expression.substring(0, indexOpen) + subResult + expression.substring(indexClose + 1);
        }

        double result = simpleExpression(expression);

        String res = "";
        if(result == (long) result) {
            res = String.format("%d", (long) result);
        }
        else res = String.format("%s", result);
        display.setText(res);
    }

    private double simpleExpression(String expression) {
        String[] tokens = expression.split("(?<=[+\\-*/])|(?=[+\\-*/])");//До и после
        List<Double> numbers = new ArrayList<>();
        List<String> operators = new ArrayList<>();

        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if (token.matches("[+\\-*/]")) {
                //Обработка минуса
                if (token.equals("-") && (i == 0 || operators.size() > numbers.size())) {
                    i++;
                    numbers.add(Double.parseDouble("-" + tokens[i]));
                } else {
                    operators.add(token);
                }
            } else {
                numbers.add(Double.parseDouble(token));
            }
        }

        for (int i = 0; i < operators.size(); i++) {
            String op = operators.get(i);
            if (op.equals("*") || op.equals("/")) {
                double a = numbers.get(i);
                double b = numbers.get(i+1);
                double result = op.equals("*") ? a * b : a / b;

                numbers.set(i, result);
                numbers.remove(i+1);
                operators.remove(i);
                i--;
            }
        }

        double result = numbers.get(0);
        for (int i = 0; i < operators.size(); i++) {
            String op = operators.get(i);
            double num = numbers.get(i+1);
            result = op.equals("+") ? result + num : result - num;
        }

        return result;
    }


    @FXML
    protected void handleOperatorButton(ActionEvent event) {
        Button button = (Button) event.getSource();
        display.setText(display.getText() + button.getText());
    }

    @FXML
    protected void handleClearButton(ActionEvent event) {
        display.setText("");
    }

    @FXML
    protected void handleBackButton(ActionEvent event) {
        display.setText(display.getText().substring(0, display.getText().length()-1));
    }
}