package by.pivovarov.Pivovarov19.tictactoe;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class ControllerTicTacToe {
    boolean isX = true;
    int i;
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
            if (i == 0) {
                turnOutput.setText("X");
            }
            if (button.getText() == "") {
                if (turnOutput.getText().equals("X")) {
                    button.setText("X");
                    //isX = false;
                    turnOutput.setText("0");
                    i++;
                } else {
                    button.setText("0");
                    //isX = true;
                    turnOutput.setText("X");
                    i++;
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
                //isX = true;
                i = 0;
            }
            System.out.println("Pressed button: " + button.getId());
            // Win Controller
            if ((upLeft.getText().equals(up.getText()) && upLeft.getText().equals(upRight.getText()) && !upLeft.getText().equals("")) // up floor
                    || (upLeft.getText().equals(left.getText()) && upLeft.getText().equals(bottomLeft.getText()) && !upLeft.getText().equals("")) // left colomn
                    || (upLeft.getText().equals(center.getText()) && upLeft.getText().equals(bottomRight.getText()) && !upLeft.getText().equals("")) // upLeft to bottomRight diagonal
                    || (up.getText().equals(center.getText()) && up.getText().equals(bottom.getText()) && !up.getText().equals("")) // center colomn
                    || (upRight.getText().equals(center.getText()) && upRight.getText().equals(bottomLeft.getText()) && !upRight.getText().equals("")) // upRight to bottomLeft diagonal
                    || (upRight.getText().equals(right.getText()) && upRight.getText().equals(bottomRight.getText()) && !upRight.getText().equals("")) // right colomn
                    || (left.getText().equals(center.getText()) && left.getText().equals(right.getText()) && !left.getText().equals("")) // center floor
                    || (bottomLeft.getText().equals(bottom.getText()) && bottomLeft.getText().equals(bottomRight.getText())) && !bottomLeft.getText().equals("")) {  // bottom floor
                if (turnOutput.getText().equals("X")) {
                    display.setText("0 WINS, restart the game");

                } else if(turnOutput.getText().equals("0")) {
                    display.setText("X WINS, restart the game");
                }
            } else if(!upLeft.getText().equals("") && !up.getText().equals("") && !upRight.getText().equals("")
                    && !left.getText().equals("") && !center.getText().equals("") && !right.getText().equals("")
                    && !bottomLeft.getText().equals("") && !bottom.getText().equals("") && !bottomRight.getText().equals("")){
                display.setText("Round Draw, restart the game");
            }
        }


    }
}