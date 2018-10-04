import java.util.Stack;
import java.util.Queue;

public class Solution {
    private static class Node {
        private int value;
        private Node left, right;
    }

    public static int secondLargestValue(Node root) {
        
    }

    // Generalistic implementation for obtaining the kth largest in a generic
    // given BST, with an inorder.
    private static Node kthLargestValueInOrder(Node root, int k) {
        Node node = root;
        Stack<Node> nodesToVisit = new Stack<Node>();
        Queue<Node> kthLargest = new LinkedList<Node>();

        while (node != null || !nodesToVisit.isEmpty()) {
            if (node != null) {
                nodesToVisit.push(node);
                node = node.left;
            }
            else {
                node = nodesToVisit.pop();
                kthLargest.add(node);
                if (kthLargest.size() > k) {
                    kthLargest.remove();
                }
                node = node.right;
            }
        }

        if (kthLargest.size() < k) {
            return null;
        }
        else {
            return kthLargest.remove();
        }
    }

    // General post order for kth largest.  More efficient since going backwards
    // instead of foreward, only have to count not manage an additional data
    // structure.
    private static Node kthLargestValuePostOrder(Node root, int k) {
        Node node = root;
        Stack<Node> nodesToVisit = new Stack<Node>();
        int count = 0;
        
        while (node != null || !nodesToVisit.isEmpty()) {
            if (node != null) {
                nodesToVisit.push(node);
                node = node.right;
            }
            else {
                node = nodesToVisit.pop();
                count++;
                if (count == k) {
                    return node;
                }
                node = node.left;
            }
        }

        return null;
    }
}