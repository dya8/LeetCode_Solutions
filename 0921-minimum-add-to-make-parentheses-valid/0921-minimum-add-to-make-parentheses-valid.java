class Solution {
    public int minAddToMakeValid(String s) {
           int openCount = 0; // To count unmatched '('
        int closeCount = 0; // To count unmatched ')'
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                openCount++; // An opening parenthesis needs a match
            } else {
                if (openCount > 0) {
                    openCount--; // Match a ')' with an unmatched '('
                } else {
                    closeCount++; // An unmatched closing parenthesis
                }
            }
        }
        
        // The result is the sum of unmatched '(' and unmatched ')'
        return openCount + closeCount;
    }
}