# Challenge 24 - Detect Cycle in Linked List
## Description
>
Given the head of a linked list determine if a cycle exists.

## Assumptions
- Assume that a cycle does not have to exist.
- if a cycle exists it does not have to go back to the head node.
- values of the linked list are not guaranteed to be unique.

## Labels
- Linked List
- Two Pointers

## References
- Interview Cake

## Considerations
### Consideration 1
- maintain a log of visited nodes, thus a hashset of the object can be used for this.
- just iterate through and if a node already exists within the list then there is a cycle.
- if it ever reaches the end, a null will be detected and no cycle exists.

### Consideration 2
- use of two pointers
  - fast
  - slow
- if a cycle exists then the fast will eventually catch up to the slow.
- if the fast reaches null, then no cycle exists.