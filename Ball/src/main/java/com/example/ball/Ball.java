package com.example.ball;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Ball extends Circle {
    private double rychlostX = 3;
    private double rychlostY = 2;
    private double sirkaPlochy;
    private double vyskaPlochy;
    private Timeline casovac;

    public Ball(double x, double y, double sirkaPlochy, double vyskaPlochy, double polomer){
        super(x,y, polomer);
        this.sirkaPlochy = sirkaPlochy;
        this.vyskaPlochy = vyskaPlochy;

        setFill(Color.GREEN);
        setStroke(Color.BLACK);

        casovac = new Timeline(new KeyFrame(Duration.millis(16), e -> spracuj()));
        casovac.setCycleCount(Animation.INDEFINITE);
        setOnMouseClicked(e->prepni());

    }
    public void spracuj(){
        double novyX = getCenterX() +rychlostX;
        double novyY = getCenterY() +rychlostY;

        if(novyX - getRadius()<=0 || novyX + getRadius() >= sirkaPlochy){
            rychlostX = -rychlostX;
        }
        if(novyY - getRadius()<=0 || novyY + getRadius() >= vyskaPlochy){
            rychlostY = -rychlostY;
        }
        setCenterX(getCenterX()+rychlostX);
        setCenterY(getCenterY()+rychlostY);

    }

    public void prepni(){
        if(casovac.getStatus()==Animation.Status.RUNNING){
            casovac.pause();
            setFill(Color.GRAY);
        }
        else{
            casovac.play();
            setFill(Color.GREEN);
        }
    }
    public void start(){
        casovac.play();
    }
    public void stop(){
        casovac.stop();
    }

    public void spomal(){
        rychlostX = zmen(rychlostX, -1,20);
        rychlostY = zmen(rychlostY, -1,20);
    }
    public void zrychli(){
        rychlostX = zmen(rychlostX, +1,20);
        rychlostY = zmen(rychlostY, +1,20);
    }
    private double zmen(double rychlost, double krok, double max){
        double nova = Math.abs(rychlost)+krok;
        nova = Math.max(1,Math.min(nova,max));
        return Math.signum(rychlost)*nova;
    }
}
