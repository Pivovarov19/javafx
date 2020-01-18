package io.pivovarov.calculator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class CalculatorController {
    @FXML
    public TextField field;

    @FXML
    public void onMouseClickListener(MouseEvent mouseEvent) {
        int[] nums = new int[2];
        //nums[0] = 0;
        //nums[1] = 0;

        if (mouseEvent.getSource() instanceof Button) {
            Button button = (Button) mouseEvent.getSource();
            System.out.println("Pressed button: " + button.getText());
            switch (button.getText()) {
                case "CE":
                    field.setText("");
                    break;
                /*
                case "+":
                    nums[0] = Integer.parseInt(field.getText());
                    field.setText("");
                break;
                */
                case "=":
                    String[] words = field.getText().split("+");
                    field.setText("");
                    for (String word : words) {
                        field.setText(field.getText() + word);
                    }
                    break;
                default:
                    field.setText(field.getText() + button.getText());
            }
        }
    }

    @FXML
    public void onKeyPressedListener(KeyEvent keyEvent) {
        switch (keyEvent.getText()) {
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
            case "+":
            case "-":
            case "/":
            case "*":
            case "=":
                System.out.println("Pressed button: " + keyEvent.getText());
                field.setText(field.getText() + keyEvent.getText());
        }
    }
}
