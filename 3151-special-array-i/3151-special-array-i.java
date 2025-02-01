class Solution {
    public boolean isArraySpecial(int[] nums)
     {
        if(nums.length == 1)
        return true;
        else
        {
            for(int i=0;i<nums.length-1;i++)
            {
                
                if(par(nums[i])==par(nums[i+1]))
                 return false;
                

            }
            return true;
        }
        
    }
    public static int par(int a)
    {
        if(a%2==0)
          return 1;
          return 0;
    }
}