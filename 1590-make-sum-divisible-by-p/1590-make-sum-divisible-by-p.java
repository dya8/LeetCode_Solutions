import java.util.HashMap;

public class Solution {
    public int minSubarray(int[] nums, int p) {
        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int remainder = (int) (totalSum % p);
        if (remainder == 0) {
            return 0; // The sum is already divisible by p
        }

        HashMap<Integer, Integer> prefixModMap = new HashMap<>();
        prefixModMap.put(0, -1); // To handle edge cases
        int minLength = nums.length;
        long prefixSum = 0;

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            int currentMod = (int) (prefixSum % p);
            int targetMod = (currentMod - remainder + p) % p;

            if (prefixModMap.containsKey(targetMod)) {
                minLength = Math.min(minLength, i - prefixModMap.get(targetMod));
            }

            prefixModMap.put(currentMod, i);
        }

        return minLength == nums.length ? -1 : minLength;
    }

  }

