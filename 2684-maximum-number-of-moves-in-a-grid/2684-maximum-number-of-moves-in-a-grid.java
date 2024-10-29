class Solution {
    public int maxMoves(int[][] grid) 
    {
         int m = grid.length;
        int n = grid[0].length;
        
        int[][] dp = new int[m][n];
        
        // Fill dp array with -1 initially to indicate uncomputed cells.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        
        int maxMoves = 0;
        
        // Start DFS from every cell in the first column
        for (int i = 0; i < m; i++) {
            maxMoves = Math.max(maxMoves, dfs(grid, dp, i, 0));
        }
        
        return maxMoves;
    }
    
    private int dfs(int[][] grid, int[][] dp, int row, int col) {
        int m = grid.length;
        int n = grid[0].length;
        
        // If we're out of bounds, return 0 moves.
        if (col >= n - 1) return 0;
        
        // If we already computed this cell, return the stored result.
        if (dp[row][col] != -1) return dp[row][col];
        
        int maxMoves = 0;
        
        // Check the three possible moves
        if (row > 0 && grid[row][col] < grid[row - 1][col + 1]) {
            maxMoves = Math.max(maxMoves, 1 + dfs(grid, dp, row - 1, col + 1));
        }
        
        if (grid[row][col] < grid[row][col + 1]) {
            maxMoves = Math.max(maxMoves, 1 + dfs(grid, dp, row, col + 1));
        }
        
        if (row < m - 1 && grid[row][col] < grid[row + 1][col + 1]) {
            maxMoves = Math.max(maxMoves, 1 + dfs(grid, dp, row + 1, col + 1));
        }
        
        dp[row][col] = maxMoves;
        return maxMoves;
    }
}