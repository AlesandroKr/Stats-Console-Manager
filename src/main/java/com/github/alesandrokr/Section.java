package com.github.alesandrokr;


public class Section {
    private String name;
    private int points;
    private int experiency;

    public Section() {

    }

    public Section(String name) {
        this.name = name;
        this.points = 0;
        this.experiency = 0;

    }

    public void addExp(int cantidad) {
        this.experiency += cantidad;
        while (experiency >= 100) {
            this.points += 1;
            this.experiency -= 100;
        }
    }

    public void addPoints(int cantidad) {
        this.points += cantidad;
    }

    public String getName() {
        return name;
    };

    public int getPoints() {
        return points;
    };

    public int getExperiency() {
        return experiency;
    };

    @Override
    public String toString() {
        return name + "     ———→     [Puntos: " + points + " | EXP: " + experiency + "/100 ";
    }
}
