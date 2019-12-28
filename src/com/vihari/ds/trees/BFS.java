package com.vihari.ds.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BFS {
    Queue<Node> queue = new LinkedList<Node>();
    Node root = new Node();
    class Node
    {
        Node left;
        Node right;
        String data;
    }
    public void printBFS(Queue<Node> q)
    {
        while (q.size()>0)
        {
            if((q.peek()).left!=null)
            {
                q.add(q.peek().left);
            }
            if((q.peek()).right!=null)
            {
                q.add(q.peek().right);
            }
            System.out.println(q.poll().data);
        }

    }

    public void printSpiral(Stack<Node> rtl, Stack<Node> ltr)
    {
        while (rtl.size()>0)
        {
            Node temp = rtl.pop();
            System.out.println(rtl.pop().data);
            if(temp.left!=null)
            ltr.push(temp.left);
        }
    }
public static void main(String v[])
{
    BFS bfs = new BFS();
    bfs.root = bfs.new Node();
    BFS.Node rootLeft = new BFS().new Node();
    rootLeft.data = "b";
    BFS.Node rootRight = new BFS().new Node();
    rootRight.data = "c";
    bfs.root.data="a";
    bfs.root.left =rootLeft;
    bfs.root.right =rootRight;

    bfs.queue.add(bfs.root);
    BFS.Node rootLeftLeft = new BFS().new Node();
    rootLeftLeft.data = "d";
    rootLeft.left =rootLeftLeft;
    BFS.Node rootLeftRight = new BFS().new Node();
    rootLeftRight.data = "e";
    rootLeft.right = rootLeftRight;

    BFS.Node rootRightLeft = new BFS().new Node();
    rootRightLeft.data = "f";
    rootRight.left = rootRightLeft;

    BFS.Node rootRightRight = new BFS().new Node();
    rootRightRight.data = "g";
    rootRight.right =rootRightRight;

    bfs.printBFS(bfs.queue);

}
}
