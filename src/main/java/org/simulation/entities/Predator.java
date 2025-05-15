package org.simulation.entities;

public class Predator extends Creature {

    private int attackPower;

    public Predator(int speed, int health, int attackPower) {
        super(speed, health);
        this.attackPower = attackPower;
    }

    @Override
    public void makeMove() {
        // переместиться к жертве - травоядному
        // атаковать травоядное - HP травоядного уменьшается на attackPower, если HP = 0 -> травоядное умирает
    }

}
