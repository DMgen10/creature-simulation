package org.simulation;

import org.simulation.entities.Entity;

public class Renderer {

    public void render(Board board){
        int width = board.getWidth();
        int height = board.getHeight();

        int paddedWidth = width + 2;
        int paddedHeight = height + 2;

        System.out.print("┌");
        for (int i = 0; i < paddedWidth; i++) {
            System.out.print("-");
        }
        System.out.println("┐");

        for (int row = -1; row <= height; row++) {
            System.out.print("|");

            for (int column = -1; column <= width ; column++) {
                if (row == -1 || row == height || column == -1 || column == width){
                    System.out.print(" ");
                } else {
                    Position position = new Position(column, row);
                    Entity entity = board.getEntity(position);

                    if (entity != null){
                        System.out.print(SpriteMapper.getSprite(entity));
                    } else {
                        System.out.print(SpriteMapper.getEmptySprite());
                    }
                }
            }
            System.out.println("|");
        }
        System.out.print("└");
        for (int i = 0; i < paddedWidth;i++){
            System.out.print("-");
        }
        System.out.println("┘");


//
//        for (int column = 0; column < board.getHeight(); column++) {
//            for (int row = 0; row < board.getWidth(); row++) {
//                Position position = new Position(column, row);
//                Entity entity = board.getEntity(position);
//
//                if (entity != null){
//                    System.out.print(SpriteMapper.getSprite(entity));
//                } else {
//                    System.out.print(SpriteMapper.getEmptySprite());
//                }
//
//            }
//            System.out.println();



    }
}
