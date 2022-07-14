# Insert Delete GetRandom O(1)

## Problem

Implement the RandomizedSet class:

- `RandomizedSet()` Initializes the RandomizedSet object.
- `bool insert(int val)` Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
- `bool remove(int val)` Removes an item val from the set if present. Returns true if the item was present, false otherwise.
- `int getRandom()` Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.

You must implement the functions of the class such that each function works in average O(1) time complexity.

## Input

Depends on each method

## Example

- Example 1:

>Input  
["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]  
[[], [1], [2], [2], [], [1], [2], []]  
Output  
[null, true, false, true, 2, true, false, 2]  
>  
>Explanation  
RandomizedSet randomizedSet = new RandomizedSet();  
randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.  
randomizedSet.remove(2); // Returns false as 2 does not exist in the set.  
randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].  
randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.  
randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now contains [2].  
randomizedSet.insert(2); // 2 was already in the set, so return false.  
randomizedSet.getRandom(); // Since 2 is the only number in the set, getRandom() will always return 2.  

## Constraints

- -2^31 <= val <= 2^31 - 1
- At most 2 * 10^5 calls will be made to insert, remove, and getRandom.
- There will be at least one element in the data structure when getRandom is called.

## Output

Depends on each method

## Solution 1

Basically, insert() and remove() can be made by a set in O(1) cost, and
a problem is how we manage a data structure for a getRandom() method and
manage it in insert() and remove() methods.

To implement a getRandom() method, we can save all the elements in the
integer array and select on element from there. But, when we remove or
insert an item to a RandomizedSet, we need to manage this integer array.
For example, if insert() is called, we need to insert a value if it is
not exist in a RandomizedSet. If remove() is called, we need to remove
a value from the array in O(1) cost. So, we need to manage a position of
each value with it in the Set, and find a position of the element in O(1)
cost by using it. Next, if we remove any value from the RandomizedSet, we
can remove a value from the Set and Array in O(1) cost by saving a
position in the array with a value, and move the last element in the
array to an empty position mady by removing a value in remove() method.

A time complexity is O(1) in each method, because we use a HashSet to
save or remove a new value. Also, we save an element to an array to
select a random element in getRandom() method. To find an element from
the array in O(1) cost, we'll manage each element with a position in the
array.  
A space complexity is O(n) because we save all the elements in the
HashSet and array. 

- Time complexity: O(1)
- Space complexity: O(n)
