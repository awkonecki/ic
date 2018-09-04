# Challenge 7 - 
## Description
>
Given an array of integers of size N + 1, such that all the values are between 1 and N, find a duplicate.

## Assumptions
- there can be multiple duplicates
- a duplicate can occur more than two times
- can return any number that is a duplicate, occurs more than once within the array.

## Labels
- Binary Search
- Graph

## References
- Find Duplicate, Space Edition(TM) BEAST MODE
- Find Duplicate, Space Edition 

## Considerations
### Consideration 1
- if modification is possible can just swap values based on the value within the array as the target location.
- keep doing until a duplicate is found
- might cause some entries being examined twice but will eventually find a duplicate pair when the target location already is set to its index value.

### Consideration 2
- no modification
- can use binary search implementation where you are pairing down the indices that are available not the numbers themselves.
- will have to iterate through the entire array for each level of breaking down the problem.
- so due to the binary search being O(lgN) each will perform a full inspection of the positions.

### Consideration 3
- no modification
- can use the knowledge that like in the first that the values can point to another location
- there will always be one spot in the array that will never have an input pointer to it.
- there will always be at least one circular graph that can be reached from the original
- can use the two pointer system of fast and slow to first get into the circular part
- can then use single iteration of both the (reset) fast and slow to find the head
- can determine the total size of the circular loop, and the element prior to the head will always be a duplicate because of the entry to the circular and the circular itself will have the same value, thus a guaranteed duplicate.
