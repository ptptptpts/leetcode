class Solution {
    public int numDecodings(String s) {
        int[] results = new int[] {1, 1, 1};
        char[] stringCharArray = s.toCharArray();

        if (canDecodeOne(stringCharArray[0])) {
            results[2] = 1;

            for (int pos = 1; pos < stringCharArray.length; pos++) {
                results[0] = results[1];
                results[1] = results[2];

                boolean isDecodeOne = canDecodeOne(stringCharArray[pos]);
                boolean isDecodeTwo = canDecodeTwo(stringCharArray[pos-1], stringCharArray[pos]);

                if (isDecodeOne && isDecodeTwo) {
                    results[2] = results[0] + results[1];
                } else if (isDecodeOne) {
                    results[2] = results[1];
                } else if (isDecodeTwo) {
                    results[2] = results[0];
                } else {
                    return 0;
                }
            }

        } else {
            return 0;
        }

        return results[2];
    }

    public boolean canDecodeOne(char a) {
        if ((a >= '1') && (a <= '9')) {
            return true;
        } else {
            return false;
        }
    }

    public boolean canDecodeTwo(char a, char b) {
        if (a == '1') {
            return true;
        } else if (a == '2') {
            if ((b >= '0') && (b <= '6')) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
