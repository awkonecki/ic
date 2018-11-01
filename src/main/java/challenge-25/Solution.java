import java.util.ArrayList;

public class Solution {
    public static class LinkedListNode {

        public int value;
        public LinkedListNode next;

        public LinkedListNode(int value) {
            this.value = value;
        }
    }

    public static LinkedListNode reverseSerial(LinkedListNode headOfList) {
        LinkedListNode node = headOfList;
        LinkedListNode prev = null;
        LinkedListNode next = null;
        
        while (node != null) {
            next = node.next;
            
            node.next = prev;
            prev = node;
            node = next;
        }

        return prev;
    }

    public static LinkedListNode reverse(LinkedListNode node) {
        ArrayList<LinkedListNode> newHead = new ArrayList<>(1);
        reverseRecursive(node, newHead);
        if (newHead.isEmpty()) {
            return null;
        }
        else {
            return newHead.get(0);
        }
    }

    private static LinkedListNode reverseRecursive(LinkedListNode node, ArrayList<LinkedListNode> newHead) {
        if (node == null) {
            return null;
        }
        else {
            LinkedListNode prev = reverseRecursive(node.next, newHead);
            node.next = null;
    
            if (prev == null) {
                // update global
                newHead.add(node);
            }
            else {
                prev.next = node;
            }

            return node;
        }
    }
}