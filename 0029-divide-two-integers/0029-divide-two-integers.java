class Solution 
{
    public int divide(int dividend, int divisor) 
    {
        if (divisor == 0) {
            return dividend >= 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        // Edge case: overflow
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Sign of the quotient
        int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;

        // Take the absolute value of dividend and divisor
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);

        long quotient = 0;
        // Subtract divisor from dividend until it becomes less than divisor
        while (absDividend >= absDivisor) {
            // Initialize the number of times the divisor is shifted
            int shift = 0;
            while (absDividend >= (absDivisor << shift)) {
                shift++;
            }
            shift--;

            // Add the number of times the divisor is shifted to the quotient
            quotient += (1L << shift);

            // Subtract divisor * (2^shift) from dividend
            absDividend -= (absDivisor << shift);
        }

        // Apply sign to the quotient
        quotient *= sign;

        // Check for overflow and return the result
        if (quotient < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else if (quotient > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else {
            return (int) quotient;
        }
    }
    }
