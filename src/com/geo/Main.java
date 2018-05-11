package com.geo;

import com.geo.file.MazeReaderImpl;
import com.geo.maze.Maze;
import com.geo.maze.MazeTask;
import com.geo.maze.MazeTaskImpl;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        MazeReaderImpl fileReader = new MazeReaderImpl();
        Maze maze = null;
        try {
            maze = fileReader.readMazeFile(args[0]);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        if (maze != null) {
            MazeTask mt = new MazeTaskImpl(maze);
            mt.computePath();
            mt.renderMaze();
        }

        long stopTime = System.currentTimeMillis();
        long timeTaken = stopTime - startTime;
        System.out.println("Total Execution time of: " + (timeTaken / 1000.0) + "s");
    }
}
