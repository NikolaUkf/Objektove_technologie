package com.example.spaceobject;

import javafx.scene.canvas.GraphicsContext;

public abstract class SpaceObject {
    protected double x;
    protected double y;

    public SpaceObject(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public abstract void draw(GraphicsContext gc);

    public abstract void move(double canvasWidth, double canvasHeight);

    public double getX() { return x; }
    public double getY() { return y; }
}