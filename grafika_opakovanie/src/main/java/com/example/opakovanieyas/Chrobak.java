package com.example.opakovanieyas;

import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Chrobak extends Hmyz {
    private static final double velkost = 20;
    public Chrobak(double x, double y){
        super(x,y,2,0);
        getChildren().add(new Rectangle(velkost,velkost,Color.GREEN));
    }

    @Override
    public void pohyb(double sirka, double vyska){
        x+=rychlostX;
        if (x>sirka || x<0){
            rychlostX = -rychlostX;
        }
        aktualizuj();

    }

}