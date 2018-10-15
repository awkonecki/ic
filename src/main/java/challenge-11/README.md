# Challenge 11 - Stock Market
## Description
>
Given an array of integers that represents the price of the stock, determine the max profit that could be made from one buy and one sale at the given prices.

## Assumptions
- assume that the total will not wrap around.

## Labels
- Greedy
- Array

## References
- Interview Cake

## Considerations
### Consideration 1
- brute force solution
- iterate at a pivot index as the buy price and then iterate through all other prices to keeping track of the maximum profit.

### Consideration 2
- Greedy approach
- keep an initial maxProfit of the first two prices along with the first price being the first buy price.
- start on the second argument and then first compare if the current index - the buy price is greater than the current max profit.  This is to say assume that we already know the purchase price is the lowest that we have already seen and we sell at this price, is it greater than the current max profit we have already seen.
- additionally after check to see if the current price is less than the buy price. if it is then make it the new buy price to fulfill the assumption in the point above.
