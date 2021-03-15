class Solution {
    private void move(int[] from, int[] to, int fromPos, int toPos) {
        to[toPos] = from[fromPos];
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        } else if (m == 0) {
            for (int i = 0; i < n; i++) {
                move(nums2, nums1, i, i);
            }
            return;
        }

        for (int i = 0; i < m; i++) {
            move(nums1, nums1, m - 1 - i, m + n - 1 - i);
        }

        int mergePos = 0;
        int nums1Pos = n;
        int nums2Pos = 0;

        while (true) {
            if (nums1[nums1Pos] < nums2[nums2Pos]) {
                move(nums1, nums1, nums1Pos++, mergePos++);
                if (nums1Pos == n+m) {
                    for (; nums2Pos < n; nums2Pos++) {
                        move(nums2, nums1, nums2Pos, mergePos++);
                    }
                    break;
                }
            } else {
                move(nums2, nums1, nums2Pos++, mergePos++);
                if (nums2Pos == n) {
                    for (; nums1Pos < n+m; nums1Pos++) {
                        move(nums1, nums1, nums1Pos, mergePos++);
                    }
                    break;
                }
            }
        }
    }
}