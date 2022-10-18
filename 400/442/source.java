import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicatesList = new ArrayList<>();

        for (int num : nums) {
            int absoluteNum = Math.abs(num);
            if (nums[absoluteNum - 1] > 0) {
                nums[absoluteNum - 1] *= -1;
            } else {
                duplicatesList.add(absoluteNum);
            }
        }

        return duplicatesList;
    }
}
