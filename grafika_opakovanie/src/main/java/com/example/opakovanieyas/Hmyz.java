package com.example.opakovanieyas;

import javafx.scene.layout.Pane;

public abstract  class Hmyz extends Pane {
    protected double x;
    protected double y;
    protected double rychlostX;
    protected double rychlostY;

    public Hmyz(double x, double y, double rychlostX, double rychlostY){
        this.x = x;
        this.y = y;
        this.rychlostX = rychlostX;
        this.rychlostY = rychlostY;
        aktualizuj();
    }
    public void aktualizuj(){
        setLayoutX(x);
        setLayoutY(y);
    }
    public abstract void pohyb(double sirka, double vyska);
    public void posun(double dx, double dy){
        x+= dx;
        y+=dy;
    }
}
