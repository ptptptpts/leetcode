import java.util.List;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> prevRow = triangle.get(i - 1);
            List<Integer> currentRow = triangle.get(i);

            currentRow.set(0, currentRow.get(0) + prevRow.get(0));
            for (int j = 1; j < currentRow.size() - 1; j ++) {
                currentRow.set(j, currentRow.get(j) + Math.min(prevRow.get(j - 1), prevRow.get(j)));
            }
            currentRow.set(i, currentRow.get(i) + prevRow.get(i - 1));
        }

        List<Integer> lastRow = triangle.get(triangle.size() - 1);
        int ret = lastRow.get(0);
        for (int i = 1; i < lastRow.size(); i++) {
            if (ret > lastRow.get(i)) {
                ret = lastRow.get(i);
            }
        }
        return ret;
    }
}
