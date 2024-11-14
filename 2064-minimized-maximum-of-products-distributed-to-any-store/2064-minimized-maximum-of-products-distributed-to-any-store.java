class Solution {
    public int minimizedMaximum(int n, int[] quantities) 
    {

      int low = 1;
        int high = getMax(quantities);
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            
            if (canDistribute(n, quantities, mid)) {
                high = mid; // Try for a smaller maximum
            } else {
                low = mid + 1; // Increase the maximum allowed
            }
        }
        
        return low;
    }
    
    // Function to check if we can distribute products such that no store gets more than maxPerStore products
    private boolean canDistribute(int n, int[] quantities, int maxPerStore) {
        int storesNeeded = 0;
        for (int quantity : quantities) {
            storesNeeded += (quantity + maxPerStore - 1) / maxPerStore; // Equivalent to Math.ceil(quantity / maxPerStore)
            if (storesNeeded > n) return false; // Early exit if we exceed available stores
        }
        return storesNeeded <= n;
    }
    
    // Function to get the maximum value in the array
    private int getMax(int[] quantities) {
        int max = 0;
        for (int quantity : quantities) {
            max = Math.max(max, quantity);
        }
        return max;
   
    }
}