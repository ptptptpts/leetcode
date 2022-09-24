import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> allSubsets = new ArrayList<>();
        allSubsets.add(new ArrayList<>());

        for (int num : nums) {
            List<List<Integer>> currentSubsets = new ArrayList<>();

            for (List<Integer> previousSubset : allSubsets) {
                List<Integer> newSubset = new ArrayList<>(previousSubset);
                newSubset.add(num);
                currentSubsets.add(newSubset);
            }

            allSubsets.addAll(currentSubsets);
        }

        return allSubsets;
    }
}
