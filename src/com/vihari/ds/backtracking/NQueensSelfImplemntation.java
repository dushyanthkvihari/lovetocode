package com.vihari.ds.backtracking;

import java.util.Arrays;

public class NQueensSelfImplemntation {

    class Positions
    {
        int row,column;
        public Positions(int r,int c)
        {
            row = r;
            column =c;
        }
    }
    public void printPossiblePositions(int n)
    {
        Positions[] positions = new Positions[n];
        printAllQueenPostions(positions,0,n);

    }
    public void printAllQueenPostions(Positions[] prevPositions,int level, int n)
    {
        if(level==n)
        {
            System.out.println("found position");
            Arrays.stream(prevPositions).forEach(positions -> System.out.println(positions.row+" "+positions.column));
            return;
        }
        for( int col=0; col<n; col++ )
        {
            boolean canBeSafelyPlaced = true;
            for( int j=0; j<level; j++ )
            {
                if( prevPositions[j].row==level|| prevPositions[j].column==col
                        || (prevPositions[j].row-prevPositions[j].column) == level-col
                        || prevPositions[j].row+prevPositions[j].column==level+col)
                {
                    canBeSafelyPlaced= false;
                    break;
                }
            }
            if(canBeSafelyPlaced)
            {
                Positions p = new Positions(level,col);
                prevPositions[level]= p;
                printAllQueenPostions(prevPositions,level+1,n);
            }
        }

    }
    public static void main(String vv[])
    {
        NQueensSelfImplemntation q = new NQueensSelfImplemntation();
        q.printPossiblePositions(4);
    }
}
