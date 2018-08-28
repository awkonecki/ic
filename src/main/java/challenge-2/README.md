# Challenge 2 - Find duplicate number in array
## Description
>
Given an array of N + 1 integers that range from 1 to N, find the number that is a duplicate.

## Assumptions
- Assume that there exists only a single duplicate number.

## Labels
- Math

## Considerations
### Consideration 1
>
If want to waste memory could always use an array of length N + 1 and just indicate when a specific value is seen.  If the current index within the array is already populated then the index provides the duplicate and can return.
>
This is fairly wasteful of memory however.

### Consideration 2
>
Sum the values current index minus the number of witnessed.  Will need to add back N + 1.
>
Will likely still want a long to be associated in order in the case of two very large 32-bit integers for consideration as well. 