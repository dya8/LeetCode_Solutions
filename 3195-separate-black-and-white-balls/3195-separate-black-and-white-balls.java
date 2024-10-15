class Solution
 {
    public long minimumSteps(String s)
     {
        long blackcount=0l;
        long swapcount=0l;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='0')
             swapcount+=blackcount;
           
            else if(s.charAt(i)=='1')
             blackcount++;
           
        }
        return swapcount;
    }
}