package org.simulation.action;

import org.simulation.core.Board;
import org.simulation.core.Position;
import org.simulation.core.SimulationConfig;
import org.simulation.entity.Predator;

public class SpawnPredators implements InitAction {

    private final Board board;
    private final SimulationConfig config;

    public SpawnPredators(Board board, SimulationConfig config) {
        this.board = board;
        this.config = config;
    }

    @Override
    public void execute() {
            Position position = board.getRandomFreePosition();
            if (position != null){
                board.add(position, new Predator(config.getPredatorSpeed(),
                                                 config.getPredatorHealth(),
                                                 config.getPredatorAttack()));
        }
    }
}
