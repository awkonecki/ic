# Challenge 25 - Reverse a Linked List
## Description
>
Given the head of a linked list reverse the order of the linked list nodes it contains.

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
- recursively iterate through the list until reach the end.
- return the node at the current level.
  - if the value returned from the previous level is null then the current node at the level is the tail.
  - save it to a global accessible reference to return from the function.
- prior to returning set the next of the current node to null.
- set the previous node that is returned next's to the current level's node.

### Consideration 2
- use of prev, next and current list node references in a serial fashion instead of a recursive.
- same modification of the next of prev's reference.