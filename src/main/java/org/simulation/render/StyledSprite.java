package org.simulation.render;

public record StyledSprite(String symbol, String textColor, String backgroundColor) {
    public String render(){
        return backgroundColor + textColor + symbol + SpriteColors.ANSI_RESET;
    }
}
