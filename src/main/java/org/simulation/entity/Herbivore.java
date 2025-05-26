package org.simulation.entities;

public class Herbivore extends Creature {

    public Herbivore(int speed, int health) {
        super(speed, health);
    }

    @Override
    public void makeMove() {

        // стремится найти съедобный ресурс
        // может потратить ход на движение в сторону травы, либо на её поглощение

    private void moveRandomly(Board board) {
        List<Position> freeNeighbors = getFreePositions(board)
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
    }
}
