class Solution
 {
    public boolean parseBoolExpr(String expression)
     {
         Stack<Character> stack = new Stack<>();
        
        for (char c : expression.toCharArray()) {
            if (c == ',') {
                // Ignore commas since they are just separators
                continue;
            } else if (c != ')') {
                // Push all characters except closing parentheses to the stack
                stack.push(c);
            } else {
                // When we encounter a closing parenthesis, we evaluate the subexpression
                List<Character> subExpr = new ArrayList<>();
                
                // Pop until we reach the corresponding opening parenthesis
                while (stack.peek() != '(') {
                    subExpr.add(stack.pop());
                }
                
                // Pop the '('
                stack.pop();
                
                // The character before '(' indicates the operation type
                char operator = stack.pop();
                
                // Evaluate the sub-expression based on the operator
                char result = evaluateSubExpression(subExpr, operator);
                
                // Push the result of the sub-expression evaluation back to the stack
                stack.push(result);
            }
        }
        
        // The final result is at the top of the stack
        return stack.pop() == 't';
    }

    private char evaluateSubExpression(List<Character> subExpr, char operator) {
        if (operator == '&') {
            // AND: All must be true for result to be true
            for (char c : subExpr) {
                if (c == 'f') {
                    return 'f';
                }
            }
            return 't';
        } else if (operator == '|') {
            // OR: At least one must be true for result to be true
            for (char c : subExpr) {
                if (c == 't') {
                    return 't';
                }
            }
            return 'f';
        } else { // operator == '!'
            // NOT: Negate the single value in subExpr
            return subExpr.get(0) == 't' ? 'f' : 't';
        }
    }
}