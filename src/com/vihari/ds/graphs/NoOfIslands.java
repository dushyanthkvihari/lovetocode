package com.vihari.ds.graphs;

public class NoOfIslands {

    static int noOFIslands=0;
    static boolean islandfound =false;
    int[][] input ;
    boolean[][] visisted ;
    static int ROW = 5;
    static int COLUMN = 5;
    static int[] possibleRows=     {0,0,1,-1,1,-1,-1,1};
    static int[] possibleColumns = {1,-1,0,0,1,1,-1,-1};
    public boolean isValid(int row,int col)
    {
        if(row>=0&&row<ROW&&col>=0&&col<COLUMN)
        {
            return true;
        }
        return false;
    }

    public void computeIslands(int r,int c)
    {
        if(this.visisted[r][c]|| this.input[r][c]!=1)
        {
            return;
        }
        this.visisted[r][c]=true;
        islandfound = true;
        for(int i=0;i<8;i++)
        {
            if(isValid(r+possibleRows[i],c+possibleColumns[i]))
            computeIslands(r+possibleRows[i],c+possibleColumns[i]);
        }

    }
    public static void main(String vv[])
    {
        NoOfIslands ilands = new NoOfIslands();
        ilands.input =  new int[][] { { 1, 1, 0, 0, 0 },
                { 0, 1, 0, 0, 1 },
                { 1, 0, 0, 1, 1 },
                { 0, 0, 0, 0, 0 },
                { 1, 0, 1, 0, 1 } };
        ilands.visisted = new boolean[5][5];
        for(int i=0;i<5;i++)
        {
            for(int j=0;j<5;j++)
            {
                ilands.visisted[i][j]=false;
            }
        }
        for(int i=0;i<5;i++)
        {
            for(int j=0;j<5;j++)
            {
                if(!ilands.visisted[i][j] && ilands.input[i][j]==1 )
                {
                    ilands.computeIslands(i,j);
                    if(islandfound)
                    {
                        noOFIslands++;
                        islandfound=false;
                    }
                }
            }
        }
        System.out.println("no of islands : "+noOFIslands);
    }



}
