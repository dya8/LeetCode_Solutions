class Solution 
{
    public int longestSquareStreak(int[] nums)
     {
      // Sort the array to help with ordered square streaks
        Arrays.sort(nums);
        // Use a set for O(1) lookups
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int maxStreak = -1;

        // Iterate through each number in the sorted list
        for (int num : nums) {
            int streakLength = 0;
            int current = num;

            // Count the streak length by checking for each square's existence
            while (numSet.contains(current)) {
                streakLength++;
                // Check if the square of the current value would exceed 10^5
                if (current > 10_000) break; // Prevent going beyond bounds
                current = current * current;  // Square the current number
            }

            // Update max streak length if this streak is longer and valid
            if (streakLength >= 2) {
                maxStreak = Math.max(maxStreak, streakLength);
            }
        }

        return maxStreak;
    }
}