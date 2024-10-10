class Solution {
    public int maxWidthRamp(int[] nums) 
    {
         Stack<Integer> stack = new Stack<>();
        
        // Step 1: Build a decreasing monotonic stack of indices
        for (int i = 0; i < nums.length; i++) {
            if (stack.isEmpty() || nums[stack.peek()] > nums[i]) {
                stack.push(i);
            }
        }
        
        // Step 2: Traverse from the right and calculate the maximum ramp width
        int maxWidth = 0;
        for (int j = nums.length - 1; j >= 0; j--) {
            // While the stack is not empty and nums[stack.peek()] <= nums[j]
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[j]) {
                int i = stack.pop();
                maxWidth = Math.max(maxWidth, j - i);
            }
        }
        
        return maxWidth;
        
    }
}