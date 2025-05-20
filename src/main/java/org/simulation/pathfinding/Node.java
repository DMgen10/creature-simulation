package org.simulation.pathfinding;

import org.simulation.core.Position;

import java.util.Objects;

public class Node {

    public final Position position;
    public final int gCost;
    public final int hCost;
    public final Node parent;

    public Node(Position position, int gCost, int hCost, Node parent) {
        this.position = position;
        this.gCost = gCost;
        this.hCost = hCost;
        this.parent = parent;
    }

    public int getFCost(){
        return gCost + hCost;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Node node)) return false;
        return gCost == node.gCost && hCost == node.hCost && Objects.equals(position, node.position) && Objects.equals(parent, node.parent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, gCost, hCost, parent);
    }
}
