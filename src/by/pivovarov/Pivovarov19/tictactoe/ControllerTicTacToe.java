package by.pivovarov.Pivovarov19.tictactoe;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class ControllerTicTacToe {
    boolean isX = true;
    //ModelTicTacToe model = new ModelTicTacToe();
    @FXML
    Label turnOutput;
    @FXML
    Label display;
    @FXML
    Button restartButton;
    @FXML
    Button upLeft;
    @FXML
    Button up;
    @FXML
    Button upRight;
    @FXML
    Button left;
    @FXML
    Button center;
    @FXML
    Button right;
    @FXML
    Button bottomLeft;
    @FXML
    Button bottom;
    @FXML
    Button bottomRight;

    @FXML
    public void onMouseClickListener(MouseEvent mouseEvent) {
        if (mouseEvent.getSource() instanceof Button) {
            Button button = (Button) mouseEvent.getSource();
            if (button.getText() == "") {
                if (isX == true) {
                    button.setText("X");
                    isX = false;
                    turnOutput.setText("0");
                } else {
                    button.setText("0");
                    isX = true;
                    turnOutput.setText("X");
                }
                //buttonPressed(button.getId());
            } else if (button.getId().equals("restartButton")) {
                upLeft.setText("");
                up.setText("");
                upRight.setText("");
                left.setText("");
                center.setText("");
                right.setText("");
                bottomLeft.setText("");
                bottom.setText("");
                bottomRight.setText("");
                display.setText("Welcome to Tic-Tac-Toe!");
                isX = true;
                turnOutput.setText("X");
            }
            System.out.println("Pressed button: " + button.getId());
            // Win Controller
            if ((upLeft.getText().equals(up.getText()) && upLeft.getText().equals(upRight.getText())) // up floor
                    || (upLeft.getText().equals(left.getText()) && upLeft.getText().equals(bottomLeft.getText())) // left colomn
                    || (upLeft.getText().equals(center.getText()) && upLeft.getText().equals(bottomRight.getText())) // upLeft to bottomRight diagonal
                    || (up.getText().equals(center.getText()) && up.getText().equals(bottom.getText())) // center colomn
                    || (upRight.getText().equals(center.getText()) && upRight.getText().equals(bottomLeft.getText())) // upRight to bottomLeft diagonal
                    || (upRight.getText().equals(right.getText()) && upRight.getText().equals(bottomRight.getText())) // right colomn
                    || (left.getText().equals(center.getText()) && left.getText().equals(right.getText())) // center floor
                    || (bottomLeft.getText().equals(bottom.getText()) && bottomLeft.getText().equals(bottomRight.getText()))) {  // bottom floor
                if (isX == true) {
                    display.setText("0 WINS, restart the game");

                } else if(isX == false) {
                    display.setText("X WINS, restart the game");
                }
            }
        }


    }
}