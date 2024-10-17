class Solution 
{
    public int maximumSwap(int num)
     {
        char narr[]=(""+num).toCharArray();
        int n=narr.length;
        int times[]=new int[10];

        //track the index of each digit
        for(int i=0;i<n;i++)
        times[narr[i]-'0']=i;

        for(int i=0;i<n;i++)
        {
            //to check we can large digit
            for(int d=9;d>narr[i]-'0';d--)
            {
                if(times[d]>i) //swap digits and return new value
                {
                    char temp=narr[i];
                    narr[i]=narr[times[d]];
                    narr[times[d]]=temp;
                    return Integer.parseInt(new String(narr));
                }
            }
        }
        return num;


    }
}