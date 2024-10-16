class Solution {
    public String longestDiverseString(int a, int b, int c) 
    {
         // Create a string builder to store the result
        StringBuilder result = new StringBuilder();
        
        // Initialize an array to store the occurrences of 'a', 'b', and 'c' as pairs of (count, character)
        int[][] count = new int[][]{{a, 'a'}, {b, 'b'}, {c, 'c'}};
        
        while (true) {
            // Sort the array by the count of characters, descending
            java.util.Arrays.sort(count, (x, y) -> y[0] - x[0]);
            
            boolean hasAdded = false;
            
            // Check if we can add the most frequent character
            for (int i = 0; i < 3; i++) {
                // If this character has occurrences left
                if (count[i][0] <= 0) {
                    continue; // No characters of this type left, skip
                }
                
                // Length of the current result
                int length = result.length();
                
                // If adding the character doesn't cause an invalid substring (i.e. "aaa", "bbb", or "ccc")
                if (length >= 2 && result.charAt(length - 1) == count[i][1] && result.charAt(length - 2) == count[i][1]) {
                    continue; // Skip if it would create an invalid substring
                }
                
                // Append the character to the result
                result.append((char) count[i][1]);
                
                // Decrease the count of this character
                count[i][0]--;
                
                hasAdded = true; // Mark that we have added a character
                break;
            }
            
            // If no character was added, break the loop (we cannot add more characters)
            if (!hasAdded) {
                break;
            }
        }
        
        return result.toString();
    }
    
}