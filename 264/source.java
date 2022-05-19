import java.util.HashSet;

class Solution {
    public int nthUglyNumber(int n) {
        HashSet<Double> uglyNumbers = new HashSet<>();
        int uglyNumber = 1;
        uglyNumbers.add((double)1);
        int uglyCounter = 1;

        double currentNumber = 2;
        while (uglyCounter < n) {
            if (uglyNumbers.contains(currentNumber / 2)
                || uglyNumbers.contains(currentNumber / 3)
                || uglyNumbers.contains(currentNumber / 5)) {
                uglyNumbers.add(currentNumber);
                uglyNumber = (int) currentNumber;
                uglyCounter += 1;
            }

            currentNumber += 1;
        }
        

        return uglyNumber;
    }
}
