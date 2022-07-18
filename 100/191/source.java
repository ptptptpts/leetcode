public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        int bitfilter = 1;

        for (int i = 0; i < 32; i++) {
            if ((n & bitfilter) != 0) {
                count++;
            }
            bitfilter = bitfilter << 1;
        }

        return count;
    }
}