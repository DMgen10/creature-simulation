package org.simulation.render;

import org.simulation.entity.*;

import java.util.Map;

public class SpriteMapper {

    private static final StyledSprite EMPTY = new StyledSprite("   ", SpriteColors.WHITE, SpriteColors.ANSI_BACKGROUND_GREEN_COLOR);

    private static final Map<Class<? extends Entity>, StyledSprite> sprites = Map.of(
            Predator.class, new StyledSprite(" P ",SpriteColors.RED, SpriteColors.WHITE),
            Herbivore.class, new StyledSprite(" H ", SpriteColors.GREEN, SpriteColors.WHITE),
            Rock.class, new StyledSprite(" R ", SpriteColors.GRAY, SpriteColors.WHITE),
            Grass.class, new StyledSprite( " G ", SpriteColors.LIGHT_GREEN, SpriteColors.WHITE),
            Tree.class, new StyledSprite( " T ", SpriteColors.YELLOW, SpriteColors.WHITE));

    public static String getSprite(Entity entity){
        return sprites.getOrDefault(entity.getClass(), EMPTY).render();
    }

    public static String getEmptySprite(){
        return EMPTY.render();
    }
}
