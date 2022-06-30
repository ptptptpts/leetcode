import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    /*
    First, we need to sort the given candidates array as ascending order.
Next, we can start to build a current combination from the smallest candidate.
Next, we can select a next number from the current item.
If the sum is smaller than the target, we can repeat to add a candidate again.
If the sum is same with the target, we can add it to the combinations and pop the top of a stack.
If the sum is larger than the target, we can pop the two top items and add a next candidate.
Repeat this thing until we search all the candidates, we can find all the candidates without any duplicates
because we always add a new candidate same or larger with a current item.
     */

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> output = new LinkedList<>();

        for (int pos = 0; pos < candidates.length; pos++) {
            LinkedList<Integer> stack = new LinkedList<>();
            stack.add(candidates[pos]);
            findSum(candidates, target, pos, output, stack, candidates[pos]);
        }

        return output;
    }

    private void findSum(int[] candidates, int target, int pos, List<List<Integer>> output,
            LinkedList<Integer> currentStack, int currentSum) {
        if (currentSum < target) {
            for (int newPos = pos; newPos < candidates.length; newPos++) {
                currentStack.add(candidates[newPos]);
                findSum(candidates, target, newPos, output, currentStack,
                        currentSum + candidates[newPos]);
                currentStack.removeLast();
            }

        } else if (currentSum == target) {
            output.add(new LinkedList<>(currentStack));
        }
    }
}
