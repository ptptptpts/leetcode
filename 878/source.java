class Solution {
    public int romanToInt(String s) {
        int result = 0;

        for (int pos = 0; pos < s.length(); pos++) {
            switch(s.charAt(pos)) {
                case 'I':
                    result += 1;
                    break;

                case 'V':
                    result += convertRomanToInteger(10, 3, 5, result);
                    break;

                case 'X':
                    result += convertRomanToInteger(10, 8, 10, result);
                    break;

                case 'L':
                    result += convertRomanToInteger(100, 30, 50, result);
                    break;

                case 'C':
                    result += convertRomanToInteger(100, 80, 100, result);
                    break;

                case 'D':
                    result += convertRomanToInteger(1000, 300, 500, result);
                    break;

                case 'M':
                    result += convertRomanToInteger(1000, 800, 1000, result);
                    break;
            }
        }

        return result;
    }

    private int convertRomanToInteger(int base, int except, int common, int result) {
        if ((result % base) == (base / 10)) {
            return except;
        } else {
            return common;
        }
    }
}