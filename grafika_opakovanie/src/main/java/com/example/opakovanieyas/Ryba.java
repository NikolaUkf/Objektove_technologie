package com.example.opakovanieyas;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Ryba extends Hmyz {
    private static final double VELKOST = 20;
    private final Rectangle telo;                      // 1. tvar uložený v premennej

    public Ryba(double x, double y){
        super(x, y, 2, 0);
        telo = new Rectangle(VELKOST, VELKOST, Color.PINK);
        getChildren().add(telo);

        // 2. klik na rybu = náhodná farba
        setOnMouseClicked(e -> telo.setFill(Color.color(Math.random(), Math.random(), Math.random())));
    }

    @Override
    public void pohyb(double sirka, double vyska){
        x += rychlostX;
        if (x > sirka) {
            x = -VELKOST;
        }
        aktualizuj();
    }
}