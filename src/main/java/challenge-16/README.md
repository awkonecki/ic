# Challenge 16 - Shortest Path (with equal weights)
## Description
>
Given a mapping of individuals to other individuals, determine the shortest path from one individual to another within the map.

## Assumptions
- it is possible that two individuals are not connected.
- an individual will not map to itself
- directionless based connections.

## Labels
- Graph

## References
- Interview Cake

## Considerations
### Consideration 1
- should be able to start at both the start and target individual.
- perform bfs of each.
- if one runs out of connections first then the two will never be connection, due to connections be directionless.
- just count the number of levels each minus 1, since the target level will be overlaped with both.
