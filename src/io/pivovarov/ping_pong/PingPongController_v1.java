package io.pivovarov.ping_pong;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;


public class PingPongController_v1 {
    DoubleProperty currentYBluePlayer = new SimpleDoubleProperty();
    DoubleProperty currentYGreenPlayer = new SimpleDoubleProperty();
    DoubleProperty ballCenterX = new SimpleDoubleProperty();
    Timeline timeline;

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
            case Q:
                System.exit(0);
                break;
            case R:
                currentYBluePlayer.set(126);
                currentYGreenPlayer.set(126);
                ballCenterX.set(250);
                timeline.stop();
        }
        ballMovement(1);
    }

    public void bluePlayerMovement(KeyCode keyCode) {
            if (keyCode.toString().equals("W") && currentYBluePlayer.getValue() > 0) {
                currentYBluePlayer.set(currentYBluePlayer.getValue() - 5);
            } else if (currentYBluePlayer.getValue() < 248) {
                currentYBluePlayer.set(currentYBluePlayer.getValue() + 5);
            }
    }

    public void greenPlayerMovement (KeyCode keyCode) {
        if(keyCode.toString().equals("UP") && currentYGreenPlayer.getValue() > 0) {
            currentYGreenPlayer.set(currentYGreenPlayer.getValue() - 5);
        } else if (currentYGreenPlayer.getValue() < 248) {
            currentYGreenPlayer.set(currentYGreenPlayer.getValue() + 5);
        }
    }

    public void initialize() {
        currentYBluePlayer.set(bluePlayer.getLayoutY());
        bluePlayer.layoutYProperty().bind(currentYBluePlayer);
        currentYGreenPlayer.set(greenPlayer.getLayoutY());
        greenPlayer.layoutYProperty().bind(currentYGreenPlayer);
        ballCenterX.set(ball.getLayoutX());
        ball.layoutXProperty().bind(ballCenterX);
    }

    public void ballMovement(int ballSpeedX) {
        KeyFrame keyFrame = new KeyFrame(new Duration(100), event -> { // Создаем объект "кадра", задаем период повторения и действия которые будут выполняться
            //TODO весь этот код представляет собой программирование поведения мяча => это ТОЛЬКО пример => Его нужно изменить что бы он соответствовал поведению мяча в вашей игре
            //System.out.println(ballCenterX); // выводим в терминал текущую позицию мяча
            if (ballCenterX.get() > 0) { // если мяч дошел до левой границы тогда
                ballCenterX.set(ballCenterX.get() - ballSpeedX); // меняем его позицию
            } else { //иначе
                timeline.stop(); // остонавливаем анимацию
            }
        });
        timeline = new Timeline(keyFrame); // создаем объект анимации куда помещаем наш кадр анимации
        timeline.setCycleCount(Timeline.INDEFINITE); // задаем цикл повторения
        timeline.play(); // запускаем анимацию
    }
}