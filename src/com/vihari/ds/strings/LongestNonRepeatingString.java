package com.vihari.ds.strings;

import java.util.HashMap;
import java.util.HashSet;

public class LongestNonRepeatingString {
    static int MAX_LENGTH =1;
    HashMap<Character,Integer> uniqueChars = new HashMap<>();
    public void printLengthOfLongestNRS(String str)
    {
        char c[] = str.toCharArray();
        uniqueChars.put(c[0],0);
        for(int i=1;i<c.length;i++)
        {
            if(uniqueChars.containsKey(c[i]))
            {
                i = uniqueChars.get(c[i]);

            }
            else
            {
                uniqueChars.put(c[i],i);
            }
            MAX_LENGTH = MAX_LENGTH>uniqueChars.size()?MAX_LENGTH:uniqueChars.size();
        }
        System.out.println("max length " + MAX_LENGTH);

    }
    public static void main(String vv[])
    {
        LongestPalindrome l = new LongestPalindrome();
        l.printLongestPalindrome("GEEKSFORGEEKS");
        System.out.println(MAX_LENGTH);
    }
}
