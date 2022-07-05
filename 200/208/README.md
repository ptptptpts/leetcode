# Implement Trie (Prefix Tree)

## Problem

A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.

Implement the Trie class:

- `Trie()` Initializes the trie object.
- `void insert(String word)` Inserts the string word into the trie.
- `boolean search(String word)` Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
- `boolean startsWith(String prefix)` Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.

## Input

Depends on each method

## Example

- Example 1:

>Input  
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]  
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]  
Output  
[null, null, true, false, true, null, true]  
>
>Explanation  
Trie trie = new Trie();  
trie.insert("apple");  
trie.search("apple");   // return True  
trie.search("app");     // return False  
trie.startsWith("app"); // return True  
trie.insert("app");  
trie.search("app");     // return True  

## Constraints

- 1 <= word.length, prefix.length <= 2000
- word and prefix consist only of lowercase English letters.
- At most 3 * 10^4 calls in total will be made to insert, search, and startsWith.

## Output

Depends on each method

## Solution 1

Basically, trie is almost same with a tree, but it saves its children
as a list. For example, this trie can save 26 children for each english
characters. But, this trie will make a child even if it does not have
any insert for the specific String, because it makes a child for each
next character. For example, if `apple` is inserted, this trie will make
a trie like `a -> p -> p -> l -> e`. So, we need to check this character
is valid or not on each node.  

About insert, we can traverse a trie and make a new node if it is not
exist, and we can mark the last character of the given string as a valid
data.

About search, we can traverse a trie and return false if we meet a null
node. Or, even if we find the string from the trie, we can return false
if it is not valid.  

About startsWith, it is similar with a search, but we will return true
even if the string is found and not valid.

A time complexity is O(n) because any insert and search is depends on a
length of word and prefix.  
A space complexity is O(n) because we create a node for each character
of the given string at insert() method.

- Time complexity: O(n)
- Space complexity: O(n)
