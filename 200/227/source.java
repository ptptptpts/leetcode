import java.util.Stack;

class Solution {
    public int calculate(String s) {
        Stack<Integer> integerStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();

        int currentInt = 0;
        for (int cursor = 0; cursor < s.length(); cursor++) {
            char c = s.charAt(cursor);

            if ((c >= '0') && (c <= '9')) {
                currentInt = (currentInt * 10) + (c - '0');
            } else if (c != ' ') {
                char currentOperator = s.charAt(cursor);
                integerStack.push(currentInt);

                if (!operatorStack.empty()) {
                    char previousOperator = operatorStack.peek();
                    if (previousOperator == '*') {
                        int op1 = integerStack.pop();
                        int op2 = integerStack.pop();
                        operatorStack.pop();
                        integerStack.push(op2 * op1);
                    } else if (previousOperator == '/') {
                        int op1 = integerStack.pop();
                        int op2 = integerStack.pop();
                        operatorStack.pop();
                        integerStack.push(op2 / op1);
                    }
                }

                currentInt = 0;
                operatorStack.push(currentOperator);
            }
        }
        integerStack.push(currentInt);

        if (!operatorStack.empty()) {
            char lastOp = operatorStack.peek();
            if ((lastOp == '*') || (lastOp == '/')) {
                char op = operatorStack.pop();
                int op1 = integerStack.pop();
                int op2 = integerStack.pop();
                if (op == '*') {
                    integerStack.push(op2 * op1);
                } else if (op == '/') {
                    integerStack.push(op2 / op1);
                }
            }
        }

        Stack<Integer> reverseIntegerStack = new Stack<>();
        while (!integerStack.empty()) {
            reverseIntegerStack.push(integerStack.pop());
        }
        Stack<Character> reverseOperatorStack  = new Stack<>();
        while (!operatorStack.empty()) {
            reverseOperatorStack.push(operatorStack.pop());
        }

        while (!reverseOperatorStack.empty()) {
            char op = reverseOperatorStack.pop();
            int op1 = reverseIntegerStack.pop();
            int op2 = reverseIntegerStack.pop();
            if (op == '*') {
                reverseIntegerStack.push(op1 * op2);
            } else if (op == '/') {
                reverseIntegerStack.push(op1 / op2);
            } else if (op == '+') {
                reverseIntegerStack.push(op1 + op2);
            } else if (op == '-') {
                reverseIntegerStack.push(op1 - op2);
            }
        }
        return reverseIntegerStack.pop();
    }

}
