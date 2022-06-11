# LRU Cache

## Problem

Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

- LRUCache(int capacity)  
  Initialize the LRU cache with positive size capacity.
- int get(int key)  
  Return the value of the key if the key exists, otherwise return -1.
- void put(int key, int value)  
  Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.

The functions get and put must each run in O(1) average time complexity.

## Input

Call LRUCache(), get(), and put()

## Example

## Constraints

- 1 <= capacity <= 3000
- 0 <= key <= 10^4
- 0 <= value <= 10^5
- At most 2 * 10^5 calls will be made to get and put.

## Output

Do a proper return of LRUCache(), get(), and put() in O(1) time complexity.

## Solution 1

Basically, we need to start think about how we manage a key and value. Because get() and put()
requires to do it in O(1) time, so we can implement it by array or HashMap. But, a range of key is
not too large, we can use an array. When get() is called, if a key of array has a -1, this key is
not exist, and we can return this value. And when put() is called, it is same that if a key of array
has a -1, this key is not exist, and we can save the given value in an element.

Next, we need to think about how we manage the previous access history. In this case, we need to
think about how we care a number of current elements, updating the previous history if we access to 
the same key again, and remove the last access item. First, about a number of current elements, it
does not decrease even if we update the same key again. So, we can think about it will increase if
a new key is inserted by put(). And, if a number of key is larger than a capacity, it will not
increase anymore. Next, about updating the history, we can use a doubly linked list to remove the
item from a middle of history and add it in front of a history. In additional, to find a node of
current key, we can use an array to save a node.

In conclusion, we need two arrays to save a value and history node. In get(), if we find a key is
not exist, we will return -1. If we find a key exist, we'll return a value and update the history
to move the current key to a top of a history. In put(), if we find a key is not exist, we will
update a current value and create a new node to push it to a top of a history. And if we already
have an enough nodes, we'll remove the oldest one by updating its value as -1 and remove its node
and update the new oldest one as the previous node. If we find a key exists, we'll update a value
and update its history to a top of a history.

A Time complexity is O(1), because we implement a get() and put() methods as O(1) cost.  
A space complexity is O(range of key), because we have two arrays to save a value and node of each
key.

- Time complexity: O(1)
- Space complexity: O(range of key)
