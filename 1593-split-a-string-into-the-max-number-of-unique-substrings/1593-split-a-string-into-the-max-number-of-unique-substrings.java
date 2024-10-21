class Solution
 {
    public int maxUniqueSplit(String s) 
    {
        
        return backtrack(s, 0, new HashSet<>());
    }

    private int backtrack(String s, int start, HashSet<String> uniqueSubstrings) {
        // If we have reached the end of the string, return 0 (no more splits possible)
        if (start == s.length()) {
            return 0;
        }

        int maxSplit = 0;

        // Try splitting the string into all possible substrings starting from index 'start'
        for (int end = start + 1; end <= s.length(); end++) {
            String substring = s.substring(start, end);

            // Only proceed if the substring hasn't been used yet
            if (!uniqueSubstrings.contains(substring)) {
                uniqueSubstrings.add(substring); // Add the current substring to the set

                // Recursively backtrack and calculate the number of unique splits
                int splits = 1 + backtrack(s, end, uniqueSubstrings);

                maxSplit = Math.max(maxSplit, splits); // Update the maximum number of splits

                uniqueSubstrings.remove(substring); // Backtrack by removing the substring
            }
        }

        return maxSplit; // Return the maximum number of unique splits
    }
}