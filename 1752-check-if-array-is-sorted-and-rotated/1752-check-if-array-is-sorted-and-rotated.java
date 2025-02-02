class Solution
 {
    public boolean check(int[] nums)
     {
        int n=nums.length;int i;int pivot=0;
        boolean increasing =true;
        for(i=1;i<n;i++)
        {
            if(nums[i] < nums[i-1])
            {
                pivot=i;
                increasing = false;
                break;
            }
        }
        if(increasing)
        return true;
        int rotate = n-pivot;
        int rotatedArray[] =new int[n];
        for(i=0;i<n;i++)
        {

            rotatedArray[(i+rotate)%n]=nums[i];
        }
        for(i=1;i<n;i++)
        {
            if(rotatedArray[i] < rotatedArray[i-1])
                return false;

        }
        return true;
    }
}