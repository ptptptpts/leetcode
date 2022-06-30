class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int[][] ret = new int[mat.length][mat[0].length];

        for (int i = 0; i < mat.length; i++) {
            Arrays.fill(ret[i], 100000);
        }

        for (int j = 0; j < mat[0].length; j++) {
            if (mat[0][j] == 0) {
                ret[0][j] = 0;
            } else {
                if (j != 0) {
                    ret[0][j] = ret[0][j - 1] + 1;
                }
            }
        }
        for (int i = 1; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    ret[i][j] = 0;
                } else {
                    if (j == 0) {
                        ret[i][j] = ret[i - 1][j] + 1;
                    } else {
                        ret[i][j] = Math.min(ret[i - 1][j], ret[i][j - 1]) + 1;
                    }
                }
            }
        }

        for (int j = mat[0].length - 1; j >= 0; j--) {
            if (mat[mat.length - 1][j] == 0) {
                ret[mat.length - 1][j] = 0;
            } else {
                if (j != mat[0].length - 1) {
                    ret[mat.length - 1][j] = Math.min(ret[mat.length - 1][j], ret[mat.length - 1][j + 1] + 1);
                }
            }
        }
        for (int i = mat.length - 2; i >= 0; i--) {
            for (int j = mat[0].length - 1; j >= 0; j--) {
                if (mat[i][j] == 0) {
                    ret[i][j] = 0;
                } else {
                    if (j == mat[0].length - 1) {
                        ret[i][j] = Math.min(ret[i][j], ret[i + 1][j] + 1);
                    } else {
                        ret[i][j] = Math.min(ret[i][j], Math.min(ret[i + 1][j], ret[i][j + 1]) + 1);
                    }
                }
            }
        }
        
        return ret;
    }
}
