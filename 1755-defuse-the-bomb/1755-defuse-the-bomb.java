class Solution {
    public int[] decrypt(int[] code, int k) 
    {
        int n = code.length;
        int[] result = new int[n];

        if (k == 0) {
            Arrays.fill(result, 0);
            return result;
        }

        int start, end, step;
        if (k > 0) {
            start = 1;
            end = k;
            step = 1;
        } else {
            start = -1;
            end = k;
            step = -1;
            k = -k; // Work with the absolute value of k
        }

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = start; Math.abs(j) <= k; j += step) {
                sum += code[(i + j + n) % n]; // Handle wrapping using modulo
            }
            result[i] = sum;
        }

        return result;
    }
    }
