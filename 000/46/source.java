import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            visited[i] = false;
        }

        List<List<Integer>> result = new LinkedList<>();
        findPermutation(nums, visited, result, new LinkedList<>());
        return result;
    }

    private void findPermutation(int[] nums, boolean[] visited, List<List<Integer>> result,
            LinkedList<Integer> currentPermutation) {
        for (int pos = 0; pos < nums.length; pos++) {
            if (!visited[pos]) {
                currentPermutation.add(nums[pos]);

                if (currentPermutation.size() == nums.length) {
                    result.add(new LinkedList<>(currentPermutation));
                    currentPermutation.removeLast();
                    return;
                } else {
                    visited[pos] = true;
                    findPermutation(nums, visited, result, currentPermutation);
                    visited[pos] = false;
                }

                currentPermutation.removeLast();
            }
        }
    }
}