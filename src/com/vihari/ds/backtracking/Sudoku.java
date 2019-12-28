package com.vihari.ds.backtracking;

public class Sudoku {

    public boolean isValidPosition(int row,int column,int[][] board,int numtobeinserted,int noofrows)
    {
        for(int i=0;i<noofrows;i++)
        {
            if(board[row][i]==numtobeinserted)
            {
                return false;
            }
        }
        for (int i=0;i<noofrows;i++)
        {
            if(board[i][column]==numtobeinserted)
            {
                return false;
            }
        }
        int sqrt = (int) Math.sqrt(noofrows);
        int boxStartRow = row-(row%sqrt);
        int boxStartColumn = column -(column%sqrt);
        for(int i=boxStartRow;i<boxStartRow+sqrt;i++)
        {
            for(int j=boxStartColumn;j<boxStartColumn+sqrt;j++)
            {
                if(board[boxStartRow][boxStartColumn]==numtobeinserted)
                {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean printSolutionIfAny(int[][] board,int n)
    {
        int row=-1;
        int column = -1;
        boolean emptySpaceAvailable =false;
        //check for empty spaces
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board.length;j++)
            {
                if(board[i][j]==0)
                {
                    row=i;
                    column=j;
                    emptySpaceAvailable = true;
                    break;
                }
            }
            if(emptySpaceAvailable)
            {
                break;
            }
        }
        if(!emptySpaceAvailable)
        {
            for(int i=0;i<board.length;i++)
            {
                for(int j=0;j<board.length;j++)
                {
                    System.out.print(board[i][j]+" ");
                }
                System.out.println();
            }
            return true;
        }
        for(int i=1;i<n;i++)
        {
            if(isValidPosition(row,column,board,i,n))
            {
                board[row][column] = i;
                if(printSolutionIfAny(board,n))
                {
                    return true;
                }
                else
                {
                    board[row][column] =0;
                }
            }
        }
        return false;

    }
}
