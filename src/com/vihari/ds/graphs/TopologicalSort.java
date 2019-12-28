package com.vihari.ds.graphs;

import java.util.Stack;

public class TopologicalSort {
    static Stack<Node> stack = new Stack();
    public void sortAndPrint(Node node)
    {
        if(node.visited)
        {
            return;
        }
        if(node.neighbours.size()==0)
        {
            node.visited=true;
            stack.push(node);
            return;
        }
        node.visited=true;
        for(Node neighbour :node.neighbours)
        {
            sortAndPrint(neighbour);
        }
        stack.push(node);

    }
    public static void main(String vv[])
    {
        Node a= new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");
        Node f = new Node("F");
        Node g = new Node("G");
        Node h = new Node("H");
        Node i = new Node("I");
        Node j = new Node("J");
        a.setNeighbour(b);
        a.setNeighbour(f);
        b.setNeighbour(h);
        d.setNeighbour(c);
        d.setNeighbour(i);
        d.setNeighbour(e);
        e.setNeighbour(i);
        g.setNeighbour(a);
        g.setNeighbour(b);
        g.setNeighbour(c);
        i.setNeighbour(c);
        j.setNeighbour(e);
        TopologicalSort tsort = new TopologicalSort();
        tsort.sortAndPrint(a);
        tsort.sortAndPrint(b);
        tsort.sortAndPrint(c);
        tsort.sortAndPrint(d);
        tsort.sortAndPrint(e);
        tsort.sortAndPrint(f);
        tsort.sortAndPrint(g);
        tsort.sortAndPrint(h);
        tsort.sortAndPrint(i);
        tsort.sortAndPrint(j);
        while (tsort.stack.size()>0)
        {
            System.out.print(((Node)tsort.stack.pop()).label+" ");
        }
    }

}
