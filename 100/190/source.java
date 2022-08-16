public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int reverseN = 0;

        for (int i = 0; i < 32; i++) {
            int bit = n & 0b1;
            reverseN = (reverseN << 1) | bit;
            n = n >> 1;
        }

        return reverseN;
    }
}
