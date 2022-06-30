import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> previousPascal;
        List<Integer> currentPascal = new ArrayList<Integer>(1);
        currentPascal.add(1);

        for (int i = 1; i <= rowIndex; i++) {
            previousPascal = currentPascal;
            currentPascal = new ArrayList<>(i + 1);

            currentPascal.add(1);
            for (int j = 1; j < previousPascal.size(); j++) {
                currentPascal.add(
                    previousPascal.get(j - 1) + previousPascal.get(j));
            }
            currentPascal.add(1);
        }

        return currentPascal;
    }
}
