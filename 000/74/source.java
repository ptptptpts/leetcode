class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = findRow(matrix, target);
        return findColumn(matrix, target, row);
    }

    private int findRow(int[][] matrix, int target) {
        int first = 0;
        int last = matrix.length;

        while ((first + 1) < last) {
            int middle = (first + last) / 2;

            if (matrix[middle][0] <= target) {
                first = middle;
            } else {
                last = middle;
            }
        }

        return first;
    }

    private boolean findColumn(int[][] matrix, int target, int row) {
        int first = 0;
        int last = matrix[row].length - 1;

        while (first <= last) {
            int middle = (first + last) / 2;

            if (matrix[row][middle] < target) {
                first = middle + 1;
            } else if (matrix[row][middle] > target) {
                last = middle - 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
