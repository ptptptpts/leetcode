import java.util.LinkedList;

class Solution {
    public boolean isValid(String s) {
        boolean ret = true;

        LinkedList<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '(':
                case '{':
                case '[':
                    stack.push(c);
                    break;
                case ')':
                    if ((stack.size() > 0) && (stack.peek() == '(')) {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
                case '}':
                    if ((stack.size() > 0) && (stack.peek() == '{')) {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
                case ']':
                    if ((stack.size() > 0) && (stack.peek() == '[')) {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
            }
        }

        if (stack.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
}
