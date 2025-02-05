class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
         // If the strings are already equal, return true
        if (s1.equals(s2)) {
            return true;
        }

        // List to store indices where characters are different
        int first = -1, second = -1;
        int count = 0;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;

                // Store indices of the first two mismatched characters
                if (count == 1) {
                    first = i;
                } else if (count == 2) {
                    second = i;
                } else {
                    return false; // More than 2 differences → cannot be made equal
                }
            }
        }

        // If there is exactly 2 mismatches, check if swapping makes them equal
        return count == 2 && s1.charAt(first) == s2.charAt(second) && s1.charAt(second) == s2.charAt(first);
    }
    }
