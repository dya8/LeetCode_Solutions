class Solution
 {
    public String intToRoman(int num) 
    {
        LinkedHashMap<String, Integer> romanMap = new LinkedHashMap<>();
        romanMap.put("M", 1000);
        romanMap.put("CM", 900);
        romanMap.put("D", 500);
        romanMap.put("CD", 400);
        romanMap.put("C", 100);
        romanMap.put("XC", 90);
        romanMap.put("L", 50);
        romanMap.put("XL", 40);
        romanMap.put("X", 10);
        romanMap.put("IX", 9);
        romanMap.put("V", 5);
        romanMap.put("IV", 4);
        romanMap.put("I", 1);

        // Initialize a StringBuilder to store the result
        StringBuilder result = new StringBuilder();

        // Iterate through the romanMap entries
        for (Map.Entry<String, Integer> entry : romanMap.entrySet()) {
            String symbol = entry.getKey();
            int value = entry.getValue();

            // Repeat the symbol while its value is less than or equal to the input number
            while (num >= value) {
                result.append(symbol);
                num -= value;
            }
        }

        return result.toString();
    }
}