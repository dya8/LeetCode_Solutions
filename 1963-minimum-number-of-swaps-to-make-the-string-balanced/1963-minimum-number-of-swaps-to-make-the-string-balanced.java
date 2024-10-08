class Solution {
    public int minSwaps(String s) 
    {
       Stack<Character> st=new Stack<>();
       for(char c:s.toCharArray()) 
       {
    
        if(st.isEmpty())
          st.push(c);
          else if(st.peek()=='[' && c==']')
          st.pop();
          else
          st.push(c);
       }
       if(st.size() ==2)
        return 1;   //single pair found

        int single=st.size()/2;//if stack does not have both boy and girl
        //then half of then would total swap count
        return ((int)Math.ceil((double)single/2));
       
       
       
           }
}