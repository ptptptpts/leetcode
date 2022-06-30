import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        Stack<Integer> kStack = new Stack<>();
        Stack<String> strStack = new Stack<>();

        int currentK = 0;
        StringBuilder currentString = new StringBuilder("");

        for (int pos = 0; pos < s.length(); pos++) {
            char c = s.charAt(pos);

            if (Character.isDigit(c)) {
                if (currentString != null) {
                    strStack.push(currentString.toString());
                    currentString = null;
                }
                currentK = (currentK * 10) + (c - '0');
            } else if (Character.isAlphabetic(c)) {
                currentString.append(c);
            } else if (c == '[') {
                kStack.push(currentK);
                currentK = 0;
                currentString = new StringBuilder("");
            } else if (c == ']') {
                String repeatedString = currentString.toString().repeat(kStack.pop());
                String topString = strStack.pop();
                currentString = new StringBuilder(topString + repeatedString);
            }
        }

        return currentString.toString();
    }
}