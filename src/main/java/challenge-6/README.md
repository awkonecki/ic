# Challenge 6 - Rotation Index of Sorted Strings
## Description
>
Given an array of sorted strings that have been rotated determine the index in which represents the start of the list.

## Assumptions
- Unique values only

## Labels
- Binary Search

## Considerations
### Consideration 1
- Can implement a classic binary search.  
- Conditions for the rotation is that the words to the left are greater
- words to the right are greater

## Problem Issues
- The converging point for the solution is a bit odd, and is typically not how I normally implement binary search.
- The converge technique is being used for the base case definition.