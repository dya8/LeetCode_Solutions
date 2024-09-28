class Solution
 {
    public int romanToInt(String s)
     {
      Map<Character, Integer> romanValues = new HashMap<>();
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);

        // Initialize a variable to store the result
        int result = 0;

        // Iterate through the characters of the input string
        for (int i = 0; i < s.length(); i++) {
            int currentValue = romanValues.get(s.charAt(i));
            
            // If the current symbol's value is less than the next symbol's value, subtract it
            if (i < s.length() - 1 && romanValues.get(s.charAt(i + 1)) > currentValue) {
                result -= currentValue;
            } else {
                result += currentValue;
            }
        }

        return result;  
    }
}