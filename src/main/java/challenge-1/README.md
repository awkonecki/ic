# Challenge 1 - 2 Eggs N Floors
## Description
>
Given two eggs and an N floor building, determine the number of drops of eggs it takes to find the minimum floor of which an egg will drop.

## Assumptions
- Assume that both eggs will break when dropped from the same floor.

## Thoughts
- How to find the floor if only one egg is provided?  Well in this case would need to go through each floor one at a time from the bottom to the top, resulting in O(N) drops of the egg.

## Labels
- Math

## Considerations
### Consideration 1
>
It would be easy to just test every other floor with the first egg, and when it breaks test the floor below it with the second.
>
In the best case this will result in an N / 2 drops of the first egg and one drop of the second egg.  So given 100 floors in place of N this would result in a total number of drops of 51.
>
The negative with this is that the first egg is dropped considerably more than the second egg.

### Consideration 2
>
Drop egg based on dividing the drop space in half each time until reach the floor.  This would result in best case of O(lgN) drops of the first egg & one drop of the second egg.  However in the worse case in which the egg breaks on the first drop then have the entire first half that must be searched one at a time.  
>
The worse case matches the worse case of `Consideration 1`.

### Consideration 3
>
Try to move drops over to egg 2.  In this consideration let us do increments of 10.  Therefore if egg one breaks on the first the second egg will still need to be dropped floors 1 through 9.
>
floor 10 - 1 - 9
floor 20 - 2 - 9
floor 30 - 3 - 9
floor 40 - 4 - 9
floor 50 - 5 - 9
floor 60 - 6 - 9
floor 70 - 7 - 9
floor 80 - 8 - 9
floor 90 - 9 - 9
floor 100 - 10 - 9
>
max number of floor drops for both eggs is 19 (10 for the first egg 9 for the second egg) if the egg breaks on floor 100.

### Consideration 4
>
Instead of having the total number of drops increment by one, instead start at a higher floor count and then subtract by one until reach floor 100.  This means that when you reach floor 100 you are skipping only a single floor.
>
`n + (n - 1) + (n - 2) + ... + (2) + (1) = 100`
>
Above is an arithmetic series that is equal to the expression of `n * (n + 1) / 2 = 100`.
>
Breaking the problem down and get...
>
```
n^2 + n - 200 = 0

(-1 +- sqrt(1^2 - 4*1*(-200))) / 2 = 13.xxxx
```
>
If ceil the fraction then will result in 14.