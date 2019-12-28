package com.vihari.ds.graphs;

import java.util.ArrayList;
import java.util.List;

public class Node {
    String label;
    boolean visited = false;
    List<Node> neighbours= new ArrayList<>();
    public Node(String lab)
    {
        label = lab;
    }
    public void setNeighbour(Node neighbour)
    {
        neighbours.add(neighbour);
    }
}
