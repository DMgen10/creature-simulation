package org.simulation.entities;

public class Grass extends Subject{

    private int energy;

    public Grass(int energy) {
        super(true);
        this.energy = energy;
    }

    public int getEnergy() {
        return energy;
    }
}
