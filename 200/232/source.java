import java.util.Stack;

class MyQueue {
    private Stack<Integer> mFrontStack;
    private Stack<Integer> mReverseStack;

    public MyQueue() {
        mFrontStack = new Stack<>();
        mReverseStack = new Stack<>();
    }

    public void push(int x) {
        mFrontStack.push(x);
    }

    public int pop() {
        if (mReverseStack.isEmpty()) {
            buildReverseStack();
        }
        return mReverseStack.pop();
    }

    public int peek() {
        if (mReverseStack.isEmpty()) {
            buildReverseStack();
        }
        return mReverseStack.peek();
    }

    public boolean empty() {
        return mFrontStack.isEmpty() && mReverseStack.isEmpty();
    }

    private void buildReverseStack() {
        while (!mFrontStack.isEmpty()) {
            mReverseStack.push(mFrontStack.pop());
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */