class Solution {
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 1;
        }

        int[] tribonacciArray = new int[] {0, 1, 1, 0};
        int cursor = 2;

        for (int i = 3; i <= n; i++) {
            cursor = (cursor + 1) & 3;
            tribonacciArray[cursor] = tribonacciArray[0] + tribonacciArray[1]
                + tribonacciArray[2] + tribonacciArray[3]
                - tribonacciArray[cursor];
        }

        return tribonacciArray[cursor];
    }
}
