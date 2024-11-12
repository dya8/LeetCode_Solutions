class Solution {

    public int[] maximumBeauty(int[][] items, int[] queries)
     {
        // Step 1: Sort items by price
        Arrays.sort(items, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 2: Build a cumulative max beauty array
        int n = items.length;
        List<int[]> maxBeautyByPrice = new ArrayList<>();
        int maxBeauty = 0;
        for (int[] item : items) {
            maxBeauty = Math.max(maxBeauty, item[1]);
            maxBeautyByPrice.add(new int[]{item[0], maxBeauty});
        }

        // Step 3: Sort queries while keeping original indices
        int m = queries.length;
        int[][] queriesWithIndex = new int[m][2];
        for (int i = 0; i < m; i++) {
            queriesWithIndex[i][0] = queries[i];
            queriesWithIndex[i][1] = i;
        }
        Arrays.sort(queriesWithIndex, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 4: Process each query using binary search
        int[] result = new int[m];
        int j = 0;
        for (int i = 0; i < m; i++) {
            int queryPrice = queriesWithIndex[i][0];
            int queryIndex = queriesWithIndex[i][1];

            // Move j to the first item with price greater than queryPrice
            while (j < n && maxBeautyByPrice.get(j)[0] <= queryPrice) {
                j++;
            }

            // If there are valid items with price <= queryPrice, get the max beauty
            result[queryIndex] = (j == 0) ? 0 : maxBeautyByPrice.get(j - 1)[1];
        }

        return result;
    }
}