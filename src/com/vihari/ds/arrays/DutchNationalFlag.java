package com.vihari.ds.arrays;

import java.util.Arrays;

public class DutchNationalFlag {

    public static void printNoSortedArray(int [] arrays)
    {
        int low=0;
        int mid =1;
        int high = arrays.length-1;
        int temp=-1;
        while (mid<=high)
        {
            if(arrays[mid]==1)
            {
                mid++;
                continue;
            }
            else if(arrays[mid]==2)
            {
                temp= arrays[mid];
                arrays[mid] = arrays[high];
                arrays[high] = temp;
                high--;
                continue;
            }
            else if( arrays[mid]==0 )
            {
                temp= arrays[low];
                arrays[low]= arrays[mid];
                arrays[mid]=temp;
                low++;
                continue;
            }

        }
        Arrays.stream(arrays).forEach(System.out::print);
    }
    public static void main(String vv[])
    {
        int [] array = {1,2,2,0,1,0,2,0,1,1,1,2};
        printNoSortedArray(array);
    }
}
