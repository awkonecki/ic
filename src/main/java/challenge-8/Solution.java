import java.util.Stack;
import java.util.Queue;

public class Solution {
    private static class Node {
        private int value;
        private Node left, right;
    }

    public static int secondLargestValue(Node root) {
        Node node = root;
        Node prev = null;
        int result = 0;

        // Traverse to the right most (max element) in the BST.
        while (node != null && node.right != null) {
            prev = node;
            node = node.right;
        }

        Node inorderResult = kthLargestValueInOrder(root);
        Node postorderResult = kthLargestValuePostOrder(root);
        assert (inorderResult == postorderResult);

        // at right most node
        if (node.left == null) {
            if (prev == null) {
                throw new java.lang.ArgumentExceptionError("Tree is not large enough");
            }
            else {
                assert (prev == inorderResult);
                return prev.value;
            }
        }
        else {
            node = node.left;
            while (node != null && node.right) {
                node = node.right
            }

            assert (node == inorderResult);
            return node.value;
        }

        return -1;
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