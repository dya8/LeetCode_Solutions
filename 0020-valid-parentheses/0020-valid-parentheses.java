class Solution
 {
    public boolean isValid(String s)

     {
         Stack<Character> stack = new Stack<>();
        char[] brackets = {'(', ')', '{', '}', '[', ']'};
        for (char c : s.toCharArray()) {
            if (c == brackets[0] || c == brackets[2] || c == brackets[4]) {
                stack.push(c);
            } else if (c == brackets[1] || c == brackets[3] || c == brackets[5]) {
                if (stack.isEmpty() || stack.pop() != getMatchingBracket(c))
                    return false;
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    private char getMatchingBracket(char c) {
        if (c == ')') return '(';
        else if (c == '}') return '{';
        else return '[';
    }
        
    }
