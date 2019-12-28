package com.vihari.ds.graphs;

/**
 * https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1/
 */
public class CycleInUnDirectedGraph {
    public static boolean cycleDetected = false;

    public void dfsTraverserAndSeeIfCycleExists(Node node,Node parent)
    {
        if(node.visited==true)
        {

                cycleDetected = true;
            return;
        }
            if(node.neighbours.size()==0)
            {
                node.visited = true;
                return;
            }
            node.visited=true;
            for(Node neighbour : node.neighbours)
            {
                //this check is not necessary in case of directed graph
                if(neighbour!=parent)
                dfsTraverserAndSeeIfCycleExists(neighbour,node);
            }
        
    }
    public static void main(String vv[])
    {
        CycleInUnDirectedGraph unDirectedGraph = new CycleInUnDirectedGraph();
        Node n1 = new Node("1");
        Node n2 = new Node("2");
        Node n3 = new Node("3");
        Node n4 = new Node("4");
        Node n5 = new Node("5");
        Node n6 = new Node("6");
        Node n7 = new Node("7");
        Node n8 = new Node ("8");
//        Node n8 = new Node("8");
//        Node n9 = new Node("9");
//        Node n10 = new Node("10");
        n1.setNeighbour(n2);
        n1.setNeighbour(n3);
        n1.setNeighbour(n8);
        n2.setNeighbour(n4);
        n2.setNeighbour(n1);
        n2.setNeighbour(n5);
        n3.setNeighbour(n6);
        n3.setNeighbour(n1);
        n3.setNeighbour(n7);
        n7.setNeighbour(n3);
        n6.setNeighbour(n3);
        n5.setNeighbour(n2);
        n4.setNeighbour(n2);
        n7.setNeighbour(n8);
        n8.setNeighbour(n7);
        n8.setNeighbour(n1);
        unDirectedGraph.dfsTraverserAndSeeIfCycleExists(n1,null);
        if(cycleDetected)
        {
            System.out.println(cycleDetected);
        }
        
    }
}
