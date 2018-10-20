# Challenge 22 - Contains Valid Matching Pairs
## Description
>
Given a string that contains brackets, braces and parenthesis determine if there is a valid set of opening and closing pairs.

## Assumptions
- assume given a string.
- assume that there can occur any set of characters
- valid if and only if the the occurrence of pairs is valid.
- if no pairs event exist it should be valid

## Labels
- Stack
- Recursion

## References
- Interview Cake

## Considerations
### Consideration 1
- keep a stack of the opening brace, bracket, parenthesis.
- when a close occurs then see if it matches the top of the stack, if  not return false since not valid.
- if it does match then pop off and continue.
- at the end the stack must be empty to be a valid set of pairs.
