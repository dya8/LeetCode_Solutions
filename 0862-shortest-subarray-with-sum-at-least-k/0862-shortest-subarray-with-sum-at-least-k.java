class Solution 
{
    public int shortestSubarray(int[] nums, int k) 
    {
         int n = nums.length;
        long[] prefixSum = new long[n + 1];
        
        // Calculate prefix sum
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        
        // Deque to store indices
        Deque<Integer> deque = new LinkedList<>();
        int minLength = Integer.MAX_VALUE;
        
        for (int i = 0; i <= n; i++) {
            // Check for valid subarray
            while (!deque.isEmpty() && prefixSum[i] - prefixSum[deque.peekFirst()] >= k) {
                minLength = Math.min(minLength, i - deque.pollFirst());
            }
            
            // Maintain increasing order of prefix sums in deque
            while (!deque.isEmpty() && prefixSum[i] <= prefixSum[deque.peekLast()]) {
                deque.pollLast();
            }
            
            // Add current index to deque
            deque.addLast(i);
        }
        
        return minLength == Integer.MAX_VALUE ? -1 : minLength;
 
        
    }
}