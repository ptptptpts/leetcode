class Solution {
    public boolean isPowerOfThree(int n) {
        int count = 0;
        int nDummy = n;

        if (n <= 0) {
            return false;
        }
        
        while (nDummy > 1) {
            count += 1;
            nDummy = nDummy / 3;
        }

        while (count > 0) {
            count -= 1;
            nDummy = nDummy * 3;
        }
        
        return n == nDummy;
    }
}