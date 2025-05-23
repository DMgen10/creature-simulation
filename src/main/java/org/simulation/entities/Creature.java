package org.simulation.entities;

abstract public class Creature extends Entity {

    protected int speed;
    protected int health;

    public Creature(int speed, int health) {
        this.speed = speed;
        this.health = health;
    }

    abstract public void makeMove();

}
