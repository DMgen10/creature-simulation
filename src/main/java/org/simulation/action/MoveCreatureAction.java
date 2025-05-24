package org.simulation.action;

import org.simulation.core.Board;
import org.simulation.core.SimulationConfig;
import org.simulation.entity.Creature;
import org.simulation.entity.Entity;

public class MoveCreatureAction implements Action{

    private final Board board;
    private final SimulationConfig simulationConfig;

    public MoveCreatureAction(Board board, SimulationConfig simulationConfig) {
        this.board = board;
        this.simulationConfig = simulationConfig;
    }

    @Override
    public void execute(Board board) {
        for (Entity entity : board.getAllEntities()){
            if (entity instanceof Creature creature && creature.isAlive()){
                creature.makeMove(board, simulationConfig);
            }
        }
    }
}
