import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // Input: integer array
        // Output: List of triplets that make '0' by their sum. It does not contain any duplicate triplets.

        // What is a size of array? 0 <= n <= 3000
        // What is a range of integer? -10^5 <= n <= 10^5

        // We need to find a way to not find duplicate triplets. Then, we can select one integer
        // from the array and find the other two integers from the others. Next, after finding all
        // the integers, we can forget the integer we select first. Because the first integer is
        // removed from our next searching, it does not make any duplicate triplets.

        // Next, we need to find a way to find the other two integers. Basically, we can find all
        // the integers by O(n^2), but it is too heavy. But if the array is sorted, we can search
        // two integers that make the other integer by their sum with a two cursor. The one cursor
        // points a smaller value and the other one points a larger value. If their sum is larger
        // than the first integer, we can move a larger cursor to a smaller one. If their sum is
        // smaller than the first integer, we can move a smaller cursor to a larger one. With this
        // way we can find the two integers in O(n) because we traverse the array only once.

        // A time complexity of this solution is O(n^2) because a cost to find two integers is O(n)
        // and we need to repeat it on all the integers.
        // A space complexity of this solution is O(n^2) because if we select two integers, the
        // other one is defined as the others sum.

        if (nums.length < 3) {
            return new LinkedList<>();
        }

        List<List<Integer>> ret = new LinkedList<>();

        Arrays.sort(nums);
        for (int cursor = 0; cursor < nums.length - 1; cursor++) {
            int findVal = nums[cursor] * -1;
            int lowCursor = cursor + 1;
            int highCursor = nums.length - 1;

            while (lowCursor < highCursor) {
                int sum = nums[lowCursor] + nums[highCursor];

                if (sum == findVal) {
                    ret.add(Arrays.asList(nums[cursor], nums[lowCursor], nums[highCursor]));

                    while ((highCursor > 0) && (nums[highCursor - 1] == nums[highCursor])) {
                        highCursor -= 1;
                    }
                    while ((lowCursor < nums.length - 1) && (nums[lowCursor + 1] == nums[lowCursor])) {
                        lowCursor += 1;
                    }

                    highCursor -= 1;
                    lowCursor += 1;
                } else if (sum < findVal) {
                    lowCursor += 1;
                } else {
                    highCursor -= 1;
                }
            }

            while ((cursor < nums.length - 1) && (nums[cursor] == nums[cursor + 1])) {
                cursor += 1;
            }
        }

        return ret;
    }
}