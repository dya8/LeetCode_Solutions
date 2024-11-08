class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit)
     {
        int n = nums.length;
        int[] answer = new int[n];
        
        // Step 1: Calculate the XOR of the entire array.
        int numsXor = 0;
        for (int num : nums) {
            numsXor ^= num;
        }
        
        // Step 2: Define the maximum value we can XOR with, based on maximumBit.
        int maxVal = (1 << maximumBit) - 1; // Equivalent to 2^maximumBit - 1
        
        // Step 3: For each query, calculate the required k, then remove the last element's effect from numsXor.
        for (int i = 0; i < n; i++) {
            answer[i] = numsXor ^ maxVal; // Get the k that maximizes the XOR
            numsXor ^= nums[n - 1 - i];  // Update numsXor by removing the last element
        }
        
        return answer;
    }
}