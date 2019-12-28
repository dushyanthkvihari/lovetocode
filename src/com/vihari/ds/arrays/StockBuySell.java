package com.vihari.ds.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StockBuySell {
    class ResultIndexes
    {
        int buyIndex;
        int sellIndex;
        public ResultIndexes(int buy,int sell)
        {
            buyIndex=buy;
            sellIndex=sell;
        }
    }
    public List<ResultIndexes> fetchpairs(int[] arr)
    {
        int localMinima=0;
        int localMaxima =0;
        List<ResultIndexes> rI = new ArrayList<>();
        int n= arr.length;
        for(int i=0;i<n-1;)
        {
            if(arr[i]<arr[i+1])
            {
                localMinima =i;
                int j=i+1;
                localMaxima=j;
                for(;j<n-1;j++)
                {
                    if(arr[j]>arr[j+1])
                    {
                        localMaxima =j;
                        rI.add(new ResultIndexes(localMinima,localMaxima));
                        break;
                    }
                }
                if(j==n-1)
                {
                    localMaxima = j;
                    rI.add(new ResultIndexes(localMinima,localMaxima));
                }

            }
            i=localMaxima+1;
        }
        return rI;
    }
    public static void main(String vv[])
    {
        StockBuySell sbs = new StockBuySell();
        int price[] = { 100, 180, 260, 310, 40, 535, 695 };
        for (ResultIndexes rs: sbs.fetchpairs(price))
        {
            System.out.println(rs.buyIndex+","+rs.sellIndex);
        }

       // Arrays.stream(results).forEach(resultIndexes -> System.out.println(resultIndexes.buyIndex+","+resultIndexes.sellIndex));
    }

}
