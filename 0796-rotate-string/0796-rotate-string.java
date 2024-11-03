class Solution {
    public boolean rotateString(String s, String goal) 
    {
          // Check if both strings have the same length
        if (s.length() != goal.length()) {
            return false;
        }
        // Check if goal is a substring of s + s
        String combined = s + s;
        return combined.contains(goal);
    }
}