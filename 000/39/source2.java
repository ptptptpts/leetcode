import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // Input: Integer array, and target number
        // Output: A list of a list of integer array that contains the target number by sum all integers
        // Finding all the combination of integers from the given integer array that can make the
        // target number by sum of all the integers in the list.
        // Any integer in the candidates can be used unlimited number of times, so the candidates
        // contains a unique integer.
        // The number of integers in the candidates? 1 <= n <= 30
        // The range of integers in the candidates? 1 <= n <= 200
        // The range of target integers? 1 <= n <= 500

        // To find all the combinations, we need to compare all the integers. And, if the current
        // sum is larger than the target, we can remove the previous integer from the list and find
        // a new combination with the next integer.

        List<List<Integer>> result = new LinkedList<>();

        Arrays.sort(candidates);
        for (int cursor = 0; cursor < candidates.length; cursor++) {
            LinkedList<Integer> currentList = new LinkedList<>();
            currentList.add(candidates[cursor]);
            findCombination(candidates, target, result, currentList, candidates[cursor], cursor);
        }

        return result;
    }

    private void findCombination(int[] candidates, int target, List<List<Integer>> result,
            LinkedList<Integer> currentList, int currentSum, int currentPos) {
        if (currentSum == target) {
            List<Integer> copiedList = new LinkedList<>(currentList);
            result.add(copiedList);
        } else if (currentSum < target){
            for (int cursor = currentPos; cursor < candidates.length; cursor++) {
                currentList.add(candidates[cursor]);
                findCombination(candidates, target, result, currentList,
                        currentSum + candidates[cursor], cursor);
                currentList.removeLast();
            }
        }
    }
}
