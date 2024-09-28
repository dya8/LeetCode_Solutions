import java.util.*;
class Solution
 {
    public int maxArea(int[] height) 
    {
        int lp=0;int rp=height.length-1;int ht,wdth,currentwater,maxwater=0;
            while(lp<rp)
            {
               ht=Math.min(height[lp],height[rp]);
               wdth=rp-lp;
               currentwater=ht*wdth;
               maxwater=Math.max(currentwater,maxwater);
                if(height[lp]<height[rp])
                {
                    lp++;
                }
                else
                {
                    rp--;
                }


            }
            return maxwater;
        
    }
}