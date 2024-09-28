class Solution
 {
    public boolean isPalindrome(int x) 
    {
        String s=""+x;String rev="";char c;int i;boolean a;
        for( i=0;i<s.length();i++)
        {
            c=s.charAt(i);
            rev=c+rev;

        }
        System.out.println(rev);
    if(rev.equals(s))
     return true;
     else 
     return false;
    }
     


    
    
    }


