package com.geo.file;

import com.geo.maze.Maze;

import java.io.IOException;

public interface MazeReader {
    /**
     * Read in a Maze file
     * @return
     * @throws IOException
     */
    Maze readMazeFile(String name) throws IOException;
}
