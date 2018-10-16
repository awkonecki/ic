# Challenge 14 - Circular Array Single Cycle
## Description
>
Given an array of integers, determine if there exists a single complete cycle.

## Assumptions
- the value at each index indicates the next relative index to traverse to.
- a single cycle is that all indices within the array are touched once.

## Labels
- Array
- Graph
- HashSet

## References
- Interview Cake

## Considerations
### Consideration 1
- keep track of all the indices that are visited in a set.
- iterate for only the total number of elements within the list.
- at the end, check to see if the total number of indices visited is equal to the length.

### Consideration 2
- instead of keeping track of a set of indices that been visited, just determine if at the end if returned to the same index that was started at.
- during the looping, need to see if the starting index is returned to early, if so break out.
- if the total count of indices visited and the final index is the original then return true, else false.
