package com.vihari.ds.graphs;

import java.util.*;

public class MinimumSwaps {
    static boolean visited[] ;
    public List<Integer> sortedArray= new ArrayList<>();
    public Map<Integer,Integer> membersOfCycle= new HashMap<>();
    public static  int noOfCycles = 0;
    public boolean isInCorrectPosition(int element,int index)
    {
        if(sortedArray.indexOf(element)!=index)
            return false;
        return true;
    }
    public void countCycles(Integer[] orgArray,int index)
    {
        if(visited[index])
        {
            return;
        }
        if(!isInCorrectPosition(orgArray[index],index)) {
            visited[index] = true;
            int newCount = membersOfCycle.get(noOfCycles)!=null?membersOfCycle.get(noOfCycles)+1:1;
            membersOfCycle.put(noOfCycles,newCount);
            countCycles(orgArray, sortedArray.indexOf(orgArray[index]));

        }
        visited[index]=true;
    }
    public void sortGivenArray(Integer[] unsorted)
    {
        PriorityQueue<Integer> pq = new PriorityQueue();
        pq.addAll(Arrays.asList(unsorted));

        for(int i=0;i<unsorted.length;i++)
        {
            sortedArray.add(pq.poll());
        }
    }
    public static void main(String vv[])
    {
        MinimumSwaps ms = new MinimumSwaps();
        Integer[] orgArray = new Integer[]{4,3,2,1};
        visited = new boolean[4];
        for(int i=0;i<orgArray.length;i++)
        {
            visited[i]=false;
        }
        ms.sortGivenArray(orgArray);
        for(int i=0;i<orgArray.length;i++)
        ms.countCycles(orgArray,i);
        System.out.println(noOfCycles);

    }
}
