class Solution
 {
    public String longestCommonPrefix(String[] strs) 
    {
       StringBuilder result = new StringBuilder();
   
     Arrays.sort(strs);
     int i ,l=strs.length;

        char first[]= strs[0].toCharArray();
        char last[]= strs[l-1].toCharArray();

        for(i=0;i< first.length;i++)
            {
                if((first[i]) != (last[i]))
                {
                    break;

                }
                result.append(first[i]);
            }

            return result.toString();

           

        
        
        
    }
}