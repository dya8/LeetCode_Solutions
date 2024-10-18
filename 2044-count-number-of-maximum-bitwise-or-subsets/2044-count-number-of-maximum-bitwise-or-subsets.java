class Solution
 {
    public int countMaxOrSubsets(int[] nums) 
    {
        int n = nums.length;
        int maxOr = 0;

        // Step 1: Find the maximum possible bitwise OR
        for (int num : nums) {
            maxOr |= num;
        }

        // Step 2: Count subsets with the maximum bitwise OR
        return countSubsets(nums, maxOr);
    }

    private int countSubsets(int[] nums, int targetOr) {
        int count = 0;
        int n = nums.length;
        int totalSubsets = 1 << n; // 2^n subsets

        // Generate all subsets using bitmasking
        for (int mask = 1; mask < totalSubsets; mask++) {
            int currentOr = 0;

            // Compute OR of the current subset
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    currentOr |= nums[i];
                }
            }

            // If the current subset OR equals the target OR, increase the count
            if (currentOr == targetOr) {
                count++;
            }
        }

        return count;

        
    }
}