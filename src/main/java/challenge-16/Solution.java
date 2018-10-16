import java.util.HashSet;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Stack;

public class Solution {
    
    public static List<List<String>> getShortestPaths(HashMap<String, String[]> network, String start, String end) {
        List<List<String>> paths = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        Stack<String> branches = new Stack<String>();
        List<String> currentPath = new LinkedList<String>();
        int minHops = network.size() + 1;

        branches.add(start);

        // make sure the start / end node is present
        if (!network.containsKey(start) || !network.containsKey(end)) {
            throw new java.lang.IllegalArgumentException("Start / end node not present in network.");
        }

        // DFS traversal
        while (!branches.isEmpty()) {
            String person = branches.pop();
            
            if (person != null && !visited.contains(person)) {
                // visit the person
                visited.add(person);
                currentPath.add(person);

                // put person back on the stack
                branches.push(person);

                // see if the person is the target
                if (person.equals(end)) {
                    if (currentPath.size() < minHops) {
                        paths.clear();
                        minHops = currentPath.size();
                        paths.add(new LinkedList<String>(currentPath));
                    }
                    else if (currentPath.size() == minHops) {
                        paths.add(new LinkedList<String>(currentPath));
                    }
                }
                else {
                    String [] peopleToVisit = network.getOrDefault(person, new String [0]);
                    for (String personToVisit : peopleToVisit) {
                        // iterate through each person to visit
                        if (!visited.contains(personToVisit)) {
                            branches.push(personToVisit);
                        }
                    }
                }
            }
            else if (visited.contains(person)) {
                // remove the last path.
                currentPath.remove(currentPath.size() - 1);
                // remove from the visited
                visited.remove(person);
            }
        }

        return paths;
    }
    
    public static void main(String [] args) {
        HashMap<String, String[]> network = new HashMap<String, String[]>() {{
            put("Min",     new String[] { "William", "Jayden", "Omar" });
            put("William", new String[] { "Min", "Noam" });
            put("Jayden",  new String[] { "Min", "Amelia", "Ren", "Noam" });
            put("Ren",     new String[] { "Jayden", "Omar" });
            put("Amelia",  new String[] { "Jayden", "Adam", "Miguel" });
            put("Adam",    new String[] { "Amelia", "Miguel", "Sofia", "Lucas" });
            put("Miguel",  new String[] { "Amelia", "Adam", "Liam", "Nathan" });
            put("Noam",    new String[] { "Nathan", "Jayden", "William" });
            put("Omar",    new String[] { "Ren", "Min", "Scott" });
        }};

        for (List<String> path : getShortestPaths(network, "Jayden", "Adam")) {
            for (String personInPath : path) {
                System.out.print(personInPath + " ");
            }
            System.out.println("");
        }
    }
}