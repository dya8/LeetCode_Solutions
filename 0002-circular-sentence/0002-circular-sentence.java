class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] s = sentence.split(" ");
        String s1, s2;
        int c = 0;

        // Check if there is only one word and if it starts and ends with the same character
        if (s.length == 1) {
            s1 = s[0];
            return s1.charAt(0) == s1.charAt(s1.length() - 1);
        } else {
            // Check consecutive pairs of words
            for (int i = 0; i < s.length - 1; i++) {
                s1 = s[i];
                s2 = s[i + 1];
                if (s1.charAt(s1.length() - 1) == s2.charAt(0)) {
                    c++;
                }
            }
            // Check the last word's last character with the first word's first character
            if (s[s.length - 1].charAt(s[s.length - 1].length() - 1) == s[0].charAt(0)) {
                c++;
            }
        }

        // Verify if all conditions are met for a circular sentence
        return c == s.length;
    }
}
