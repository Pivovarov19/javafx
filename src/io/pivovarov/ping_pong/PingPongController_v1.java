package io.pivovarov.ping_pong;

import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class PingPongController_v1 {
    @FXML
    Rectangle bluePlayer; //computer
    @FXML
    Rectangle greenPlayer; //player
    @FXML
    Circle ball;

    public void keyPressedHandler(KeyEvent keyEvent) {
        KeyCode keyCode = keyEvent.getCode();
        System.out.println("Key Pressed: " + keyCode);
    }
}
