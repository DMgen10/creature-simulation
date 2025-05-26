package org.simulation.entities;

public class Herbivore extends Creature {

    public Herbivore(int speed, int health) {
        super(speed, health);
    }

    @Override
    public void makeMove() {

        // стремится найти съедобный ресурс
        // может потратить ход на движение в сторону травы, либо на её поглощение
        AStar aStar = new AStar(board);

        List<Position> grassPositions = new ArrayList<>();

        for(Position position : board.getEntities().keySet()){
            Entity entity = board.getEntity(position);
            if (entity instanceof Grass){
                grassPositions.add(position);
            }
        }

        if (grassPositions.isEmpty()){
            moveRandomly(board);
        }

        Position closesGrass = null;
        List<Position> shortestPath = null;

        for (int count = 0; count < grassPositions.size(); count++) {
            Position grassPos = grassPositions.get(count);
            List<Position> path = aStar.find(this.getPosition(), grassPos);
            if (path != null && !path.isEmpty()){
                if (shortestPath == null || path.size() < shortestPath.size()){
                    shortestPath = path;
                    closesGrass = grassPos;
                }
            }
        }

        if (shortestPath.size() == 2 && shortestPath.get(1).equals(closesGrass)){
            board.remove(closesGrass);
            this.changeHealth(simulationConfig.getGrassNutrition());
            return;
        }

        Position nextStep = shortestPath.get(1);
        board.moveEntity(this.getPosition(), nextStep);
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
    }
}
