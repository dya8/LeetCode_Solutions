class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) 
    {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int left = 0, right = m;

        while (left <= right) {
            int partitionNums1 = (left + right) / 2;
            int partitionNums2 = (m + n + 1) / 2 - partitionNums1;

            int maxLeftNums1 = (partitionNums1 == 0) ? Integer.MIN_VALUE : nums1[partitionNums1 - 1];
            int minRightNums1 = (partitionNums1 == m) ? Integer.MAX_VALUE : nums1[partitionNums1];

            int maxLeftNums2 = (partitionNums2 == 0) ? Integer.MIN_VALUE : nums2[partitionNums2 - 1];
            int minRightNums2 = (partitionNums2 == n) ? Integer.MAX_VALUE : nums2[partitionNums2];

            if (maxLeftNums1 <= minRightNums2 && maxLeftNums2 <= minRightNums1) {
                if ((m + n) % 2 == 0) {
                    return (double)(Math.max(maxLeftNums1, maxLeftNums2) + Math.min(minRightNums1, minRightNums2)) / 2;
                } else {
                    return Math.max(maxLeftNums1, maxLeftNums2);
                }
            } else if (maxLeftNums1 > minRightNums2) {
                right = partitionNums1 - 1;
            } else {
                left = partitionNums1 + 1;
            }
        }
        
        // This line should never be reached
        throw new IllegalArgumentException("Input arrays are not sorted.");
    }
}
    
