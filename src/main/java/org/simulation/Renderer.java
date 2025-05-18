package org.simulation;

import org.simulation.entities.Entity;

public class Renderer {

    public void render(Board board){

        for (int column = 0; column < board.getLength(); column++) {
            for (int row = 0; row < board.getWidth(); row++) {
                Position position = new Position(column, row);
                Entity entity = board.getEntity(position);

                if (entity != null){
                    System.out.print(SpriteMapper.getSprite(entity));
                } else {
                    System.out.print(SpriteMapper.getEmptySprite());
                }

            }
            System.out.println();

        }


    }
}
