package org.simulation.action;

import org.simulation.core.Board;
import org.simulation.core.Position;
import org.simulation.core.SimulationConfig;
import org.simulation.entity.Herbivore;

public class SpawnHerbivores implements InitAction {

    private final Board board;
    private final SimulationConfig config;

    public SpawnHerbivores(Board board, SimulationConfig config) {
        this.board = board;
        this.config = config;
    }

    @Override
    public void execute() {
            Position position = board.getRandomFreePosition();
            if (position != null){
                board.add(position, new Herbivore(config.getHerbivoreSpeed(),
                                                  config.getHerbivoreHealth()));
            }
        }
}
