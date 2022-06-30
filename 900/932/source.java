import java.util.LinkedList;

class Solution {
    public int[] beautifulArray(int n) {
        return makeArray(n);
    }

    private int[] makeArray(int n) {
        if (n == 1) {
            return new int[] {1};
        }

        int[] ret = new int[n];

        int cur = 0;
        for (int i : makeArray((n + 1) / 2)) {
            ret[cur] = i * 2 - 1;
            cur++;
        }
        for (int i : makeArray(n / 2)) {
            ret[cur] = i * 2;
            cur++;
        }

        return ret;
    }
}