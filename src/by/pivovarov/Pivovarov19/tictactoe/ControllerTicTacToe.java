package by.pivovarov.Pivovarov19.tictactoe;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class ControllerTicTacToe {
    ModelTicTacToe model = new ModelTicTacToe();
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
            String buttonName = button.getId();


            System.out.println("Pressed button: " + button.getId());
            model.buttonPressed(buttonName);
        }
    }
}
