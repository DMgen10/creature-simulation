package org.simulation.core;

public class SimulationConfig {

    private final int width;
    private final int height;

    private final int predatorHealth;
    private final int predatorSpeed;
    private final int predatorAttack;
    private final int herbivoreHealth;
    private final int herbivoreSpeed;
    private final int grassNutrition;

    public SimulationConfig(int width, int height, int predatorHealth, int predatorSpeed, int predatorAttack, int herbivoreHealth, int herbivoreSpeed, int grassNutrition) {
        this.width = width;
        this.height = height;
        this.predatorHealth = predatorHealth;
        this.predatorSpeed = predatorSpeed;
        this.predatorAttack = predatorAttack;
        this.herbivoreHealth = herbivoreHealth;
        this.herbivoreSpeed = herbivoreSpeed;
        this.grassNutrition = grassNutrition;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getPredatorHealth() {
        return predatorHealth;
    }

    public int getHerbivoreHealth() {
        return herbivoreHealth;
    }

    public int getPredatorAttack() {
        return predatorAttack;
    }

    public int getHerbivoreSpeed() {
        return herbivoreSpeed;
    }

    public int getPredatorSpeed() {
        return predatorSpeed;
    }

    public int getGrassNutrition() {
        return grassNutrition;
    }
}
