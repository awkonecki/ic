# Challenge 23 - Delete Node from Linked List
## Description
>
Given a node within a linked list delete it.

## Assumptions
- assume that the given node is the node that needs to be deleted.
- allow for data modification
- special handling for last node.

## Labels
- Linked List

## References
- Interview Cake

## Considerations
### Consideration 1
- if the provided node is null just return since no work.
- if the node to be deleted is the tail, then can not delete without having dangling references.
  - therefore for a tail node throw an error
- otherwise it is not a tail node, thus look at the next node's contents and move it to the node to be deleted.
- then remove the next node from the linked list instead.
