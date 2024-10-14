class Solution 
{
    public long maxKelements(int[] nums, int k)
     {
         /// Max heap to store numbers in descending order
        PriorityQueue<Long> maxHeap = new PriorityQueue<>((a, b) -> Long.compare(b, a));

        // Add all elements from nums to the maxHeap, converting to long to handle large values
        for (int num : nums) {
            maxHeap.offer((long) num);
        }

        long score = 0;

        // Perform the operation k times
        for (int i = 0; i < k; i++) {
            // Get the maximum element from the heap
            long maxElement = maxHeap.poll();

            // Increase score by the maximum element
            score += maxElement;

            // Replace the element with its ceiling value when divided by 3
            maxHeap.offer((long) Math.ceil(maxElement / 3.0));
        }

        return score;
    }
}
