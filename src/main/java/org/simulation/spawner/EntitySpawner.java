package org.simulation.spawner;

import org.simulation.core.Board;
import org.simulation.core.Position;
import org.simulation.core.SimulationConfig;
import org.simulation.entity.*;

import java.util.Random;
import java.util.function.Supplier;

public class EntitySpawner {

    private final Board board;
    private final SimulationConfig config;
    private final Random random = new Random();

    public EntitySpawner(Board board, SimulationConfig config) {
        this.board = board;
        this.config = config;
    }

    public void spawn(){
        int predators = percentageRatioWithBoard(10);
        int herbivores = percentageRatioWithBoard(10);
        int grass = percentageRatioWithBoard(10);
        int rocks = percentageRatioWithBoard(5);
        int trees = percentageRatioWithBoard(5);

        spawnEntities(()-> new Predator(config.getPredatorSpeed(),config.getPredatorHealth(), config.getPredatorAttack()) , predators);
        spawnEntities(()-> new Herbivore(config.getHerbivoreSpeed(),config.getHerbivoreHealth()) ,herbivores);
        spawnEntities(()-> new Grass(config.getGrassNutrition()), grass);
        spawnEntities(()-> new Tree(), trees);
        spawnEntities(()-> new Rock(), rocks);
     }

    private int percentageRatioWithBoard(int percent){
        int total = board.getWidth() * board.getHeight();
        return total * percent / 100;
    }

    private void spawnEntities(Supplier<Entity> supplier, int count){
        int attempts = 0;
        int maxAttempts = count * 10;

        while (count > 0 && attempts < maxAttempts){
            Position position = board.getRandomFreePosition();

            if (position != null){
                board.add(position, supplier.get());
                count--;
            }
            attempts++;
        }
    }
}
