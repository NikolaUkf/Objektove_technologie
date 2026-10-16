package com.example.spaceobject;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Asteroid extends SpaceObject {
    private final double size;
    private double dx = 3;
    private double dy = 2;
    private Color color = Color.GRAY;

    public Asteroid(double x, double y, double size) {
        super(x, y);
        this.size = size;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(color);
        gc.fillOval(x, y, size, size * 0.8);
        gc.setStroke(Color.BLACK);
        gc.strokeOval(x, y, size, size * 0.8);
        gc.setFill(Color.rgb(0, 0, 0, 0.3));
        gc.fillOval(x + size * 0.2, y + size * 0.15, size * 0.2, size * 0.2);
    }

    @Override
    public void move(double canvasWidth, double canvasHeight) {
        x += dx;
        y += dy;
        if (x < 0) {
            x = 0;
            dx = Math.abs(dx);
        }
        if (x + size > canvasWidth) {
            x = canvasWidth - size;
            dx = -Math.abs(dx);
        }
        if (y < 0) {
            y = 0;
            dy = Math.abs(dy);
        }
        if (y + size * 0.8 > canvasHeight) {
            y = canvasHeight - size * 0.8;
            dy = -Math.abs(dy);
        }
    }

    public void setColor(Color color) {
        this.color = color;
    }
}