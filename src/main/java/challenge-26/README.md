# Challenge 26 - Kth Last Node
## Description
>
Given the head of a linked list, and an integer value k, find the kth node from the end of the list.

## Assumptions
- assume that the linked list is proper and terminates.
- no cycles
- assume it is a singly linked list.

## Labels
- Linked List
- Two Pointers

## References
- Interview Cake

## Considerations
### Consideration 1
- first need to see if the list is even capable of holding the kth node.
- iterate k - 1 nodes.
  - if hit null, then return null.
- then increment a new reference of the head and the current forward reference one by one until the next of the forward node is null.