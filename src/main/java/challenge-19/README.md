# Challenge 19 - Largest Element in Stack
## Description
>
Using a stack data structure, write a method that is able to provide the current maximum that is contained within the stack.

## Assumptions
- assume calling the for the maximum does not remove the item from the stack.

## Labels
- Stack
- Recursion

## References
- Interview Cake

## Considerations
### Consideration 1
- use a classic stack structure
- save both the value to be pushed onto the stack in addition to the maximum value that is currently available.  
- if the new value is greater that the max then the new value will be the maximum, otherwise use the previous largest value.
