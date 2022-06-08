class Solution {
    public int[][] updateMatrix(int[][] mat) {
        // Input: m x n binary matrix
        // Output: m x n matrix that contains a distance of the nearest 0 for each cell.

        // The distance between two adjacent cells is 1.

        // What is a range of a size of matrix? 1 <= m,n <= 10^4, 1 <= m * n <= 10^4
        // There is at least one 0 in the given matrix.

        // Let's think about when we search the array from left top to right bottom.
        // In this case, we can find the shortest distance from any left top 0.
        // And if we could not find any 0 previously, we can mark it as 10^4 + 1 the maximum value.
        // We can repeat this from right bottom to left top, and we can find the shortest distance from any right bottom 0.
        // So, we can find the distance from the nearest 0 on each cell.

        int m = mat.length;
        int n = mat[0].length;
        int[][] ret = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j< n; j++) {
                ret[i][j] = 10001;
            }
        }

        if (mat[0][0] == 0) {
            ret[0][0] = 0;
        }
        for (int i = 1; i < m; i++) {
            if (mat[i][0] == 0) {
                ret[i][0] = 0;
            } else {
                ret[i][0] = ret[i - 1][0] + 1;
            }
        }
        for (int i = 1; i < n; i++) {
            if (mat[0][i] == 0) {
                ret[0][i] = 0;
            } else {
                ret[0][i] = ret[0][i - 1] + 1;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (mat[i][j] == 0) {
                    ret[i][j] = 0;
                } else {
                    ret[i][j] = Math.min(ret[i-1][j], ret[i][j-1]) + 1;
                }
            }
        }

        for (int i = m - 2; i >= 0; i--) {
            if (mat[i][n - 1] != 0) {
                ret[i][n - 1] = Math.min(ret[i][n - 1], ret[i + 1][n - 1] + 1);
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (mat[m - 1][i] != 0) {
                ret[m - 1][i] = Math.min(ret[m - 1][i], ret[m - 1][i + 1] + 1);
            }
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if (mat[i][j] != 0) {
                    ret[i][j] = Math.min(ret[i][j], Math.min(ret[i+1][j], ret[i][j+1]) + 1);
                }
            }
        }

        return ret;
    }
}
