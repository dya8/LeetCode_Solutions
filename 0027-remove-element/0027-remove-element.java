class Solution 
{
    public int removeElement(int[] nums, int val) 
    {
     int i,j=0;
     int []temp=new int[nums.length];
     for(i=0;i<nums.length;i++)
        {
            if(nums[i]==val)
            continue;
           // temp[j++]=nums[i];
           nums[j++]=nums[i];

        }
    //  for(i=0;i<j;i++) 
   //   nums[i]=temp[i]; 
      return j; 


    }
}           