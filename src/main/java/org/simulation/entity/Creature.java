package org.simulation.entity;

import org.simulation.core.Board;
import org.simulation.core.SimulationConfig;

abstract public class Creature extends Entity {

    protected int speed;
    protected int health;

    public Creature(int speed, int health) {
        this.speed = speed;
        this.health = health;
    }

    abstract public void makeMove(Board board, SimulationConfig simulationConfig);

    public void changeHealth(int amount){
        this.health += amount;
    }

    public boolean isAlive(){
        return health >= 0;
    }
    public int getHealth() {
        return health;
    }

    public int getSpeed() {
        return speed;
    }
}
