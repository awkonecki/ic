# Challenge 20 - Queue using only Stacks
## Description
>
Using the stack data structure, implement a queue that fulfills the first in first out design principle.

## Assumptions
- you may use two stacks in any perfered manner.

## Labels
- Stack
- Queue
- Recursion

## References
- Interview Cake

## Considerations
### Consideration 1
- focus on the enqueue
- first stack is purely the input stack
- second stack is used as the output stack.  
- when the output stack is empty and a dequeue is issued, pop all teh values off the input stack and push onto the output stack.
- then pop off from the output stack to fulfill the dequeue operation.

### Consideration 2
- focus on the dequeue
- push new value into the empty stack
- pop all values from the other stack onto the stack with the new entry.
- swap pointers of the two stacks for enqueuing and dequeue operations.
