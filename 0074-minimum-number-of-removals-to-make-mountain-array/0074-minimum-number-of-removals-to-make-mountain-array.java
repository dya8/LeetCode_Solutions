class Solution
 {
    public int minimumMountainRemovals(int[] nums) 
    {
          int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        
        // Calculate increasing subsequence lengths for each element
        for (int i = 0; i < n; i++) {
            left[i] = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    left[i] = Math.max(left[i], left[j] + 1);
                }
            }
        }
        
        // Calculate decreasing subsequence lengths for each element
        for (int i = n - 1; i >= 0; i--) {
            right[i] = 0;
            for (int j = n - 1; j > i; j--) {
                if (nums[j] < nums[i]) {
                    right[i] = Math.max(right[i], right[j] + 1);
                }
            }
        }
        
        int maxMountainLength = 0;
        
        // Find the maximum mountain array length
        for (int i = 1; i < n - 1; i++) {
            if (left[i] > 0 && right[i] > 0) { // `i` must be a peak
                maxMountainLength = Math.max(maxMountainLength, left[i] + right[i] + 1);
            }
        }
        
        // Minimum elements to remove to get the longest mountain array
        return n - maxMountainLength;
    }
}