package com.vihari.ds.strings;

public class LongestPalindrome {
    public void printLongestPalindrome(String s)
    {
        int maxlength =1;
        String palindromeSubString="";
        for(int i=1; i<s.length(); i++)
        {
            int low=i-1;
            int high = i;
            //printing even length palindromes
            while(low>=0&&high<s.length()&& s.charAt(low)==s.charAt(high))
            {
                if( maxlength < (high-low +1 ) )
                {
                    maxlength = high -low +1;
                    palindromeSubString = s.substring(low,high+1);
                }
                low--;
                high++;
            }
        }
        for(int i=1;i<s.length();i++)
        {
            int low = i-1;
            int high = i+1;
            //printing odd length palindromes
            while(low>=0&&high<s.length()&& s.charAt(low)==s.charAt(high))
            {
                if(maxlength < (high-low +1 ) )
                {
                    maxlength = high -low +1;
                    palindromeSubString = s.substring(low,high+1);

                }
                low--;
                high++;
            }
        }
        System.out.println(palindromeSubString);

    }

    public static void main(String vv[])
    {
        LongestPalindrome lp= new LongestPalindrome();
        String testString="forgeeksskeegfor";
        lp.printLongestPalindrome(testString);
    }
}
