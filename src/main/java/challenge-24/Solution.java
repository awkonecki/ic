import java.util.HashSet;
import java.util.Set;

public class Solution {
    private static class LinkedListNode {
        private int value;
        private LinkedListNode next;

        public LinkedListNode (int value) {
            this.value = value;
        }
    }

    public static boolean containsCycle(LinkedListNode head) {
        assert (containsCycleConstantMemory(head) == containsCycleSet(head));

        return containsCycleConstantMemory(head);
    }

    private static boolean containsCycleSet(LinkedListNode head) {
        Set<LinkedListNode> visited = new HashSet<>();
        LinkedListNode node = head;

        while (node != null) {
            if (visited.contains(node)) {
                visited.clear();
                return true;
            }
            visited.add(node);
            node = node.next;
        }   
        
        return false;
    }

    // Two Pointer Solution
    private static boolean containsCycleConstantMemory(LinkedListNode head) {
        LinkedListNode slow = head, fast = head;
        
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            
            if (fast == slow) {
                return true;
            }
        }

        return false;
    }
}