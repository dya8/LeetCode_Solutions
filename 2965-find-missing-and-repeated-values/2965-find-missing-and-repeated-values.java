class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
         int n = grid.length;
        int size = n * n;
        HashSet<Integer> set = new HashSet<>();
        int repeating = -1, missing = -1;
        
        // Step 1: Find the repeating number
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = grid[i][j];
                if (set.contains(num)) {
                    repeating = num;
                }
                set.add(num);
            }
        }

        // Step 2: Find the missing number
        for (int i = 1; i <= size; i++) {
            if (!set.contains(i)) {
                missing = i;
                break;
            }
        }
        
        return new int[]{repeating, missing};
    }
}