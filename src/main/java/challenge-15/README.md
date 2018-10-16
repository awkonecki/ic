# Challenge 15 - Graph Coloring
## Description
>
Given an array of graph nodes and an array of supported colors, find a valid coloring of the graph.

## Assumptions
- two neighboring nodes can not have the same color.
- the maximum supported number of colors for a graph is equal to the maximum number of children a node has + 1.
- no node is allowed to be its own neighbor.
- not all nodes have the same number of children.

## Labels
- Graph

## References
- Interview Cake

## Considerations
### Consideration 1
- maintain a hash of neighbor colors as illegal colors.
- iterate through the list of total colors and on the first one that is not in the set assign it to the current node.
