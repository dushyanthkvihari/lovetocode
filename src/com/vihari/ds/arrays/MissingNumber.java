package com.vihari.ds.arrays;

public class MissingNumber {
    // a represents the array
    // n : Number of elements in array a
    static int getMissingNo(int a[], int n)
    {
//        int total = 0;
//        for (int i = 0; i <a.length; i++)
//        {
//            total =i+1;
//            total -= a[i];
//            if(total!=0)
//            {
//                return i+1;
//            }
//        }
//        return -1;
        int i, total;
        total = (n + 1) * (n + 2) / 2;
        for (i = 0; i < n; i++)
            total -= a[i];
        return total;
    }

    // Driver Code
    public static void main(String[] args)
    {
        int[] arr = { 1, 2, 3, 4 };
        System.out.println(getMissingNo(arr, arr.length));
    }
}
