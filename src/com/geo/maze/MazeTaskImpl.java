package com.geo.maze;

import com.geo.path.Path;

public class MazeTaskImpl implements MazeTask {

    private Maze maze;
    private Path path;

    public MazeTaskImpl(Maze maze) {
        this.maze = maze;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void computePath() {
        Node start = maze.getMazeStart();
        start.setValue("S");
        System.out.println("END: " + maze.getMazeEnd());
        path = new Path(start);
        boolean solved = navigateMaze(start);
        if (!solved) {
            System.out.println("This Maze cannot be Completed!");
        } else {
            System.out.println("The Maze was Completed Successfully.");
        }
    }

    /**
     * Function that navigates the maze
     * and sets a path to the end node
     * @param start The Start node (as defined in txt file)
     * @return True if the maze can be solved, otherwise false
     */
    private boolean navigateMaze(Node start) {
        boolean foundEnd = false;
        Node cur = maze.getAvailableNode(start);
        while (!foundEnd) {
            if (cur != null) {
                if (!cur.equals(maze.getMazeEnd())) { //Handle any new node
                    cur.setValue("X");
                    path.push(cur);
                    cur = maze.getAvailableNode(cur);
                } else { //Handle end node found
                    cur.setValue("E");
                    foundEnd = true;
                }
            } else {
                if (path.size() <= 1) { //Handle back at Start Node
                    if (maze.getAvailableNode(path.peek()) == null) { //If No Options available at all
                                                                      //after popping the full stack
                        return false;                                 //then the Maze must be impossible
                    }
                    else { //Handle available route from Start Node
                        cur = maze.getAvailableNode(path.peek());
                    }
                } else { //Handle steps to be retraced (back down the stack)
                    Node fromStack = path.pop();
                    if (maze.getAvailableNode(fromStack) != null) {
                        cur = fromStack;
                    } else {
                        fromStack.setValue(" ");
                        cur = maze.getAvailableNode(fromStack);
                    }
                }
            }
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void renderMaze() {
        for (int i = 0; i < maze.getMazePath().length; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < maze.getMazePath()[i].length; j++) {
                if (i == maze.getMazeInfo().getStartY() && j == maze.getMazeInfo().getStartX()) {
                    builder.append("S");
                }
                else if (i == maze.getMazeInfo().getEndY() && j == maze.getMazeInfo().getEndX()) {
                    builder.append("E");
                }
                else if (maze.getMazePath()[i][j].getValue().equals("1")) {
                    builder.append("#");
                }
                else if (maze.getMazePath()[i][j].getValue().equals("0")) {
                    builder.append(" ");
                }
                else if (maze.getMazePath()[i][j].getValue().equals(" ")) {
                    builder.append(" ");
                }
                else if (maze.getMazePath()[i][j].getValue().equals("X")) {
                    builder.append("X");
                }
            }
            System.out.println(builder.toString());
        }
    }

}
