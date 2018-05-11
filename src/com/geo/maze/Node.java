package com.geo.maze;

import com.geo.path.Coordinate;

/**
 * Node storing value and location on the grid
 * corresponding to each item of the maze.
 */
public class Node {
    private String value;
    private Coordinate coordinate;

    public Node(String value, Coordinate coordinate) {
        this.value = value;
        this.coordinate = coordinate;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getXCoord() {
        return coordinate.getxCoord();
    }

    public int getYCoord() {
        return coordinate.getyCoord();
    }

    @Override
    public String toString() {
        return "X: " + getXCoord() + " Y: " + getYCoord() + " Value: " + getValue();
    }
}
