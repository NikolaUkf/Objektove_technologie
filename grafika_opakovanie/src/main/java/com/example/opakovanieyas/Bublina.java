package com.example.opakovanieyas;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Bublina extends Hmyz {
    private static final double RADIUS = 15;

    public Bublina(double x, double y){
        super(x - RADIUS, y - RADIUS, 0, 2);                               // stred bubliny = miesto kliku
        getChildren().add(new Circle(RADIUS, RADIUS, RADIUS, Color.PALETURQUOISE));
    }

    @Override
    public void pohyb(double sirka, double vyska){
        y += rychlostY;                                                    // padá dole
        if (y > vyska) {
            y = -2 * RADIUS;                                               // vyjde znova zhora
        }
        aktualizuj();
    }
}