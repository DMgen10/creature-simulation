package org.simulation.render;

import org.simulation.core.Board;
import org.simulation.core.Position;
import org.simulation.entity.Entity;

public class Renderer {

    public void render(Board board){

    int width = board.getWidth();
    int height = board.getHeight();

        System.out.print("+");
        for (int i = 0; i < width; i++) {
            System.out.print("---");
        }
        System.out.println("+");


        for (int row = 0; row < height; row++){
            System.out.print("|");

            for (int column = 0; column < width; column++) {
                Position position = new Position(column, row);
                Entity entity = board.getEntity(position);

                if (entity != null) {
                    System.out.print(SpriteMapper.getSprite(entity));
                } else {
                    System.out.print(SpriteMapper.getEmptySprite());
                }
            }
            System.out.println("|");
        }

        System.out.print("+");
        for (int i = 0; i < width;i++){
            System.out.print("---");
        }
        System.out.println("+");

    }
}
