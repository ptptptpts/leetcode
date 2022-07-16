class Solution {
    public int[] countBits(int n) {
        int[] ret = new int[n + 1];
        ret[0] = 0;

        int currentHistoryCursor = 0;
        int endOfHistoryCursor = 1;
        for (int i = 1; i <= n; i++) {
            ret[i] = 1 + ret[currentHistoryCursor];
            currentHistoryCursor++;

            if (currentHistoryCursor == endOfHistoryCursor) {
                currentHistoryCursor = 0;
                endOfHistoryCursor *= 2;
            }
        }

        return ret;
    }
}