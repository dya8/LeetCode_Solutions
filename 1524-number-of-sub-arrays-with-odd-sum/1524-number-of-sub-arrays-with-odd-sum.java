class Solution 
{
    public int numOfSubarrays(int[] arr) 
    {
       int prefixsum=0;
       int even_count=1;
       int odd_count=0;
       int total=0;
       int MOD = 1000000007;
        for(int i=0;i<arr.length;i++)
        {
            prefixsum+=arr[i];
           if((prefixsum & 1) ==1)
           {
            total = (total + even_count) % MOD;
            odd_count++;
           }
           else
           {
            total = (total + odd_count) % MOD;
            even_count++;
           }
          
        }
        return total;
        
    }
}