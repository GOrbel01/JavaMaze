package com.geo.maze;

public interface MazeTask {
    /**
     * Calls the navigateMaze function to
     * compute a successful path for the maze
     * and indicates to the user if a path was found or not
     */
    void computePath();

    /**
     * Print out the maze in the form required.
     */
    void renderMaze();
}
