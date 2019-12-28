package com.vihari.ds.graphs;

import javax.swing.plaf.synth.SynthEditorPaneUI;
import java.util.*;
import java.util.concurrent.DelayQueue;

/**
 * https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1
 */
public class BFS {
    public static Queue<Node> queue =new LinkedList<>();
    class Node{
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
    public void bFSTravesal( Node node)
    {
        if(queue.size()!=0)
        {
            Node temp = queue.poll();
            if(temp.visited)
                return;
            node.visited=true;
            System.out.println(temp.label);
            for (Node i : temp.neighbours)
            {
                if(!i.visited)
                    queue.add(i);
            }
            bFSTravesal(queue.peek());
        }

    }
    public static  void main(String vv[])
    {
        BFS bfs = new BFS();
        Node n1 = bfs.new Node("1");
        Node n2 = bfs.new Node("2");
        Node n3 = bfs.new Node("3");
        Node n4 = bfs.new Node("4");
        Node n5 = bfs.new Node("5");
        Node n6 = bfs.new Node("6");
        Node n7 = bfs.new Node("7");
//        Node n8 = bfs.new Node("8");
//        Node n9 = bfs.new Node("9");
//        Node n10 = bfs.new Node("10");
        n1.setNeighbour(n2);
        n1.setNeighbour(n3);
        n1.setNeighbour(n5);
        n1.setNeighbour(n7);
        n2.setNeighbour(n4);
        n2.setNeighbour(n5);
        n3.setNeighbour(n6);
        n3.setNeighbour(n7);
        //n7.setNeighbour(n5);
        queue.add(n1);
        bfs.bFSTravesal(n1);
//        for(int i=0;i<queue.size();i++)
//        {
//            System.out.print(queue.poll().label+" ");
//        }
    }
}
