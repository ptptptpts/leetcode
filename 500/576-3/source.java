class Solution {
    private final static long MOD = 1000000007L;
    
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        long result = 0;

        long[][] map = new long[m+2][n+2];
        long[][] nextMap = new long[m+2][n+2];
        for (int i = 0; i < m+2; i++) {
            Arrays.fill(map[i], 0);
            Arrays.fill(nextMap[i], 0);
        }
        map[startRow+1][startColumn+1] = 1;

        for (int move = 0; move < maxMove; move++) {
            for (int row = 1; row <= m; row++) {
                result += map[row][1];
                result += map[row][n];
            }
            for (int column = 1; column <= n; column++) {
                result += map[1][column];
                result += map[m][column];
            }
            result = result % MOD;

            for (int row = 1; row <= m; row++) {
                for (int column = 1; column <= n; column++) {
                    nextMap[row][column] = map[row-1][column];
                    nextMap[row][column] += map[row+1][column];
                    nextMap[row][column] += map[row][column-1];
                    nextMap[row][column] += map[row][column+1];
                    nextMap[row][column] = nextMap[row][column] % MOD;
                }
            }

            long[][] temp = map;
            map = nextMap;
            nextMap = temp;
        }

        return (int)(result % MOD);
    }
}