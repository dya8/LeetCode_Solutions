class Solution {
    public void nextPermutation(int[] nums)
     {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // Step 2: Find the largest index j greater than i such that nums[i] < nums[j]
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            // Step 3: Swap the elements at indices i and j
            swap(nums, i, j);
        }

        // Step 4: Reverse the elements from index i+1 to the end of the array
        reverse(nums, i + 1, nums.length - 1);
        
    }
     private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
}
}