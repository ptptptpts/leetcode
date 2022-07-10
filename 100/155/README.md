# Min Stack

## Problem

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

- MinStack() initializes the stack object.
- void push(int val) pushes the element val onto the stack.
- void pop() removes the element on the top of the stack.
- int top() gets the top element of the stack.
- int getMin() retrieves the minimum element in the stack.

You must implement a solution with O(1) time complexity for each function.

## Input

Depends on each method

## Example

- Example 1:

>Input  
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]  
>Output  
[null,null,null,null,-3,null,0,-2]
>Explanation  
MinStack minStack = new MinStack();  
minStack.push(-2);  
minStack.push(0);  
minStack.push(-3);  
minStack.getMin(); // return -3  
minStack.pop();  
minStack.top();    // return 0  
minStack.getMin(); // return -2  

## Constraints

- -2^31 <= val <= 2^31 - 1
- Methods pop, top and getMin operations will always be called on non-empty stacks.
- At most 3 * 10^4 calls will be made to push, pop, top, and getMin.

## Output

Depends on each method

## Solution 1

Basically, push, pop, and top is in O(1) constant cost if we use a linked
list for implementing a stack. But, getMin() method is the problem to
satisfy O(1) time complexity for each function.

This data structure is a stack, so only the top of a stack will be
changed. It means a minimum value at some elements in a stack is not
changed to the other one because all the values before that element
could not be changed. For example, a minimum value of each element in
a stack will be as the below.

Values|.|.|.|.|.
---|---|---|---|---|---
Stack|5|1|2|3|-1
Min|5|1|1|1|-1

If we add a new value `2` in a stack, all the minimum values before `2`
are not changed like the below.

Values|.|.|.|.|.|.
---|---|---|---|---|---|---
Stack|5|1|2|3|-1|2
Min|5|1|1|1|-1|-1

If we pop a value from a stack, all the minimum values do not changed
because the values before the top do not changed.

Values|.|.|.|.|.
---|---|---|---|---|---
Stack|5|1|2|3|-1
Min|5|1|1|1|-1

So, we can save the minimum value at each element as a stack.  

A time complexity is O(1) on each method because we just call a push,
pop, or peek on a stack.  
A space complexity is O(n) because we need to save an element on a stack
and min stack.

- Time complexity: O(1)
- Space complexity: O(n)
