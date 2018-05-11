package com.geo.file;

import com.geo.maze.*;
import com.geo.path.Coordinate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MazeReaderImpl implements MazeReader {

    public MazeReaderImpl() {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Maze readMazeFile(String fileName) throws IOException {
        MazeInfo mazeInfo = new MazeInfo();
        Node[][] mazePath = new Node[0][0];

        File file = new File("res" + File.separator + fileName);

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String currentLine;

        int count = 0;
        int mazePathCount = 0;
        while ((currentLine = reader.readLine()) != null) {
            if (count < 3) { //For MazeInfo (End/Start/W&H etc)
                buildMazeInfo(count, currentLine, mazeInfo);
                if (count == 0) {
                    mazePath = new Node[mazeInfo.getHeight()][mazeInfo.getWidth()];
                }
            } else {
                    if (!currentLine.isEmpty()) {
                        String[] curLine = currentLine.split(" ");
                        Node[] results = new Node[curLine.length];
                        for (int i = 0; i < curLine.length; i++) {
                            results[i] = new Node(curLine[i], new Coordinate(mazePathCount, i));
                        }
                        mazePath[mazePathCount] = results;
                        mazePathCount++;
                    }
            }
            count++;
        }
        return new Maze(mazeInfo, mazePath);
    }

    /**
     * Take the line number, current line, and com.geo.maze info and set
     * the input information according to the line.
     * @param count Line number
     * @param line Line Content
     * @param mazeInfo The MazeInfo Object being populated
     */
    private void buildMazeInfo(int count, String line, MazeInfo mazeInfo) {
        //Assuming valid data as stated in requirements = no validation here
        int paramOne = Integer.parseInt(line.split(" ")[0]);
        int paramTwo = Integer.parseInt(line.split(" ")[1]);

        switch (count) {
            case 0:
                mazeInfo.setWidth(paramOne);
                mazeInfo.setHeight(paramTwo);
                break;
            case 1:
                mazeInfo.setStartX(paramOne);
                mazeInfo.setStartY(paramTwo);
                break;
            case 2:
                mazeInfo.setEndX(paramOne);
                mazeInfo.setEndY(paramTwo);
        }
    }
}
