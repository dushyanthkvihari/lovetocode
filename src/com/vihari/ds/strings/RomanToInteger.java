package com.vihari.ds.strings;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    Map<String,Integer> romanSet=new HashMap();
    public RomanToInteger()
    {
        romanSet.put("I",1);
        romanSet.put("V",5);
        romanSet.put("X",10);
        romanSet.put("L",50);
        romanSet.put("C",100);
        romanSet.put("D",500);
        romanSet.put("M",1000);
    }
    public void printIntegerFromRoman(String romanNumber)
    {
        char[] c = romanNumber.toCharArray();
        int integerSum=0;
        for(int i=0;i<c.length;i++)
        {
           int val1 = romanSet.get(""+c[i]);
            int va12=Integer.MIN_VALUE;
           if(i+1<c.length) {
              va12 = romanSet.get("" + c[i + 1]);
           }
           if(val1>=va12)
           {
               integerSum = integerSum+val1;
           }
           else if (val1 < va12)
           {
               integerSum = va12-val1+integerSum; i++;
           }
        }
        System.out.println(integerSum);

    }

    public static void main(String vv[])
    {
        RomanToInteger ri = new RomanToInteger();
        ri.printIntegerFromRoman("MCMIV");
    }
}
