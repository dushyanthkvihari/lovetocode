package com.vihari.ds.arrays;

public class TrappingRainWater {

    public static void main(String vv[])
    {
        int water =0;
        int currentmax = 0;
        int arr[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];
        left[0]= arr[0];
        for(int i=1;i<arr.length;i++)
        {
            left[i] = Math.max(left[i-1],arr[i]);
        }
        right[arr.length-1] = arr[arr.length-1];
        for(int j= arr.length-2;j>=0;j--)
        {
            right[j]= Math.max(right[j+1],arr[j]);
        }
        for(int i=0;i< arr.length;i++)
        {
            water=water+Math.min(left[i],right[i])-arr[i];
        }
        System.out.print("water collected "+water);

    }
}
