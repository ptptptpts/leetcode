import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> integerStack = new Stack<>();

        for (String token : tokens) {
            if (token.equals("+")) {
                integerStack.push(integerStack.pop() + integerStack.pop());
            } else if (token.equals("-")) {
                int secondOp = integerStack.pop();
                int firstOp = integerStack.pop();
                integerStack.push(firstOp - secondOp);
            } else if (token.equals("*")) {
                integerStack.push(integerStack.pop() * integerStack.pop());
            } else if (token.equals("/")) {
                int secondOp = integerStack.pop();
                int firstOp = integerStack.pop();
                integerStack.push(firstOp / secondOp);
            } else {
                integerStack.push(Integer.parseInt(token));
            }
        }

        return integerStack.pop();
    }
}
