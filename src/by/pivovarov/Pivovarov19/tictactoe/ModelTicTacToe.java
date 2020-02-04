package by.pivovarov.Pivovarov19.tictactoe;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ModelTicTacToe {
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

    void buttonPressed (String buttonName) {
        if (buttonName.equals("up")) {
            up.setText("X");
        }
    }
}
