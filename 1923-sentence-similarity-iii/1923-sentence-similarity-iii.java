class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        // Split sentences into word arrays
        String[] s1 = sentence1.split(" ");
        String[] s2 = sentence2.split(" ");
        
        // Ensure s1 is the shorter or equal length sentence
        if (s1.length > s2.length) {
            String[] temp = s1;
            s1 = s2;
            s2 = temp;
        }

        int n1 = s1.length, n2 = s2.length;

        // Find the maximum number of matching words from the start
        int i = 0;
        while (i < n1 && s1[i].equals(s2[i])) {
            i++;
        }

        // Find the maximum number of matching words from the end
        int j = 0;
        while (j < n1 && s1[n1 - 1 - j].equals(s2[n2 - 1 - j])) {
            j++;
        }

        // Check if the matched words from the start and end cover the entire shorter sentence
        return i + j >= n1;
    }
}
