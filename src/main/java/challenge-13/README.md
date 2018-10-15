# Challenge 13 - 7 Sided Die
## Description
>
Given a 5 sided die with equal probabilities for each side, generate a 7-sided die with each side having equal probabilities.

## Assumptions
- Assume that the 5 sided die is given to you and the random properties holds true.

## Labels
- Math

## References
- Interview Cake

## Considerations
### Consideration 1
- really want the % of each roll of 7 to be the same with the use of the roll of 5.
- build out the full graph of all the possibilities
- 25 cases total
- 2 cases that match to 1
- 2 cases that match to 2
- 2 caes that match to 3
- 2 cases that match to 4
- 2 cases that match to 5
- 2 cases that match to 6
- 2 cases that match to 7
- 11 cases that match to reroll.
- chance to roll a 7 is 2/14 not 2/25 since 11 result in rerolls.
