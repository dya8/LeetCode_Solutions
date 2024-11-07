class Solution
 {
    public int largestCombination(int[] candidates) 
     {
        
        // The number of bits to consider is 24 (since max candidate value <= 10^7, which fits in 24 bits)
        int[] bitCount = new int[24];

        // Count the set bits for each bit position across all numbers in candidates
        for (int num : candidates) {
            for (int i = 0; i < 24; i++) {
                if ((num & (1 << i)) != 0) {
                    bitCount[i]++;
                }
            }
        }

        // Find the maximum count across all bit positions
        int maxCombinationSize = 0;
        for (int count : bitCount) {
            maxCombinationSize = Math.max(maxCombinationSize, count);
        }

        return maxCombinationSize;
    }
}
