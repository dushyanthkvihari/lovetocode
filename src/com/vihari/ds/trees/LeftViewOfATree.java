package com.vihari.ds.trees;

import java.util.Scanner;

public class LeftViewOfATree {
    private LeftViewOfATree left;
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    private LeftViewOfATree right;

    public LeftViewOfATree getLeft() {
        return left;
    }


    public LeftViewOfATree getRight() {
        return right;
    }

    public void setRight(LeftViewOfATree root) {
        this.right = root;
    }

    public void setLeft(LeftViewOfATree left) {
        this.left = left;
    }
    void traverseAndPrint(LeftViewOfATree node)
    {
        LeftViewOfATree curRoot = node;
        System.out.println(curRoot.getValue());
        while (curRoot!=null) {
            if (curRoot.getLeft() != null) {
                curRoot = curRoot.getLeft();
                System.out.println(curRoot.getValue());
            }
            else if(curRoot.getRight()!= null)
            {
                curRoot = curRoot.getRight();
                System.out.println(curRoot.getValue());
            }
            else {
                break;
            }
        }

    }

    public static void main( String vv[])
    {
        Scanner scanner = new Scanner( System.in);
        scanner.useDelimiter(" ");
       // int noOfNodes = scanner.nextInt();
        String [] input = new String[12];
        int i=0;
        while (scanner.hasNext())
        {
            String end = scanner.next();
            if(end.equals("."))
            {
                break;
            }
            input[i] = end;
            i = i+1;
        }
        LeftViewOfATree root= new LeftViewOfATree();
        root.setValue(input[0]);

        LeftViewOfATree currentElement = root;
        for(int j=0; j < input.length;)
        {
            if( !currentElement.getValue().equals(input[j]) )
            {
                if(currentElement.getValue().equals(currentElement.getLeft().getValue()))
                {
                    currentElement= currentElement.left;

                }
                else
                {
                    currentElement= currentElement.right;
                }
            }
//            else
//            {
//                System.out.println("invalid input" );
//                break;
//            }
            if( input[j+2].equals("R"))
            {
                currentElement.setValue( input[j] );
                LeftViewOfATree lft = new LeftViewOfATree();
                lft.setValue(input[j+1]);
                currentElement.setRight(lft);
                j= j+2;
            }
            if( input[j+2].equals("L"))
            {
                currentElement.setValue( input[j] );
                LeftViewOfATree lft = new LeftViewOfATree();
                lft.setValue(input[j+1]);
                currentElement.setLeft(lft);
            }
        }


    }
}
