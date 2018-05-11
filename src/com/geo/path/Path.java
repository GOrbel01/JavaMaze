package com.geo.path;

import com.geo.maze.Node;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Stack (Deque) Wrapper
 * Holds Node objects that
 * eventually make up the successful path
 */
public class Path {
    private Deque<Node> nodes;

    public Path(Node start) {
        this.nodes = new ArrayDeque<>();
        nodes.addFirst(start);
    }

    public Node peek() {
        System.out.println(nodes.peek());
        return nodes.peek();
    }

    public void push(Node node) {
        nodes.push(node);
    }

    public int size() {
        return nodes.size();
    }

    public Node pop() {
        return nodes.pop();
    }
}
