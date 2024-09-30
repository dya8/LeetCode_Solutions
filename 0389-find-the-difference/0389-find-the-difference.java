import java.util.*;
class Solution 
{
    public char findTheDifference(String s, String t)
     {
        HashMap<Character,Integer> th=new HashMap<>();
          
          char [] tch=t.toCharArray();
          char [] sch=s.toCharArray();
           for(char c:tch)
           {
            if(th.containsKey(c))
              th.put(c,th.get(c)+1);
              else
              th.put(c,1);
           }
           for(char c:sch)
           {
                if (th.get(c) > 1)  //first decrease the value to zero and then remove
                    th.put(c, th.get(c) - 1);
                else
                    th.remove(c);

           }
               
      return (th.keySet().iterator().next());
        
        

           

    }
}