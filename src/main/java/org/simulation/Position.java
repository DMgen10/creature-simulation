package org.simulation;

import java.util.Objects;

public class Position {

    final public int col;
    final public int row;

    public Position(int column, int row) {
        this.col = column;
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Position position)) return false;
        return col == position.col && row == position.row;
    }

    @Override
    public int hashCode() {
        return Objects.hash(col, row);
    }
}
