package com.example.opakovanieyas;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class Mucha extends Hmyz{
    private static final double radius = 12;
    protected boolean stoji = false;

    public Mucha(double x, double y){
        super(x,y,2,2);
        getChildren().add(new Circle(6,6,12,Color.YELLOW));
        aktualizuj();
    }

    @Override public void pohyb(double sirka, double vyska){
        if (stoji) return;
        x += (Math.random()*2-1)*rychlostX;
        y += (Math.random()*2-1)*rychlostY;

        x = Math.max(0,Math.min(x,sirka-12));
        y = Math.max(0,Math.min(y,vyska-12));



        aktualizuj();

    }

    public void zastav(boolean z){ stoji = z;}


}
