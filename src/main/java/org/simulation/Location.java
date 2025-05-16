package org.simulation;

import org.simulation.entities.Entity;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Location {

    final int length;
    final int width;
    private final Map<Position, Entity> entities;

    public Location(int width, int length) {
        if (width <= 0 || length <= 0){
            throw new IllegalArgumentException("Width and height must be greater than 0");
        }

        this.length = length;
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
               position.getRow() < length &&
               position.getColumn() >= 0 &&
               position.getColumn() < width;
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

    public final int getLength() {
        return length;
    }

    public final int getWidth() {
        return width;
    }

    public Map<Position, Entity> getEntities() {
        return Collections.unmodifiableMap(entities);
    }
}
