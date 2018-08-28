# Challenge 4 - Sorting Faster Than O(nlgn) with Hash-Table
## Description
>
Given an array of unsorted integers that are guaranteed to be in the range of 0 to a specific maximum, sort the list in less than O(nlgn) time.

## Assumptions
- assume that the minimum is not negative (0).
- assume that the maximum is reasonablly small.

## Labels
- HashMap

## Considerations
### Consideration 1
>
Kinda like dynamica programming approach where you provide index for each possible value within the possible set.  Then use the value within the supported set as the index into the memory that is responsible for counting the number of occurrences.