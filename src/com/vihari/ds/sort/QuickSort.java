package com.vihari.ds.sort;

import java.util.Arrays;

public class QuickSort {
    public int[] shift( int array[] ,int fromIndex,int toIndex)
    {
        int temp = array[fromIndex];
        for(int i=toIndex-1;i>fromIndex;i--)
        {

            array[i+1]=array[i];
        }
        return array;
    }

    public void sortQuickSort( int array[] )
    {
        for (int z=0;z<array.length;z++) {
            int pivot = array[array.length - 1];
            int i = -1;
            int j = 0;
            while (j != array.length - 2) {
                if (array[j] > array[pivot]) {
                    j++;
                }
                if (array[j] < pivot) {
                    i++;
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                    j++;
                }
            }
            array = shift(array, i, j);
            array[i + 1] = pivot;
        }
        for (int l:array)
        {
            System.out.print(l+" ");
        }

    }
    public static void main(String vv[])
    {
        QuickSort qs = new QuickSort();
        qs.sortQuickSort(new int[]{1,2,3,5,4});
    }

}
