import java.util.Arrays;

class Solution {
    public int integerBreak(int n) {
        int[] maxProducts = new int[n+1];

        maxProducts[0] = 1;
        maxProducts[1] = 1;
        for (int i = 2; i <= n; i++) {
            int maxProduct = (i < n) ? i : 0;
            for (int j = 1; j < i; j++) {
                maxProduct = Math.max(maxProduct, maxProducts[j] * (i - j));
            }
            maxProducts[i] = maxProduct;
        }

        return maxProducts[n];
    }
}
