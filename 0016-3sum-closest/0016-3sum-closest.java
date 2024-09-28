class Solution
 {
    public int threeSumClosest(int[] nums, int target) 
    {
        Arrays.sort(nums);
        int closestSum = Integer.MAX_VALUE / 2; // Initialize with a large value
        
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];
                if (Math.abs(target - currentSum) < Math.abs(target - closestSum)) {
                    closestSum = currentSum;
                }
                
                if (currentSum < target) {
                    left++;
                } else if (currentSum > target) {
                    right--;
                } else {
                    return currentSum;
                }
            }
        }
        
        return closestSum;
    }
}