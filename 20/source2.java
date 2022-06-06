import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        // Input: String s contains just the characters (),{},[]
        // Output: True if parentheses is valid

        // Open brackets must be closed by the same type of brackets
        // Brackets should be closed in the same order

        // About a open bracket, we need to save them in order and need to find the last open bracket.
        // So, we can save them in the stack and remove them if it meet the same type of close bracket.

        // About a close bracket, we can compare it with the last open bracket in the stack.
        // If it is not the same bracket or the stack is empty it is not valid.

        // And, if the stack is not empty when we search the string to the end, this string is invalid because it has not matched open bracket.

        boolean ret = true;
        Stack<Character> openBracketStack = new Stack<>();

        for (int pos = 0; pos < s.length(); pos++) {
            char c = s.charAt(pos);
            if ((c == '(') || (c == '{') || (c == '[')) {
                openBracketStack.push(c);
            } else if (c == ')') {
                if (openBracketStack.isEmpty() || (openBracketStack.pop() != '(')) {
                    ret = false;
                    break;
                }
            } else if (c == '}') {
                if (openBracketStack.isEmpty() || openBracketStack.pop() != '{') {
                    ret = false;
                    break;
                }
            } else if (c == ']') {
                if (openBracketStack.isEmpty() || openBracketStack.pop() != '[') {
                    ret = false;
                    break;
                }
            }
        }
        if (!openBracketStack.isEmpty()) {
            ret = false;
        }

        return ret;
    }
}