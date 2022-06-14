# Accounts Merge

## Problem

Given a list of accounts where each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name, and the rest of the elements are emails representing emails of the account.

Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some common email to both accounts. Note that even if two accounts have the same name, they may belong to different people as people could have the same name. A person can have any number of accounts initially, but all of their accounts definitely have the same name.

After merging the accounts, return the accounts in the following format: the first element of each account is the name, and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.

## Input

A list of a list of Strings. The first element is a name, and the rest of elements are emails.

## Example

- Example 1:

>Input: accounts = [["John","johnsmith@mail.com","john_newyork@mail.com"],["John","johnsmith@mail.com","john00@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]  
Output: [["John","john00@mail.com","john_newyork@mail.com","johnsmith@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]  
Explanation:  
The first and second John's are the same person as they have the common email "johnsmith@mail.com".  
The third John and Mary are different people as none of their email addresses are used by other accounts.  
We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'],  
['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.  

- Example 2:

>Input: accounts = [["Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"],["Kevin","Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"],["Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co"],["Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"],["Fern","Fern5@m.co","Fern1@m.co","Fern0@m.co"]]  
Output: [["Ethan","Ethan0@m.co","Ethan4@m.co","Ethan5@m.co"],["Gabe","Gabe0@m.co","Gabe1@m.co","Gabe3@m.co"],["Hanzo","Hanzo0@m.co","Hanzo1@m.co","Hanzo3@m.co"],["Kevin","Kevin0@m.co","Kevin3@m.co","Kevin5@m.co"],["Fern","Fern0@m.co","Fern1@m.co","Fern5@m.co"]]

## Constraints

- 1 <= accounts.length <= 1000
- 2 <= accounts[i].length <= 10
- 1 <= accounts[i][j].length <= 30
- accounts[i][0] consists of English letters.
- accounts[i][j] (for j > 0) is a valid email.

## Output

A list of a list of Strings, the first element is a name, and the rest of elements are email in sorted order.

## Solution 1

First to find the same email, it will be good to use a HashMap to find a duplicated one.  
Next, we need to manage each account by an id because a name is not a unique key and also we can use email because they can have a same name but a different person.  
So, we need to manage each account by an id.  
Then, we can connect all the email to each id, and we save them to a HashMap by email as a key and id as a value.  
If we find any email from the HashMap, we can find an id of the previous one, and can merge a current account the previous one.  

But, we can assume some ids can have an email [a], and another one have an email [b], and the other one can have emails [a, b].  
In this case, we need to update all the ids as the same value. So, it will be better to update the previous ids as the current one.  

After searching all the accounts, we need to merge the emails on the same ids.  
And next, creating a list of Strings after sorting the list of emails.

n is a length of account, m is a length of accounts[i].length.
A time complexity is O(n * m) because we need to manage all the emails as its id.
A space complexity is O(n * m) because we need to save all the emails in a HashMap.

- Time complexity: O(n * m)
- Space complexity: O(n * m)
