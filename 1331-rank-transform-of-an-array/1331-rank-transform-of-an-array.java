class Solution 
{
    public int[] arrayRankTransform(int[] arr)
    {
        int p[]=new int[arr.length];
        for(int i=0;i<arr.length;i++)
         p[i]=arr[i];
           
         
       HashMap<Integer,Integer> c= calculateRank(p);
       int a;
       for (int i=0;i<arr.length;i++)
        {
            a=arr[i];
           arr[i]=c.get(a);
        }
        return arr;

    }
    public HashMap<Integer,Integer> calculateRank(int [] arr)
    {
        Arrays.sort(arr);
        HashMap<Integer,Integer> hm=new HashMap<>();
        int rank=1;
        for(int r:arr)
        {
            if(!hm.containsKey(r))
            hm.put(r,rank++);
        }
        return hm ;
    }
}