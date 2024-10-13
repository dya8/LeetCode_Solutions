class Solution {
    public int[] smallestRange(List<List<Integer>> nums) 
    {
          // Priority queue to store the current elements from each list, ordered by value
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        int maxInHeap = Integer.MIN_VALUE;
        int rangeStart = 0, rangeEnd = Integer.MAX_VALUE;

        // Add the first element from each list to the heap
        for (int i = 0; i < nums.size(); i++) {
            int val = nums.get(i).get(0);
            minHeap.offer(new int[]{val, i, 0});  // {value, list index, element index in list}
            maxInHeap = Math.max(maxInHeap, val);
        }

        // Extract elements from the heap and expand the range
        while (minHeap.size() == nums.size()) {
            int[] curr = minHeap.poll();
            int minInHeap = curr[0];
            int listIndex = curr[1];
            int elemIndex = curr[2];

            // Check if the current range is the smallest
            if (maxInHeap - minInHeap < rangeEnd - rangeStart) {
                rangeStart = minInHeap;
                rangeEnd = maxInHeap;
            }

            // Move to the next element in the list
            if (elemIndex + 1 < nums.get(listIndex).size()) {
                int nextVal = nums.get(listIndex).get(elemIndex + 1);
                minHeap.offer(new int[]{nextVal, listIndex, elemIndex + 1});
                maxInHeap = Math.max(maxInHeap, nextVal);
            } else {
                // If we reached the end of a list, break the loop
                break;
            }
        }

        return new int[]{rangeStart, rangeEnd};        
    }
}