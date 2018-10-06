# Challenge 9 - Cake Thief
## Description
>
Given an array of values and weights for cakes, determine the maximum value that a thief can steal in cake value with a defined weight limit.  

## Assumptions
- Assume that the number of cakes are limitless for each type.
- Assume that there is a limited number of types of cakes.
- Assume each cake has a non-negative weight and value.

## Labels
- Recursion
- Dynamic Programming
- Knap Sack

## References
- Interview Cake

## Considerations
### Consideration 1
- recursion problem that is both iteration based / non-iteration based.
- perform an include / not include and current amount of weight.
- will want to return the maximum value that can be had at the lightest weight.

### Consideration 2
- expect the problem to support dynamic programming, thus should be able to introduce cachine mechanisms within the recursion based problem.

### Consideration 3
- Following on the dynamic programming strategy, should now be able to implement a serial dynamic implementation.

### Consideration 4
- Expect to further reduce run-time performance in the memory space.
