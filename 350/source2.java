import java.util.ArrayList;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        ArrayList<Integer> intersections = new ArrayList<>();
        int nums1Cursor = 0;
        int nums2Cursor = 0;
        while ((nums1Cursor < nums1.length)
            && (nums2Cursor < nums2.length)) {
            if (nums1[nums1Cursor] == nums2[nums2Cursor]) {
                intersections.add(nums1[nums1Cursor]);
                nums1Cursor++;
                nums2Cursor++;
            } else if (nums1[nums1Cursor] > nums2[nums2Cursor]) {
                nums2Cursor++;
            } else {
                nums1Cursor++;
            }
        } 

        int[] ret = new int[intersections.size()];
        for (int pos = 0; pos < intersections.size(); pos++) {
            ret[pos] = intersections.get(pos);
        }
        return ret;
    }
}
