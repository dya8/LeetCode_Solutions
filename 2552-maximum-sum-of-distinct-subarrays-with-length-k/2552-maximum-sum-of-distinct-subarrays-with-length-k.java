class Solution
 {
    public long maximumSubarraySum(int[] nums, int k) 
    {
        int i,n=nums.length;
       
        long max =0l,s;
        for(i=0;i<=n-k;i++)
         {    
            HashSet<Integer> set=new HashSet<>();
                s=0l;
                boolean unique=true;

            for(int j= i ;j< i+k;j++)
            {
              if(set.contains(nums[j]))
              {
                unique=false;
                break;
              
            }
            set.add(nums[j]);
               s+=nums[j];
            }
            if (unique && s > max)

             max=s;
         }
         
         return max;
    }
}