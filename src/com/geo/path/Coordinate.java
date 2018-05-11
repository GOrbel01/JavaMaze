package com.geo.path;

/*
    Wrapper for X/Y coordinate in
    the String matrix (2d Array)
 */
public class Coordinate {
    private int xCoord;
    private int yCoord;

    public Coordinate(int yCoord, int xCoord) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

    public int getxCoord() {
        return xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    @Override
    public String toString() {
        return "Y: " + yCoord + ", X: " + xCoord;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinate that = (Coordinate) o;

        if (xCoord != that.xCoord && yCoord != that.yCoord) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = xCoord;
        result = 31 * result + yCoord;
        return result;
    }
}
