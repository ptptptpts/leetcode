class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }

        char previousChar = s.charAt(0);
        int[] decodingWays = new int[] {1, 1};
        for (int pos = 1; pos < s.length(); pos++) {
            char currentChar = s.charAt(pos);
            int currentDecodingWays = 0;
            
            if (currentChar == '0') {
                if ((previousChar == '1') || (previousChar == '2')) {
                    currentDecodingWays = decodingWays[0];
                } else {
                    return 0;
                }
            } else {
                currentDecodingWays = decodingWays[1];
                if ((previousChar == '1') || (previousChar == '2')) {
                    int decodeTwoDigit = (previousChar - '0') * 10 + (currentChar - '0');
                    if (decodeTwoDigit <= 26) {
                        currentDecodingWays += decodingWays[0];
                    }
                }
            }

            previousChar = currentChar;
            decodingWays[0] = decodingWays[1];
            decodingWays[1] = currentDecodingWays;
        }

        return decodingWays[1];
    }
}