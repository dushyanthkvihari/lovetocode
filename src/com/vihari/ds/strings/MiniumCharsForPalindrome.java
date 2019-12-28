package com.vihari.ds.strings;

public class MiniumCharsForPalindrome {

    public boolean isPalindrome(String str)
    {
        char [] charArray = str.toCharArray();
        for(int i=0;i<str.length();i++)
        {
            if(charArray[i]!=charArray[str.length()-1-i])
            {
                return false;
            }
        }
        return true;
    }
    public void printMinimumChars(String src)
    {
        int count =0;
        String prependedString ="";
        for(int i=0;i<src.length();i++)
        {
            if(isPalindrome(src))
            {
                System.out.println("no of characters needs to be added : "+count +" converted source : "+src);
                return;
            }
            count++;
            prependedString = "" + src.charAt(src.length()-1-i);
            src = prependedString+src;
        }
    }
    public static void main(String vv[])
    {
        MiniumCharsForPalindrome min = new MiniumCharsForPalindrome();
        min.printMinimumChars("abbac");
    }
}
