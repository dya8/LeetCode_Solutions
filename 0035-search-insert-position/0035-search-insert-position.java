class Solution {
    public int searchInsert(int[] nums, int target) 
    {
 
     //binary search approach used as mentioned (o(log n)) algorithm need to be used 
     
         int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        // If the target is not found, left will be the index where it should be inserted
        return left;
    }
}