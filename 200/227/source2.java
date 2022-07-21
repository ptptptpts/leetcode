import java.util.Stack;

class Solution {
    public int calculate(String s) {
        Stack<Integer> integerStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();

        int cursor = 0;
        int currentInt = 0;
        boolean readInteger = true;
        while (cursor < s.length()) {
            if (readInteger) {
                cursor = findInteger(s, integerStack, cursor);

                if (!operatorStack.empty()) {
                    char op = operatorStack.peek();
                    if (op == '*') {
                        operatorStack.pop();
                        int op2 = integerStack.pop();
                        int op1 = integerStack.pop();
                        integerStack.push(op1 * op2);
                    } else if (op == '/') {
                        operatorStack.pop();
                        int op2 = integerStack.pop();
                        int op1 = integerStack.pop();
                        integerStack.push(op1 / op2);
                    }
                }

                readInteger = false;
            } else {
                char op = s.charAt(cursor);

                if ((op == '+') || (op == '-')) {
                    if (!operatorStack.empty()) {
                        char prevOp = operatorStack.pop();
                        int op2 = integerStack.pop();
                        int op1 = integerStack.pop();
                        switch (prevOp) {
                            case '+' -> integerStack.push(op1 + op2);
                            case '-' -> integerStack.push(op1 - op2);
                        }
                    }
                }
                operatorStack.push(op);

                readInteger = true;
                cursor++;
            }
        }

        if (!operatorStack.empty()) {
            char op = operatorStack.pop();
            int op2 = integerStack.pop();
            int op1 = integerStack.pop();
            if (op == '+') {
                integerStack.push(op1 + op2);
            } else {
                integerStack.push(op1 - op2);
            }
        }

        return integerStack.pop();
    }

    private int findInteger(String s, Stack<Integer> integerStack, int cursor) {
        int currentInt = 0;

        while (cursor < s.length()) {
            char c = s.charAt(cursor);

            if ((c >= '0') && (c <= '9')) {
                currentInt = (currentInt * 10) + (c - '0');
            } else if (c != ' ') {
                break;
            }
            cursor++;
        }
        integerStack.push(currentInt);

        return cursor;
    }
}
