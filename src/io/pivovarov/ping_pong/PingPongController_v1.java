package io.pivovarov.ping_pong;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class PingPongController_v1 {
    DoubleProperty currentYBluePlayer = new SimpleDoubleProperty();
    DoubleProperty currentYGreenPlayer = new SimpleDoubleProperty();

    @FXML
    Rectangle bluePlayer; //leftPlayer
    @FXML
    Rectangle greenPlayer; //rightPlayer
    @FXML
    Circle ball;

    public void keyPressedHandler(KeyEvent handlerEvent) {
        KeyCode keyCode = handlerEvent.getCode();
        System.out.println("Key Pressed: " + keyCode);
        switch (keyCode) {
            case W:
            case S:
                bluePlayerMovement(keyCode);
                break;
            case UP:
            case DOWN:
                greenPlayerMovement(keyCode);
                break;
        }
    }

    public void bluePlayerMovement(KeyCode keyCode) {
            if (keyCode.toString().equals("W") && currentYBluePlayer.getValue() > 0) {
                currentYBluePlayer.set(currentYBluePlayer.getValue() - 2);
            } else if (currentYBluePlayer.getValue() < 248) {
                currentYBluePlayer.set(currentYBluePlayer.getValue() + 2);
            }
    }

    public void greenPlayerMovement (KeyCode keyCode) {
        if(keyCode.toString().equals("UP") && currentYGreenPlayer.getValue() > 0) {
            currentYGreenPlayer.set(currentYGreenPlayer.getValue() - 2);
        } else if (currentYGreenPlayer.getValue() < 248) {
            currentYGreenPlayer.set(currentYGreenPlayer.getValue() + 2);
        }
    }

    public void initialize() {
        currentYBluePlayer.set(bluePlayer.getLayoutY());
        bluePlayer.layoutYProperty().bind(currentYBluePlayer);
        currentYGreenPlayer.set(greenPlayer.getLayoutY());
        greenPlayer.layoutYProperty().bind(currentYGreenPlayer);
    }
}