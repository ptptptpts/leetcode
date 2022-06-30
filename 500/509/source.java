class Solution {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        
        int [] fibonacciArray = new int[] {0, 1, 0};
        int cursor = 1;

        for (int i = 2; i <= n; i++) {
            cursor = (cursor + 1) % 3;
            fibonacciArray[cursor] = fibonacciArray[0] + fibonacciArray[1] + fibonacciArray[2] - fibonacciArray[cursor];
        }

        return fibonacciArray[cursor];
    }
}