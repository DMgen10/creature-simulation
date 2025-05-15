package org.simulation;

import org.simulation.entities.Entity;

import java.util.HashMap;

public class Map {

    final int size;
    final int length;
    final int width;

    private java.util.Map<Position, Entity> entities;

    public Map(int length, int width) {
        this.length = length;
        this.width = width;
        size = length * width;
        entities = new HashMap<>();
    }



}
