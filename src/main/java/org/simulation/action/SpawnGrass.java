package org.simulation.action;

import org.simulation.core.Board;
import org.simulation.core.Position;
import org.simulation.core.SimulationConfig;
import org.simulation.entity.Grass;

public class SpawnGrass implements InitAction {

    private final Board board;
    private final SimulationConfig config;

    public SpawnGrass(Board board, SimulationConfig config) {
        this.board = board;
        this.config = config;
    }

    @Override
    public void execute() {
            Position position = board.getRandomFreePosition();
            if (position != null){
                board.add(position, new Grass(config.getGrassNutrition()));
            }
        }
}
