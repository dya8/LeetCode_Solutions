class Solution {
    public int minGroups(int[][] intervals)
     {
         int n=intervals.length;
         int[]start=new int[n];
         int[]end=new int[n];
         int i;
         for( i=0;i<n;i++)
         {
            start[i]=intervals[i][0];
            end[i]=intervals[i][1];
         }

         Arrays.sort(start);
         Arrays.sort(end);
         int startIndex=0;
         int endIndex=0;
         int grps=0;
         int maxgrps=0;

           while(startIndex < n)
           {
            if(start[startIndex] <= end[endIndex])
            {
                grps++;
                maxgrps=Math.max(maxgrps,grps);
                startIndex++;
            }
            else
            {
                grps--;
                endIndex++;
            }



           }
           return maxgrps;

    }
}