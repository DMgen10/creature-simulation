package org.simulation.entity;

import org.simulation.core.Board;
import org.simulation.core.Position;
import org.simulation.core.SimulationConfig;
import org.simulation.pathfinding.AStar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Predator extends Creature {

    private int attackPower;

    public Predator(int speed, int health, int attackPower) {
        super(speed, health);
        this.attackPower = attackPower;
    }

    @Override
    public void makeMove(Board board, SimulationConfig simulationConfig) {

        // стремится найти съедобный ресурс
        // может потратить ход на движение в сторону травы, либо на её поглощение
        AStar aStar = new AStar(board);

        List<Position> preyPositions = new ArrayList<>();

        for(Position position : board.getEntities().keySet()){
            Entity entity = board.getEntity(position);
            if (entity instanceof Herbivore){
                preyPositions.add(position);
            }
        }

        if (preyPositions.isEmpty()){
            moveRandomly(board);
            return;
        }

        Position closestPrey = null;
        List<Position> shortestPath = null;

        for (Position preyPos : preyPositions) {
            List<Position> path = aStar.find(this.getPosition(), preyPos);
            if (path != null && !path.isEmpty()){
                if (shortestPath == null || path.size() < shortestPath.size()){
                    shortestPath = path;
                    closestPrey = preyPos;
                }
            }
        }

        if (shortestPath == null || shortestPath.size() < 2){
            moveRandomly(board);
            return;
        }

        int maxSteps = Math.min(this.getSpeed(), shortestPath.size() - 1);
        Position current = this.getPosition();

        for (int step = 1; step <= maxSteps ; step++) {
            Position next = shortestPath.get(step);
            Entity entity = board.getEntity(next);

            if (entity != null && !(entity instanceof Herbivore)){
                break;
            }
            if (entity instanceof Herbivore){
                Creature prey = (Creature) entity;
                prey.changeHealth(-simulationConfig.getPredatorAttack());
                if (!prey.isAlive()){
                    board.remove(next);
                }
                break;
            }

            board.moveEntity(current, next);
            current = next;
        }
    }

    private void moveRandomly(Board board) {
        List<Position> freeNeighbors = getFreePositions(board);
        if (!freeNeighbors.isEmpty()){
            Random random = new Random();
            Position target = freeNeighbors.get(random.nextInt(freeNeighbors.size()));
            board.moveEntity(this.getPosition(), target);
        }
    }

    private List<Position> getFreePositions(Board board) {
        List<Position> neighbors = new ArrayList<>();
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        Position current = this.getPosition();
        for (int count = 0; count < directions.length; count++) {
            int newRow = current.getRow() + directions[count][0];
            int newCol = current.getCol() + directions[count][1];
            Position neighbor = new Position(newCol, newRow);
            if (board.isWithinBounds(neighbor) && board.isPositionEmpty(neighbor)){
                neighbors.add(neighbor);
            }
        }
        return neighbors;
    }    public int getAttackPower() {
        return attackPower;
    }
}
