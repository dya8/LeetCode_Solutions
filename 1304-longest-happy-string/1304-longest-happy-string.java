class Solution 
{
    static class Pair implements Comparable<Pair>
     {
        int count;
        char character;

        Pair(int count, char character)
         {
            this.count = count;
            this.character = character;
        }

        @Override
        public int compareTo(Pair other) 
        {
            return other.count - this.count;
        }
    }
   
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder res = new StringBuilder();
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>();

        if (a > 0) maxHeap.add(new Pair(a, 'a'));
        if (b > 0) maxHeap.add(new Pair(b, 'b'));
        if (c > 0) maxHeap.add(new Pair(c, 'c'));

        while (!maxHeap.isEmpty()) {
            Pair current = maxHeap.poll();
            int n = res.length();

            // Check if the current character has occurred in the previous 2 indices
            if (n >= 2 && res.charAt(n - 1) == current.character && res.charAt(n - 2) == current.character) {
                if (maxHeap.isEmpty()) break;

                Pair next = maxHeap.poll();
                res.append(next.character);
                next.count--;

                if (next.count > 0) maxHeap.add(next);
            } else {
                res.append(current.character);
                current.count--;
            }

            if (current.count > 0) maxHeap.add(current);
        }

        return res.toString();
    }
    }
    
