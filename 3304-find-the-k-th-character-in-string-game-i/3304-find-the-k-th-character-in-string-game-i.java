class Solution 
{
    public char kthCharacter(int k)
    {
    
     String str = "a";
        while(str.length() < k){
            String s = "";
            for(char ch:str.toCharArray()){
                s += ch=='z'?"a":(char)(ch+1);
            }
            str += s;
        }
        return str.charAt(k-1);
    }
}