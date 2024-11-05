class Solution {
    public String compressedString(String word) 
    {
        StringBuilder comp = new StringBuilder();
        int i = 0;
        
        while (i < word.length()) {
            char currentChar = word.charAt(i);
            int count = 1;
            
            // Count consecutive occurrences of the same character, capped at 9
            while (i + count < word.length() && word.charAt(i + count) == currentChar && count < 9) {
                count++;
            }
            
            // Append count and character to the result
            comp.append(count).append(currentChar);
            
            // Move to the next group of characters
            i += count;
        }
        
        return comp.toString();
        
    }
}