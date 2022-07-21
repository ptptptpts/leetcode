import java.util.Stack;

class Solution {
    public int calculate(String s) {
        Stack<Integer> integerStack = new Stack<>();

        int currentInt = 0;
        char prevOp = '+';
        for (int cursor = 0; cursor < s.length(); cursor++) {
            char c = s.charAt(cursor);

            if (Character.isDigit(c)) {
                currentInt = (currentInt * 10) + (c - '0');
            } else if (c != ' ') {
                switch (prevOp) {
                    case '+' -> integerStack.push(currentInt);
                    case '-' -> integerStack.push(currentInt * -1);
                    case '*' -> integerStack.push(integerStack.pop() * currentInt);
                    case '/' -> integerStack.push(integerStack.pop() / currentInt);
                }
                prevOp = c;
                currentInt = 0;
            }
        }
        switch (prevOp) {
            case '+' -> integerStack.push(currentInt);
            case '-' -> integerStack.push(currentInt * -1);
            case '*' -> integerStack.push(integerStack.pop() * currentInt);
            case '/' -> integerStack.push(integerStack.pop() / currentInt);
        }

        int ret = 0;
        while (!integerStack.empty()) {
            ret += integerStack.pop();
        }
        return ret;
    }
}
