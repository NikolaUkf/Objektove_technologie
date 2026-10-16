package com.example.spaceobject;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Satelit extends SpaceObject {
    private static final double BODY = 16;
    private static final double PANEL_W = 14;
    private static final double TOTAL_W = BODY + 2 * PANEL_W;
    private double dy = 2;

    public Satelit(double x, double y) {
        super(x, y);
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(Color.DEEPSKYBLUE);
        gc.fillRect(x, y + 3, PANEL_W, 10);
        gc.fillRect(x + PANEL_W + BODY, y + 3, PANEL_W, 10);
        gc.setFill(Color.SILVER);
        gc.fillRect(x + PANEL_W, y, BODY, BODY);
        gc.setStroke(Color.BLACK);
        gc.strokeRect(x, y + 3, PANEL_W, 10);
        gc.strokeRect(x + PANEL_W + BODY, y + 3, PANEL_W, 10);
        gc.strokeRect(x + PANEL_W, y, BODY, BODY);
    }

    @Override
    public void move(double canvasWidth, double canvasHeight) {
        y += dy;
        if (y < 0) {
            y = 0;
            dy = Math.abs(dy);
        }
        if (y + BODY > canvasHeight) {
            y = canvasHeight - BODY;
            dy = -Math.abs(dy);
        }
    }

    public void moveRight(double distance, double canvasWidth) {
        x = Math.min(x + distance, canvasWidth - TOTAL_W);
    }

    public static double getTotalWidth() {
        return TOTAL_W;
    }
}