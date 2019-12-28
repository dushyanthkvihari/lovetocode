package com.vihari.ds.graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * DFS of a graph
 * https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1
 */
public class DFS {
    class Node
    {
        String label;
        boolean visited = false;
        List<Node> neighbours= new ArrayList<Node>();
        public Node(String lab)
        {
            label = lab;
        }
        public void setNeighbour(Node neighbour)
        {
            neighbours.add(neighbour);
        }
    }
    public void dFSTraversal(Node node)
    {
        if(node.visited)
        {
            return;
        }
        if(node.neighbours.size()==0)
        {
            node.visited=true;
            System.out.print(node.label+" ");
            return;
        }
        node.visited=true;
        System.out.print(node.label+" ");
        for( Node i : node.neighbours)
        {
            dFSTraversal(i);
        }

    }

    public static void main(String vv[])
    {
        DFS dfs = new DFS();
        Node n1 = dfs.new Node("1");
        Node n2 = dfs.new Node("2");
        Node n3 = dfs.new Node("3");
        Node n4 = dfs.new Node("4");
        Node n5 = dfs.new Node("5");
        Node n6 = dfs.new Node("6");
        Node n7 = dfs.new Node("7");
//        Node n8 = dfs.new Node("8");
//        Node n9 = dfs.new Node("9");
//        Node n10 = dfs.new Node("10");
        n1.setNeighbour(n2);
        n1.setNeighbour(n3);
        n2.setNeighbour(n4);
        n2.setNeighbour(n5);
        n3.setNeighbour(n6);
        n3.setNeighbour(n7);
        n7.setNeighbour(n5);
        dfs.dFSTraversal(n1);
    }
}
