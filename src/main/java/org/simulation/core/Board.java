package org.simulation;

import org.simulation.entities.Entity;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Board {

    final int height;
    final int width;
    private final Map<Position, Entity> entities;

    public Board(int width, int length) {
        if (width <= 0 || length <= 0){
            throw new IllegalArgumentException("Width and height must be greater than 0");
        }

        this.height = length;
        this.width = width;
        entities = new HashMap<>(width * length);
    }

    public void remove(Position position){
        validatePosition(position);

        entities.remove(position);
    }

    public void add(Position position, Entity entity){
        validatePosition(position);
        validateEntity(entity);

        entities.put(position, entity);
    }

    public Entity getEntity(Position position){
        validatePosition(position);

        return this.entities.get(position);
    }

    public boolean isPositionEmpty(Position position){
        validatePosition(position);
        return !entities.containsKey(position);
    }

    public boolean isWithinBounds(Position position){
        if (position == null){
            throw new IllegalArgumentException("Position cannot be null");
        }

        return position.getRow() >= 0 &&
               position.getRow() < height &&
               position.getCol() >= 0 &&
               position.getCol() < width;
    }

    public void move(Position from, Position to){
        
    }

    public Position getRandomFreePosition(){
        int maxAttempts = getHeight() * getWidth();

        for (int count = 0; count < maxAttempts; count++) {
            int row = random.nextInt(getHeight());
            int col = random.nextInt(getWidth());

            Position position = new Position(col, row);
            if (isPositionEmpty(position)){
                return position;
            }
        }
        return null;
    }

    private void validateEntity(Entity entity){
        if (entity == null){
            throw new IllegalArgumentException("Entity cannot be null");
        }
    }

    private void validatePosition(Position position){
        if (position == null){
            throw new IllegalArgumentException("Position cannot be null");
        }
        if (!isWithinBounds(position)){
            throw new IllegalArgumentException("Position is not within bounds");
        }

    }

    public final int getHeight() {
        return height;
    }

    public final int getWidth() {
        return width;
    }

    public Map<Position, Entity> getEntities() {
        return Collections.unmodifiableMap(entities);
    }
}
