package com.example.zoznamopakovanie;

public class Uloha {
    protected String name;
    protected String priority;
    protected String state;

    public Uloha(String name, String priority, String state){
        this.name = name;
        this.priority = priority;
        this.state = state;
    }

    public void setName(String name){this.name = name;}
    public void setPriority(String priority){this.priority = priority;}
    public void setState(String state){this.state = state;}

    public String getName(){return name;}

    public String getPriority() {
        return priority;
    }

    public String getState() {
        return state;
    }

    public String toString(){
        return name + " " + priority + " " + state;
    }
}
