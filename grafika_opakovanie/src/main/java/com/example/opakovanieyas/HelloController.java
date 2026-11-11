package com.example.opakovanieyas;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class HelloController {
    @FXML private Pane root;

    @FXML
    private void initialize() {
        // 1. časovač: každých 16 ms pohne všetkým hmyzom
        Timeline t = new Timeline(
                new KeyFrame(Duration.millis(16), event -> {
                    for (Node n : root.getChildren()) {
                        if (n instanceof Hmyz) {
                            ((Hmyz) n).pohyb(root.getWidth(), root.getHeight());
                        }
                    }
                })
        );
        t.setCycleCount(Timeline.INDEFINITE);
        t.play();

        Platform.runLater(()->root.getScene().setOnKeyPressed(this::spracuj));

        // 3 bublina
        root.setOnMouseClicked(e -> {
            if (e.getTarget() == root) {
                root.getChildren().add(new Bublina(e.getX(), e.getY()));
            }
        });
    }

    private void spracuj(KeyEvent e) {
        KeyCode k = e.getCode();
        if (k == KeyCode.S) {
            for (Node n : root.getChildren()) {
                if (n instanceof Mucha) ((Mucha) n).zastav(true);
            }
        } else if (k == KeyCode.W) {
            for (Node n : root.getChildren()) {
                if (n instanceof Hmyz) ((Hmyz) n).posun(0, -50);
            }
        }
    }

    @FXML
    private void mucha() {
        Mucha m = new Mucha(
                Math.random() * (root.getWidth() - 12),
                Math.random() * (root.getHeight() - 12)
        );
       // m.setOnMouseClicked(e->root.getChildren().remove(m));
        m.setOnMouseClicked(e -> root.getChildren().remove(m));   // klik = zanikne
        root.getChildren().add(m);
    }

    @FXML
    private void chrobak() {
        root.getChildren().add(new Chrobak(0, root.getHeight() - 20));
    }

    @FXML
    private void ryba() {
        root.getChildren().add(new Ryba(0, Math.random() * (root.getHeight() - 20)));
    }
}