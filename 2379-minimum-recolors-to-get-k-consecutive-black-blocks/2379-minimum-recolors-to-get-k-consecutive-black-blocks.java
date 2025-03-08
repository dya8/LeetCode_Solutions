class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        int minOperations = Integer.MAX_VALUE;
        int whiteCount = 0;

        // Count white blocks in the first window of size k
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
                whiteCount++;
            }
        }

        minOperations = whiteCount;

        // Slide the window from left to right
        for (int i = k; i < n; i++) {
            // Remove leftmost element from previous window
            if (blocks.charAt(i - k) == 'W') {
                whiteCount--;
            }
            // Add new rightmost element to current window
            if (blocks.charAt(i) == 'W') {
                whiteCount++;
            }
            // Update minimum operations required
            minOperations = Math.min(minOperations, whiteCount);
        }

        return minOperations;
    }
}