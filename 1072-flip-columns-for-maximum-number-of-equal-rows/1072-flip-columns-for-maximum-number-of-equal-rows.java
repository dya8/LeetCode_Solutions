class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix)
    {
      Map<String, Integer> patternCount = new HashMap<>();
        int maxRows = 0;

        for (int[] row : matrix) {
            // Create a canonical pattern for the row
            StringBuilder pattern = new StringBuilder();
            StringBuilder flippedPattern = new StringBuilder();
            int baseValue = row[0]; // Use the first value as the base to determine flips

            for (int value : row) {
                // Add to pattern (unchanged) and flipped pattern
                pattern.append(value == baseValue ? '1' : '0');
                flippedPattern.append(value == baseValue ? '0' : '1');
            }

            // Use the canonical representation (pattern or flipped pattern)
            String canonicalPattern = pattern.toString();
            patternCount.put(canonicalPattern, patternCount.getOrDefault(canonicalPattern, 0) + 1);

            // Update the maximum rows count
            maxRows = Math.max(maxRows, patternCount.get(canonicalPattern));
        }

        return maxRows;
    }
}