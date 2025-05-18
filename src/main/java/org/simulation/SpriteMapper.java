package org.simulation;

import org.simulation.entities.*;

import java.util.Map;

public class SpriteMapper {

    private static final String ANSI_BACKGROUND_COLOR = "\u001B[42m";
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String DEAD_CREATURE = "\uD83E\uDDB4";

    private static final Map<Class<? extends Entity>, String> sprites = Map.of(
            Predator.class, "\uD83D\uDC3A",
            Herbivore.class, "\uD83E\uDECE",
            Rock.class, "\uD83E\uDEA8",
            Grass.class, "\uD83C\uDF31",
            Tree.class, "\uD83C\uDF32");

    public static String getSprite(Entity entity){
        String symbol = sprites.getOrDefault(entity.getClass(), "?");
        return withBackGround(symbol);
    }

    public static String getEmptySprite(){
        return withBackGround("   ");
    }

    private static String withBackGround(String sprite){
        return ANSI_BACKGROUND_COLOR + sprite + ANSI_RESET;
    }
}
