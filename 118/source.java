import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalTriangle = new ArrayList<>(numRows);

        List<Integer> firstTriangle = new ArrayList<>(1);
        firstTriangle.add(1);
        pascalTriangle.add(firstTriangle);

        for (int i = 1; i < numRows; i++) {
            List<Integer> previousTriangle = pascalTriangle.get(i - 1);
            List<Integer> currentTriangle = new ArrayList<>(i + 1);

            currentTriangle.add(1);
            for (int j = 1; j < previousTriangle.size(); j++) {
                currentTriangle.add(
                    previousTriangle.get(j - 1) + previousTriangle.get(j));
            }
            currentTriangle.add(1);

            pascalTriangle.add(currentTriangle);
        }

        return pascalTriangle;
    }
}
