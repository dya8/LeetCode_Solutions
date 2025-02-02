class Solution
 {
    public boolean check(int[] nums)
     {
        int n=nums.length;int i;int pivot=0;
        boolean increasing =true;
        for(i=0;i<n-1;i++)
        {
            if(nums[i+1] < nums[i])
            {
                pivot=i;
                increasing = false;
                break;
            }
        }
        if(increasing)
        return true;
        int rotate = n-(pivot+1);
        int rotatedArray[] =new int[n];
        for(i=0;i<n;i++)
        {

            rotatedArray[(i+rotate)%n]=nums[i];
        }
        for(i=0;i<n-1;i++)
        {
            if(rotatedArray[i+1] < rotatedArray[i])
                return false;

        }
        return true;
    }
}