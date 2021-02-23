class Solution {
    public int[] generateDigits(int[] digits, int add) {
        int[] newDigits = new int[digits.length + add];

        for (int i = 0; i < digits.length; i++) {
            newDigits[i+add] = digits[i];
        }
        if (add == 1) {
            newDigits[0] = 1;
        }

        return newDigits;
    }

    public int[] plusOne(int[] digits) {
        int add = 1;
        for (int i = digits.length-1; i >= 0; i--) {
            digits[i]++;
            if (digits[i] == 10) {
                digits[i] = 0;
            } else {
                return digits;
            }
        }

        return generateDigits(digits, add);
    }
}