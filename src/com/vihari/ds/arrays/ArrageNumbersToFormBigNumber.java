package com.vihari.ds.arrays;

public class ArrageNumbersToFormBigNumber {

    public static void main(String vv[])
    {
        int[] arr={54,546,548,60};
        String[] st = new String[arr.length];
        int stCount = 0;

        for(int i=1;i<arr.length;i++)
        {
            String x = arr[i]+""+arr[i-1];
            String y = arr[i-1]+""+arr[i];
            Integer it = Integer.parseInt(Integer.parseInt(x)>Integer.parseInt(y)?x:y);
            if(Integer.parseInt(x)>Integer.parseInt(y)) {
                st[stCount] = arr[i-1] + "";

                stCount++;
            }
            else
            {
                st[stCount]=arr[i]+"";
                stCount++;
            }
            for(int j=1;j<stCount;j++)
            {
                int p = Integer.parseInt(st[j]+""+it);
                int q = Integer.parseInt(it+""+st[j]);
                if(p>q)
                {
                    for(int k=stCount;k>=1;k++)
                    {
                        st[k]=st[k-1];
                    }
                    st[0]=arr[i]+"";
                }
                else
                {
                    st[stCount]=arr[i]+"";
                    stCount++;
                }

            }
        }
    }
}
