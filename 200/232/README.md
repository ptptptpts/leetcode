# Implement Queue using Stacks

## Problem

Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).

Implement the MyQueue class:

- void push(int x) Pushes element x to the back of the queue.
- int pop() Removes the element from the front of the queue and returns it.
- int peek() Returns the element at the front of the queue.
- boolean empty() Returns true if the queue is empty, false otherwise.

Notes:

- You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.
- Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.

## Input

Integer x only in push() function.

## Example

- Example 1:

>Input  
["MyQueue", "push", "push", "peek", "pop", "empty"]  
[[], [1], [2], [], [], []]  
Output  
[null, null, null, 1, 1, false]  
>
>Explanation  
MyQueue myQueue = new MyQueue();  
myQueue.push(1); // queue is: [1]  
myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)  
myQueue.peek(); // return 1  
myQueue.pop(); // return 1, queue is [2]  
myQueue.empty(); // return false  

## Constraints

- 1 <= x <= 9
- At most 100 calls will be made to push, pop, peek, and empty.
- All the calls to pop and peek are valid.

## Output

Depends on each function.

## Solution 1

A stack and queue push an item at the end of list, but a queue pop or 
peek an item at the front of the list. So, a queue has the items as a
reverse order of a stack.  

We can use one stack for pushing to the end, and the other one saves the
items as a reverse order to find the top of the queue. When a peek() or
pop() is called, we can use the 2nd stack to find the top of the queue.
If the 2nd stack is empty, we can make it by pop all the items from the
1st stack and push them to the 2nd stack as a reverse order. When an
empty() is called, we can return true if both stacks are empty.

A time complexity is O(n) because we need to convert all the nodes in 
the 1st stack to the 2nd stack in the worst case.  
A space complexity is O(n) because we need to save all the items in the
queue in the two stacks.

- Time complexity: O(n)
- Space complexity: O(n)
