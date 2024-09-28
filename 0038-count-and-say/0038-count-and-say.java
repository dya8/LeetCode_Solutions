class Solution {
    public String countAndSay(int n) 
    {
         if (n == 1) {
            return "1";
        }
        
        String result = "1";
        for (int i = 2; i <= n; i++) {
            result = getNextSequence(result);
        }
        
        return result;
    }

    private static String getNextSequence(String sequence) {
        StringBuilder nextSequence = new StringBuilder();
        int count = 1;
        char currentChar = sequence.charAt(0);

        for (int i = 1; i < sequence.length(); i++) {
            if (sequence.charAt(i) == currentChar) {
                count++;
            } else {
                nextSequence.append(count).append(currentChar);
                currentChar = sequence.charAt(i);
                count = 1;
            }
        }

        nextSequence.append(count).append(currentChar);
        return nextSequence.toString();
    }
        
    }
