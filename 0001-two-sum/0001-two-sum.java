class Solution 
{
    public int[] twoSum(int[] nums, int target) 
    {
         int arr[]=new int[2];
        for(int i=0;i<nums.length;i++)
          {
               
               int a =nums[i];
               for(int j=i+1;j<nums.length;j++)
               {
              int b =nums[j];
             if((a+b)==target)
             {
             arr[0]=i;
             arr[1]=j;
             break;
             }
               }
          }
               Arrays.sort(arr);
               
         
         return arr;
               }
        
    }
