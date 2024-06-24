package com.br.types;

public class DimensionGrid {
    private Integer x;
    private Integer y;

    public DimensionGrid(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public DimensionGrid() {
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }
}
