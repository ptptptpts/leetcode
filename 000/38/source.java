class Solution {
    public String countAndSay(int n) {
        String countAndSayString = "";

        if (n == 1) {
            countAndSayString = "1";
        } else if (n > 1) {
            String prevCountAndSayString = countAndSay(n - 1);

            StringBuilder countAndSaySb = new StringBuilder("");
            int prevDigit = prevCountAndSayString.charAt(0) - '0';
            int prevDigitCount = 1;
            for (int pos = 1; pos < prevCountAndSayString.length(); pos++) {
                int curDigit = prevCountAndSayString.charAt(pos) - '0';

                if (curDigit != prevDigit) {
                    countAndSaySb.append(prevDigitCount);
                    countAndSaySb.append(prevDigit);

                    prevDigit = curDigit;
                    prevDigitCount = 1;
                } else {
                    prevDigitCount++;
                }
            }
            countAndSaySb.append(prevDigitCount);
            countAndSaySb.append(prevDigit);

            countAndSayString = countAndSaySb.toString();
        }

        return countAndSayString;
    }
}
