class Solution
 {
    public int minLength(String s) 
    {
        Stack<Character> st=new Stack<>();
         for(int i=0; i<s.length();i++)
         {
            char curr_char=s.charAt(i);
                if(st.isEmpty())
                {
                    st.push(curr_char);
                    continue;
                }
                if((curr_char == 'B' && st.peek() == 'A') ||(curr_char == 'D' && st.peek() == 'C'))
                  st.pop();
                  else
                  st.push(curr_char);
         }
         return st.size();
        
    }
}