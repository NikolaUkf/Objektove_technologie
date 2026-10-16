package com.example.spaceobject;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Planeta extends SpaceObject {
    private final double radius;
    private final double orbitRadius;
    private final double centerX;
    private final double centerY;
    private double angle = 0;

    public Planeta(double centerX, double centerY, double radius, double orbitRadius) {
        super(centerX + orbitRadius, centerY);
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.orbitRadius = orbitRadius;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(Color.DODGERBLUE);
        gc.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);
        gc.setStroke(Color.DARKBLUE);
        gc.strokeOval(x - radius, y - radius, 2 * radius, 2 * radius);
        gc.setFill(Color.LIGHTGREEN);
        gc.fillOval(x - radius / 2, y - radius / 2, radius / 2, radius / 2);
    }

    @Override
    public void move(double canvasWidth, double canvasHeight) {
        angle += 0.03;
        x = centerX + orbitRadius * Math.cos(angle);
        y = centerY + orbitRadius * Math.sin(angle);
    }
}