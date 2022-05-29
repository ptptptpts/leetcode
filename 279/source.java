class Solution {
    public int numSquares(int n) {
        int[] leastSquares = new int[n + 1];

        leastSquares[0] = 0;
        for (int i = 1; i <= n; i++) {
            leastSquares[i] = i;
            for (int j = 1; j * j <= i; j++) {
                leastSquares[i] = Math.min(leastSquares[i], leastSquares[i - (j * j)] + 1);
            }
        }

        return leastSquares[n];
    }
}
