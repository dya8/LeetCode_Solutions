class Solution 
{
    public String makeFancyString(String s) 
    {
        StringBuilder result = new StringBuilder();
        int count = 1;  // To count consecutive characters
        
        // Start with the first character
        result.append(s.charAt(0));
        
        for (int i = 1; i < s.length(); i++) {
            // Check if the current character is the same as the last one added to the result
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                // Reset count if we encounter a different character
                count = 1;
            }
            
            // Only add the character if it does not create three consecutive identical characters
            if (count < 3) {
                result.append(s.charAt(i));
            }
        }
        
        return result.toString();
    }

    }
