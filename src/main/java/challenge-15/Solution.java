import java.util.Optional;
import java.util.Set;
import java.util.HashSet;

public class Solution {
    private static class GraphNode {
        private String name;
        private Optional<String> color;
        private Set<GraphNode> neighbors;

        public Set<GraphNode> getNeighbors() {
            return this.neighbors;
        }

        public boolean hasColor() {
            return this.color.isPresent();
        }

        public String getColor() {
            if (this.color.isPresent()) {
                return this.color.get();
            }
            else {
                return null;
            }
        }

        public void setColor(String color) {
            this.color = Optional.ofNullable(color);
        }
    }

    public static void colorGraph(GraphNode [] graph, String [] colors) {
        for (GraphNode node : graph) {
            if (node != null) {
                if (node.getNeighbors().contains(node)) {
                    throw new java.lang.IllegalArgumentException("Graph can not be its own neighbor.");
                }

                // Build the set of illegal colors.
                Set<String> illegalColors = new HashSet<String>();
                for (GraphNode neighbor : node.getNeighbors()) {
                    if (neighbor != null) {
                        if (neighbor.hasColor()) {
                            illegalColors.add(neighbor.getColor());
                        }
                    }
                }

                // Assign the first valid color
                for (String color : colors) {
                    if (!illegalColors.contains(color)) {
                        node.setColor(color);
                        break;
                    }
                }
            }
        }
    }
}