class Solution
 {
    public boolean isPalindrome(int x) 
    {
        char s[]=(""+x).toCharArray();

      int lp=0;
      int rp=s.length-1;
       while(lp<rp)
       {
        char t=s[lp];
        s[lp]=s[rp];
        s[rp]=t;
        lp++;
        rp--;
       }
       
       String t = new String(s);
        return (t.equals(""+x));



    
    
    }
 }

