# Cheapest Flights Within K Stops

## Problem

There are n cities connected by some number of flights. You are given an array flights where flights[i] = [from`i`, to`i`, price`i`] indicates that there is a flight from city from`i` to city to`i` with cost price`i`.

You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.

## Input

Two dimension integer array that contains a cost of flight from i to j, and source, destination, and k.

## Example

- Example 1:

>Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1  
Output: 700  
Explanation:  
The graph is shown above.  
The optimal path with at most 1 stop from city 0 to 3 is marked in red and has cost 100 + 600 = 700.  
Note that the path through cities [0,1,2,3] is cheaper but is invalid because it uses 2 stops.  

- Example 2:

>Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1  
Output: 200  
Explanation:  
The graph is shown above.  
The optimal path with at most 1 stop from city 0 to 2 is marked in red and has cost 100 + 100 = 200.  

- Example 3:

>Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 0  
Output: 500  
Explanation:  
The graph is shown above.  
The optimal path with no stops from city 0 to 2 is marked in red and has cost 500.  

## Constraints

- 1 <= n <= 100
- 0 <= flights.length <= (n * (n - 1) / 2)
- flights[i].length == 3
- 0 <= fromi, toi < n
- fromi != toi
- 1 <= pricei <= 10^4
- There will not be any multiple flights between two cities.
- 0 <= src, dst, k < n
- src != dst

## Output

The cheapest flight from a source to destination within the most k stops. If it is unavailable, return -1.

## Solution 1

Let's assume the value k is 0. In this case, the best price to go from any city to the
other city is defined as the prices in the given array. If we can stop one city more, we
can find a new best price by comparing a previous best price and a new price that can
make with one stop. We can repeat this until we meet the given value k, and we can find
the best price from a source to destination.

Let's check how we update the new best prices when we can stop at one more city.
Basically, we have a list of prices on one stop in the given array. And, if we save the
best prices from a city i to city j, we can find all the previous stops from this array
and calculate a cost of a new route by adding a price to the previous price. And, we can
update the new best price to a city k, if the previous price is -1 or higher than a new
price.

A time complexity is O(k * flights.length) because we need to update the best prices on
`k` times with the given flights.  
A space complexity is O(n^2) because we will save the best prices by a two dimension
array.

- Time complexity: O(k * flights.length)
- Space complexity: O(n^2)
