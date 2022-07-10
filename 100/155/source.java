import java.util.LinkedList;
import java.util.Stack;

class MinStack {
    private Stack<Integer> mStack = new Stack<>();
    private Stack<Integer> mMinValues = new Stack<>();
    private int mCurrentMin = Integer.MAX_VALUE;

    public MinStack() {
        mMinValues.push(mCurrentMin);
    }

    public void push(int val) {
        mStack.push(val);

        mCurrentMin = Math.min(mCurrentMin, val);
        mMinValues.push(mCurrentMin);
    }

    public void pop() {
        mStack.pop();

        mMinValues.pop();
        mCurrentMin = mMinValues.peek();
    }

    public int top() {
        return mStack.peek();
    }

    public int getMin() {
        return mMinValues.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */