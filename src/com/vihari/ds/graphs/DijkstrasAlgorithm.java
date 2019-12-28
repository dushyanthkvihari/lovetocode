package com.vihari.ds.graphs;

import java.util.HashSet;
import java.util.Set;

public class DijkstrasAlgorithm {
    Set sortedSet = new HashSet();
    public static int COLUMN;

    /**
     * Algorithm
     * 1)step1 consider the source vertex -fetch the neighbour with minimum distance
     * 2)from the chose neighbor calculate the distances to its neighbours and compare
     * it with distances to its neighbors to source and update if this is less. Save this node to sorted set.
     * 3)choose next shortest node from the neighbors of source and not in sorted set and repeat setp1
     */

    public int getMinimumIndexNotInSet(int[][] sourceArray, int sourcerowindex)
    {
        int MINIMUM =Integer.MAX_VALUE;
        int minIndex=-1;
        for(int i=0; i<COLUMN; i++)
        {
            if( sourceArray[sourcerowindex][i]!=0&&sourceArray[sourcerowindex][i] < MINIMUM && !sortedSet.contains(i) && i!=sourcerowindex )
            {
                MINIMUM = sourceArray[sourcerowindex][i];
                minIndex = i;
            }
        }
        return  minIndex;

    }

    public void dijkstras(int[][] sourceArray,int sourceIndex)
    {
        for(int j=0;j<COLUMN;j++) {
            int minIndex = getMinimumIndexNotInSet(sourceArray, sourceIndex);
            if( minIndex == -1 )
            {
               continue;
            }
            for (int i = 0; i < COLUMN; i++) {
                if (sourceArray[minIndex][i] > 0 && minIndex != i && i!=sourceIndex) {
                    int dist = sourceArray[sourceIndex][minIndex] + sourceArray[minIndex][i];
                    if (sourceArray[sourceIndex][i]==0||dist < sourceArray[sourceIndex][i]) {
                        sourceArray[sourceIndex][i] = dist;
                    }
                }
            }
            sortedSet.add(minIndex);
        }
    }
    public static void main(String[] vv)
    {
        int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
        //int graph [][] = new int[][]{{0,10,5},{0,0,30},{1,4,0}};
        DijkstrasAlgorithm ds= new DijkstrasAlgorithm();
        COLUMN = graph[0].length;
        ds.dijkstras(graph,0);

        for(int i=0;i<COLUMN;i++)
        {
            System.out.print(graph[0][i]+" ");
        }
    }
}
