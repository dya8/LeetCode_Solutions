class Solution 
{
    public int maxScore(String s) 
    {
        int max=0,sum;
        String a,b;
        if(s.length()==2)
        { 
             a=s.substring(0,1);
            b=s.substring(1);
            sum=countZero(a)+countOne(b);
            System.out.print(countZero(a)+" "+countOne(b));
            max=Math.max(max,sum);
           return max;
        }
        
        for(int i=0;i<s.length()-1;i++)
        {
            
            sum=0;
            a=s.substring(0,i+1);
            b=s.substring(i+1);
            sum=countZero(a)+countOne(b);
            max=Math.max(max,sum);

        }
        return max;
    
    }
    public int countZero(String s)
    {
      int c=0;
      for(int i=0;i<s.length();i++)
      {
        if(s.charAt(i)=='0')
        c++;
      }
      return c;
    }
    public int countOne(String s)
    {
      int c=0;
      for(int i=0;i<s.length();i++)
      {
        if(s.charAt(i)=='1')
        c++;
      }
      return c;
    }
}