# Challenge 5 - Array of Products Excluding Index
## Description
>
Given an array of integers, create an array that contains the product of all the numbers of the array minus the value of the current index of the array of integers.
>
Do not perform a division operator.

## Assumptions
- assume that the calculated value will fit within a 32-bit number
- mix of negative and positive values
- the occurrence of two zeros will result in the entire product array being zero.
- the occurrence of one zero will result in the product as normal for the index with a zero and all others will be zero.

## Labels
- Greedy
- Math

## Considerations
### Consideration 1
- Brute force can accomplish this by recomputing the product of each position minus the current index.
- This can be achieved with a nested set of `for` loops that when the two indices are equal not to perform the operation.
- Will result in a O(N^2) time

### Consideration 2
- Build a running forward and backward product.
>
```
INPUT : {1,2,3,4}
RESULT : {2*3*4, 1*3*4, 1*2*4, 1*2*3}
Forward Compute : {NA, 1, 1*2, 1*2*3}
Backward Compute : {2*3*4, 3*4, 4, NA}
```
- after the forward compute the final running product can be placed into the last index.
- after the backward compute the final running product can be placed into the first index.
- the forward direction provides the product of all numbers that occur before the current index
- the backward direction provides the product of all numbers that occur after the current index
- mulitple the two results together to achieve the desired output
- the expected run time performance will now only be limited to O(2*N) due to the two iterations of the loop.