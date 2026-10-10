package com.example.ball;
import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;


public class HelloController {
    @FXML private Pane root;

    @FXML public void initialize() {
        Ball lopta = new Ball(100, 150, 600, 400, 30);
        root.getChildren().add(lopta);
        lopta.start();

        root.sceneProperty().addListener((obs, stara, scena) -> {
            if (scena != null) {
                scena.setOnKeyPressed(e -> {
                    if (e.getCode() == KeyCode.F) lopta.zrychli();
                    if (e.getCode() == KeyCode.S) lopta.spomal();
                });
            }
        });
    }
}