package io.pivovarov.calculator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class CalculatorController {
    boolean operationUsed = false;
    @FXML
    public TextField field;

    @FXML
    public void onMouseClickListener(MouseEvent mouseEvent) {
        if (mouseEvent.getSource() instanceof Button) {
            Button button = (Button) mouseEvent.getSource();
            System.out.println("Pressed button: " + button.getText());
            switch (button.getText()) {
                case "CE":
                    field.setText("");
                    break;
                case "=":
                    String[] numbers = field.getText().split("[\\+\\-\\/\\*]");
                    double result = 0.0;
                    double number1 = Float.parseFloat(numbers[0]);
                    double number2 = Float.parseFloat(numbers[1]);
                    if (field.getText().contains("+")) {
                        result = number1 + number2;
                    } else if (field.getText().contains("-")) {
                        result = number1 - number2;
                    } else if (field.getText().contains("*")) {
                        result = number1 * number2;
                    } else if (field.getText().contains("/")) {
                        result = number1 / number2;
                    }
                    field.setText(Double.toString(result));
                    break;
                /*case "+":
                case "-":
                case "/":
                case "*":
                    if(operationUsed = false) {
                        field.setText(field.getText() + button.getText());
                    }
                    operationUsed = true;
                    break;*/
                default:
                    field.setText(field.getText() + button.getText());
            }
        }
    }

    @FXML
    public void onKeyPressedListener(KeyEvent keyEvent) {

        switch (keyEvent.getText()) {
            case "=":
                String[] numbers = field.getText().split("[\\+\\-\\/\\*]");
                double result = 0.0;
                double number1 = Float.parseFloat(numbers[0]);
                double number2 = Float.parseFloat(numbers[1]);
                if (field.getText().contains("+")) {
                    result = number1 + number2;
                } else if (field.getText().contains("-")) {
                    result = number1 - number2;
                } else if (field.getText().contains("*")) {
                    result = number1 * number2;
                } else if (field.getText().contains("/")) {
                    result = number1 / number2;
                }
                field.setText(Double.toString(result));
                break;
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
            case "0":
            case ".":
                System.out.println("Pressed button: " + keyEvent.getText());
                field.setText(field.getText() + keyEvent.getText());
                break;
            /*case "+":
            case "-":
            case "/":
            case "*":
                if(operationUsed = false) {
                    field.setText(field.getText() + keyEvent.getText());
                }
                operationUsed = true;
                break;*/
            default:
                field.setText(field.getText());
        }
    }
}