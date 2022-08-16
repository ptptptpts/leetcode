class Solution {
    public int numDecodings(String s) {
        // Input: The string contains only digits
        // Output: A number of ways to decode it

        // We can encode an alphabet from 'a' to 'z' as 1 to 26.
        // For example, "ABC" can be encoded as 123.
        // However, 123 can be decoded by several ways like "A(1)B(2)C(3)", "L(12)C(3)", or "A(1)W(23)".
        // So, if the input string s as "123", a number of ways to decode it is 3.
        // In this problem "01" is different with "1", and a number starting with "0" is invalid.
        // So, we can't decode "01" as "A".

        // A length of the given string S? 1 <= n <= 100

        // The maximum number of encoded alphabet is 26. So, when we decode the number at the position
        // n, we don't need to care about the character at the position n-2. When we decode the
        // number at the position n, we can decode itself or decode it with the character at the
        // position n-1. If we assume a number of ways to decode at the position n as f(n), it can
        // be defined by "f(n) = f(n-1) + f(n-2)". f(n-1) means that we decode the character at the
        // position n as itself. And f(n-2) means that we decode the character at the position n
        // and n-1 together. However, we can decode the character with two digits only when it is
        // equal or smaller than 26, and it does not start with "0". So, we can convert the function
        // like this "f(n) = f(n-1) + f(n-2)(if 10 <= s[n-1]s[n] <= 26)". Next, we can't decode the
        // "0" itself, so the function will be like this.
        // "f(n) = f(n-1)(if s[n] != "0") + f(n-2)(if 10 <= s[n-1]s[n] <= 26)".

        // A time complexity is O(n) because we need to check all the characters in the string s.
        // A space complexity is O(1) because we need to save only the number of ways in the last
        // two positions.

        if (s.charAt(0) == '0') {
            return 0;
        }

        int[] numberOfDecodes = new int[] { 1, 1, 1 };

        for (int pos = 1; pos < s.length(); pos++) {
            int prevC = s.charAt(pos - 1) - '0';
            int c = s.charAt(pos) - '0';
            int twoDigits = prevC * 10 + c;

            if ((twoDigits <= 26) && (prevC > 0)) {
                if (c != 0) {
                    numberOfDecodes[2] = numberOfDecodes[0] + numberOfDecodes[1];
                } else {
                    numberOfDecodes[2] = numberOfDecodes[0];
                }
            } else {
                if (c != 0) {
                    numberOfDecodes[2] = numberOfDecodes[1];
                } else {
                    numberOfDecodes[2] = 0;
                }
            }

            numberOfDecodes[0] = numberOfDecodes[1];
            numberOfDecodes[1] = numberOfDecodes[2];
        }

        return numberOfDecodes[2];
    }
}
