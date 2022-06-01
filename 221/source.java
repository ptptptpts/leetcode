class Solution {
    public int maximalSquare(char[][] matrix) {
        int largestSize = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        
        int[] lastRow = new int[m + 1];
        for (int i = 0; i <= m; i++ ){
            lastRow[i] = 0;
        }

        for (int i = 0; i < n; i++) {
            int[] currentRow = new int[m + 1];
            currentRow[0] = 0;
            
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    currentRow[j + 1] =
                        Math.min(lastRow[j], Math.min(currentRow[j], lastRow[j + 1])) + 1;
                    largestSize = Math.max(largestSize, currentRow[j + 1]);
                } else {
                    currentRow[j + 1] = 0;
                }
            }

            lastRow = currentRow;
        }


        return largestSize * largestSize;
    }
}
