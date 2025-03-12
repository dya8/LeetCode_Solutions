class Solution {
    public int numberOfSubstrings(String s) {
        
         int[] count = new int[3]; // Count occurrences of 'a', 'b', and 'c'
        int left = 0, result = 0;

        for (int right = 0; right < s.length(); right++) {
            count[s.charAt(right) - 'a']++; // Increment count for the current character

            // Shrink the window if all three characters are present
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                result += s.length() - right; // All substrings ending at 'right' are valid
                count[s.charAt(left) - 'a']--; // Move left pointer
                left++;
            }
        }
        return result;
    }
}