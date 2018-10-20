# Challenge 21 - Matching Parenthesis Index
## Description
>
Given a string and an index that contains an opening parenthesis determine the matching closing parenthesis to the opening at the specified index.

## Assumptions
- assume given a string.
- assume that the provided index points to an opening parenthesis.
- there can be parenthesis prior to the one indicated at the index
- there can be parenthesis after the provided index.

## Labels
- Stack
- Recursion

## References
- Interview Cake

## Considerations
### Consideration 1
- ignore all elements prior the specified index.
- can just count the total number of open and closed parenthesis that occurs after
- once the open count is 0 and closed count is 1 then have found the index.
- the open parenthesis at the specified index is not included in the open count.
