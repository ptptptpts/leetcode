import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> subs = new ArrayList<>();

        subs.add(nums[0]);
        for (int num : nums) {
            int pos = Collections.binarySearch(subs, num);

            if (pos < 0) {
                pos = (pos * -1) - 1;
                if (pos < subs.size()) {
                    subs.set(pos, num);
                } else {
                    subs.add(num);
                }
            }
        }

        return subs.size();
    }
}
