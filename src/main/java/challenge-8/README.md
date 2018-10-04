# Challenge 8 - Find Second Largest Value
## Description
>
Given a BST, find the second largest value contained within the BST.

## Assumptions
- Assume the tree given is a proper BST.
- Assume that there are no duplicates.

## Labels
- Binary Search Tree

## References
- Interview Cake

## Considerations
### Consideration 1
- perform a full in-order traversal of the BST and keep a buffer of two.
- as the traversal occurs move data between the buffer based on the nodes being visited.
- when reached the end, then the 2nd largest value will be in the first buffer.
- requires full BST traversal O(N), O(H) for memory.

### Consideration 2
- leverage the fact that only need the exactly second largest
- traverse the BST to the largest node first, always go right while a right exists
- while traversing keep a reference to the parent.
- once at the largest value, if the largest values does not have a left child then return the parent reference.
- if a left does exist, then return the right most node of the left child.
