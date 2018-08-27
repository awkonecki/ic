# Challenge 2 - Find duplicate number in array
## Description
>
Given an array of integers that range from 1 to N, find the number that is a duplicate.

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
Could sum all the values together and compare versus an expected calculated value.  So if there are N numbers then will have an expected sum of...
>
```
1 + 2 + 3 + ... + (n - 2) + (n - 1)
```
>
Once again this is a arithmetic series that can be represented by a total value of `n * (n + 1) / 2` where `n` is the length of the array.
>
Therefore can calculate the expected value and the real value.  In the case of the duplicate it means that a number must be gone.  So there are two cases now.
- 1. The case where the number that is a duplicate is less than the number it replaced.
- 2. the case where the number that is a duplicate is more than the number it replaced.
>
In the case in which the duplicate is less, this means the total sum will be less than the expected by the difference `expected = replaced - duplicate + sum`.
>
```
expected - sum = replaced - duplicate
(expected^2 - sum^2) = (replaced^2 - duplicate^2)

expected - sum + duplicate = replaced
(expected^2 - sum^2) = ((expected - sum + duplicate)^2 - duplicate^2)
(expected^2 - sum^2) = ((difference + x)^2 - x^2) = difference^2 + x^2 + 2*diff*x - x^2
(expected^2 - sum^2) = difference^2 + 2*difference*x
((expected^2 - sum^2) - difference^2) / (2*difference) = x
```
>
In the case where the number that is the duplicate is more than the number it replaced.
>
```
sum - expected = duplicate - replaced
(sum^2 - expected^2) = (duplicate^2 - replaced^2)

expected - sum + duplicate = replaced
(sum^2 - expected^2) = (duplicate^2 - (expected - sum + duplicate)^2)
(sum^2 - expected^2) = (x^2 - (diff + x)^2) = (x^2 - (diff^2 + x^2 + 2*diff*x))
(sum^2 - expected^2) = -diff^2 - 2*diff*x
((sum^2 - expected^2) + difference^2) / (-2*difference) = x
```