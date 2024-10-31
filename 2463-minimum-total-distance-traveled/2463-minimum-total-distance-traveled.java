class Solution 
{
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) 
    {
                // Sort robots and factories by their positions
       // Sort robots and factories by their positions
        robot.sort(Integer::compareTo);
        Arrays.sort(factory, (a, b) -> Integer.compare(a[0], b[0]));

        int n = robot.size();
        int m = factory.length;

        // Initialize the DP array with large values
        long[][] dp = new long[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Long.MAX_VALUE / 2); // Use a large number to avoid overflow
        }
        dp[0][0] = 0;

        // Fill the DP table
        for (int j = 1; j <= m; j++) {
            dp[0][j] = 0; // No robots need zero distance
            for (int i = 1; i <= n; i++) {
                dp[i][j] = dp[i][j - 1]; // Case when we don't use the j-th factory
                long dist = 0;
                // Try to assign k robots to factory j - 1
                for (int k = 1; k <= Math.min(i, factory[j - 1][1]); k++) {
                    dist += Math.abs(robot.get(i - k) - factory[j - 1][0]);
                    dp[i][j] = Math.min(dp[i][j], dp[i - k][j - 1] + dist);
                }
            }
        }
        
        // The minimum total distance for all robots
        return dp[n][m];

    }
}