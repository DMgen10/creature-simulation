package org.simulation.entities;

public class Herbivore extends Creature {

    public Herbivore(int speed, int health) {
        super(speed, health);
    }

    @Override
    public void makeMove() {

        // стремится найти съедобный ресурс
        // может потратить ход на движение в сторону травы, либо на её поглощение

    }
}
