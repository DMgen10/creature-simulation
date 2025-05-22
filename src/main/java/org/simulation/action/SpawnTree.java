package org.simulation.action;

import org.simulation.core.Board;
import org.simulation.core.Position;
import org.simulation.core.SimulationConfig;
import org.simulation.entity.Tree;

public class SpawnTree implements InitAction {

    private final Board board;
    private final SimulationConfig config;

    public SpawnTree(Board board, SimulationConfig config) {
        this.board = board;
        this.config = config;
    }

    @Override
    public void execute() {
        Position position = board.getRandomFreePosition();
        if (position != null){
            board.add(position, new Tree());
        }
    }
}
