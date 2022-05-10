class Solution {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        
        int[] waysArray = new int[]{1, 1, 0};
        int cursor = 1;

        for (int i = 2; i <= n; i++) {
            cursor = (cursor + 1) % 3;
            waysArray[cursor] = waysArray[0] + waysArray[1] 
                + waysArray[2] - waysArray[cursor];
        }

        return waysArray[cursor];
    }
}