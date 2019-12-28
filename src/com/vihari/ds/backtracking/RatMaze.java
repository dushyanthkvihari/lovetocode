package com.vihari.ds.backtracking;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RatMaze {
    static String pathString="";
    public int[] pathROW ={0,0,-1,1};
    public int[] pathCOLUMN = {-1,1,0,0};
    public Map<String,Character> directionsMap = new HashMap<>();

    public RatMaze()
    {
        directionsMap.put("0-1",'L');
        directionsMap.put("01",'R');
        directionsMap.put("-10",'U');
        directionsMap.put("10",'D');
    }

    public boolean isValid(int[][] maze,int row,int column, int ROW_COLUMN_COUNT)
    {
        if( row < 0 || column < 0 || row>ROW_COLUMN_COUNT || column>ROW_COLUMN_COUNT )
        {
            return false;
        }
        if(maze[row][column] == 0)
        {
            return false;
        }
        return true;

    }
    public void printPaths(int[][]maze, int row,int column, int rowCount, int parentROW, int parentCOLUMN)
    {
        if( row == rowCount-1 && column == rowCount-1 )
        {
            System.out.println(pathString);
            return;
        }
        for(int i=0; i<4; i++)
        {
            if(row+pathROW[i]==parentROW && column+pathCOLUMN[i]==parentCOLUMN)
            {
                continue;
            }
            if(isValid(maze,row+pathROW[i],column+pathCOLUMN[i],rowCount))
            {
                pathString = pathString + directionsMap.get(pathROW[i]+""+pathCOLUMN[i]);
                printPaths(maze,row+pathROW[i],column+pathCOLUMN[i],4,row,column);
                return;
            }

        }
        pathString =pathString.substring(0,pathString.length()>0?pathString.length()-1:0);
        return;

    }
    public static void main(String vv[])
    {
        RatMaze rm = new RatMaze();
        int [][] maze = {{1,0,0,0},{1,1,0,1},{0,1,0,0},{0,1,1,1}};
        rm.printPaths(maze,0,0,4,0,0);
    }
}
