class Solution {
    public int findDuplicate(int[] nums) {
        // Find a cycle from nums[0]
        int lazyCursor = nums[0];
        int fastCursor = nums[0];
        do {
            lazyCursor = nums[lazyCursor];
            fastCursor = nums[nums[fastCursor]];
        } while (lazyCursor != fastCursor);

        // Find a starting point of the cycle
        // d(l) = starting branch + distance last loop
        // d(f) = starting branch + loop * count(f) + distance last loop
        // d(f) = d(l) * 2
        // starting branch + loop * count(f) + distance last loop = (starting branch + distance last loop) * 2
        // starting branch + distance last loop = loop * count(f)
        // starting branch = loop * count(f) - distance last loop
        int startCursor = nums[0];
        while (lazyCursor != startCursor) {
            startCursor = nums[startCursor];
            lazyCursor = nums[lazyCursor];
        }

        return lazyCursor;
    }
}
