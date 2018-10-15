# Challenge 12 - Word Cloud
## Description
>
Given a long string, build the word cloud in the form of a hashmap that maintains the total number of occurrences for a given word.

## Assumptions
- Assume that the string is text from a book or article.

## Labels
- String
- HashMap

## References
- Interview Cake

## Considerations
### Consideration 1
- there are two aspects to this problem.
- how the keys are generated for the mapping of a word to a count.
- parsing of the words to generate the key.
- once the key is generated, then just increment the count associated with the word.
- at the end return the mapping of words to counts.
