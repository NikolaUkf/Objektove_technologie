package com.example.spaceobject;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HelloController {
    private static final double TOP_MARGIN = 50;

    @FXML
    private Pane root;

    private Canvas canvas;
    private final List<SpaceObject> objects = new ArrayList<>();
    private final Random random = new Random();

    @FXML
    public void initialize() {
        canvas = new Canvas(root.getPrefWidth(), root.getPrefHeight());
        root.getChildren().add(0, canvas);

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                for (SpaceObject o : objects) {
                    o.move(canvas.getWidth(), canvas.getHeight());
                }
                redraw();
            }
        };
        timer.start();
    }

    private void redraw() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        for (SpaceObject o : objects) {
            o.draw(gc);
        }
    }

    private double rnd(double min, double max) {
        return min + random.nextDouble() * (max - min);
    }

    @FXML
    private void pridajPlanetu() {
        double radius = 15;
        double orbit = 40;
        double margin = radius + orbit;
        double cx = rnd(margin, canvas.getWidth() - margin);
        double cy = rnd(TOP_MARGIN + margin, canvas.getHeight() - margin);
        objects.add(new Planeta(cx, cy, radius, orbit));
    }

    @FXML
    private void pridajAsteroid() {
        double size = 30;
        double x = rnd(0, canvas.getWidth() - size);
        double y = rnd(TOP_MARGIN, canvas.getHeight() - size);
        objects.add(new Asteroid(x, y, size));
    }

    @FXML
    private void pridajSatelit() {
        double x = rnd(0, canvas.getWidth() - Satelit.getTotalWidth());
        double y = rnd(TOP_MARGIN, canvas.getHeight() - 16);
        objects.add(new Satelit(x, y));
    }

    @FXML
    private void zafarbiAsteroidy() {
        for (SpaceObject o : objects) {
            if (o instanceof Asteroid asteroid) {
                asteroid.setColor(Color.RED);
            }
        }
    }

    @FXML
    private void posunSatelity() {
        for (SpaceObject o : objects) {
            if (o instanceof Satelit satellite) {
                satellite.moveRight(20, canvas.getWidth());
            }
        }
    }
}