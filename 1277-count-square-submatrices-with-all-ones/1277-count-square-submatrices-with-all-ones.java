class Solution 
{

    public int countSquares(int[][] matrix) 
    {
         int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int totalSquares = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Only consider if the cell is 1
                if (matrix[i][j] == 1) {
                    // Check for boundaries
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;  // First row or column squares are 1x1 if it's 1
                    } else {
                        dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
                    }
                    totalSquares += dp[i][j];  // Add squares formed at this cell
                }
            }
        }

        return totalSquares;
    }
}