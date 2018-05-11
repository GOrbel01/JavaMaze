package com.geo.maze;

public class Maze {
    private final MazeInfo mazeInfo;
    private final Node[][] mazePath;

    public Maze(MazeInfo mazeInfo, Node[][] mazePath) {
        this.mazeInfo = mazeInfo;
        this.mazePath = mazePath;
    }

    public MazeInfo getMazeInfo() {
        return mazeInfo;
    }

    public Node[][] getMazePath() {
        return mazePath;
    }

    //Test Method: Maze Print
    public void printInput() {
        for (int i = 0; i < mazePath.length; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < mazePath[i].length; j++) {
                builder.append(mazePath[i][j].getValue());
            }
            System.out.println(builder.toString());
        }
    }

    /**
     * Retrieve the node north of @param
     * @param node Current node
     * @return The node north of @param Node
     */
    private Node getNorth(Node node) {
        if ((node.getYCoord() - 1) < 0) {
            return null;
        }
        return mazePath[node.getYCoord() - 1][node.getXCoord()];
    }

    /**
     * Retrieve the node south of @param
     * @param node Current node
     * @return The node south of @param Node
     */
    private Node getSouth(Node node) {
        if ((node.getYCoord() + 1) > mazeInfo.getHeight()) {
            return null;
        }
        return mazePath[node.getYCoord() + 1][node.getXCoord()];
    }

    /**
     * Retrieve the node east of @param
     * @param node Current node
     * @return The node east of @param Node
     */
    private Node getEast(Node node) {
        if ((node.getXCoord() + 1) > (mazeInfo.getWidth())) {
            return null;
        }
        return mazePath[node.getYCoord()][node.getXCoord() + 1];
    }

    /**
     * Retrieve the node west of @param
     * @param node Current node
     * @return The node west of @param Node
     */
    private Node getWest(Node node) {
        if ((node.getXCoord() - 1) < 0) {
            return null;
        }
        return mazePath[node.getYCoord()][node.getXCoord() - 1];
    }

    /**
     * Retrieves the Node at the end of the Maze
     * @return Node at the end of the maze
     */
    protected Node getMazeEnd() {
        return mazePath[mazeInfo.getEndY()][mazeInfo.getEndX()];
    }

    /**
     * Retrieves the Node at the start of the Maze
     * @return Node at the start of the maze
     */
    protected Node getMazeStart() {
        return mazePath[mazeInfo.getStartY()][mazeInfo.getStartX()];
    }

    /**
     * Calculates an available move from @param Node
     * with N>S>W>E Priority
     * @param cur Current node
     * @return The node for an available direction
     * Null Return = No Node available, start popping stack. (Would not use null ideally)
     */
    protected Node getAvailableNode(Node cur) {
        Node result;
        if (isAvailNode(getNorth(cur))) {
            result = getNorth(cur);
        }
        else if (isAvailNode(getSouth(cur))) {
            result = getSouth(cur);
        }
        else if (isAvailNode(getWest(cur))) {
            result = getWest(cur);
        }
        else if (isAvailNode(getEast(cur))) {
            result = getEast(cur);
        }
        else {
            result = null;
        }
        return result;
    }

    /**
     * Indicates if a node is available
     * @param node Node being checked
     * @return true if available otherwise false
     */
    private boolean isAvailNode(Node node) {
        return node.getValue().equals("0");
    }
}
