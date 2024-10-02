class Solution 
{
    public boolean canArrange(int[] arr, int k) 
    {
       Map<Integer, Integer> remainderCount = new HashMap<>();

        // Populate the frequency map with remainders
        for (int num : arr) {
            int remainder = ((num % k) + k) % k; // To handle negative numbers
            remainderCount.put(remainder, remainderCount.getOrDefault(remainder, 0) + 1);
        }

        // Check the conditions for forming pairs
        for (Map.Entry<Integer, Integer> entry : remainderCount.entrySet()) {
            int r = entry.getKey();
            int count = entry.getValue();

            if (r == 0) {
                // Elements with remainder 0 must be paired among themselves
                if (count % 2 != 0) {
                    return false;
                }
            } else if (r * 2 == k) {
                // Elements with remainder k/2 must be paired among themselves
                if (count % 2 != 0) {
                    return false;
                }
            } else {
                // The count of remainder r must match the count of remainder k - r
                int complementCount = remainderCount.getOrDefault(k - r, 0);
                if (count != complementCount) {
                    return false;
                }
            }
        }

        return true;

}
}