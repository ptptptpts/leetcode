import java.util.ArrayList;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] numCounter = new int[1001];
        for (int i = 0; i < numCounter.length; i++) {
            numCounter[i] = 0;
        }

        int[] smallNum;
        int[] largeNum;
        if (nums1.length < nums2.length) {
            smallNum = nums1;
            largeNum = nums2;
        } else {
            smallNum = nums2;
            largeNum = nums1;
        }

        for (int num : smallNum) {
            numCounter[num] += 1;
        }

        ArrayList<Integer> intersections = new ArrayList<>(nums1.length);
        for (int num : largeNum) {
            if (numCounter[num] > 0) {
                intersections.add(num);
                numCounter[num] -= 1;
            }
        }

        int[] ret = new int[intersections.size()];
        for (int pos = 0; pos < intersections.size(); pos++) {
            ret[pos] = intersections.get(pos);
        }
        return ret;
    }
}
