
class Solution
{ 
    int reverse(int x) 
    {
      int sign = (x < 0) ? -1 : 1;
        
        // Removing the sign from x
        x = Math.abs(x);
        
        // Reversing the digits of x
        int rev = 0;
        while (x != 0) {
            int digit = x % 10;
            // Checking for overflow before adding the new digit
            if (rev > (Integer.MAX_VALUE - digit) / 10) {
                return 0;
            }
            rev = rev * 10 + digit;
            x /= 10;
        }
        
        // Reapplying the sign
        rev *= sign;
        
        return rev;
    }
}

 
