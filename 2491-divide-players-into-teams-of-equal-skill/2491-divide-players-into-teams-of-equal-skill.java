class Solution
 {
    public long dividePlayers(int[] skill)
     {
        Arrays.sort(skill);
        HashMap<Integer,Integer> r= findSum(skill);
        int n=skill.length-1;
        long total=0l;
        int sum=0;
        int lp=0;
        int rp=n;
          sum+=skill[0]+skill[n];
            if(r.get(sum)!=((n+1)/2))
            return -1;
            else
            {
                while(lp<rp)
                {
                     total+=skill[lp]*skill[rp];
                  lp++;
                   rp--;
                }
            }



        return total;
    }
    private HashMap<Integer,Integer> findSum (int[] skill)
    {
         int sum;
        HashMap<Integer,Integer> s=new HashMap<>();
       int n=skill.length-1;
        int lp=0;
        int rp=n;
        
        while(lp<rp)

        {
           sum=0;
           sum+=skill[lp]+skill[rp];
           if(s.containsKey(sum))
            s.put(sum,s.get(sum)+1);
            else
            s.put(sum,1);
           lp++;
           rp--;

        }
        return s;

    }
}