class Solution {
    public int lengthOfLongestSubstring(String s) 
    {
         int n = s.length();
        int maxLength = 0;
        Map<Character, Integer> charIndexMap = new HashMap<>();
        
        int left = 0;
        
        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);
            if (charIndexMap.containsKey(c)) {
                left = Math.max(left, charIndexMap.get(c) + 1);
            }
            charIndexMap.put(c, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
        
    
}