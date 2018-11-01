public class Solution {

    private static class LinkedListNode {
        private int value;
        private LinkedListNode next;

        public LinkedListNode (int value) {
            this.value = value;
        }
    }

    public static void deleteNode(LinkedListNode nodeToDelete) {
        if (nodeToDelete == null) {
            // Do no work.
            return;
        }
        
        LinkedListNode next = nodeToDelete.next;
        
        if (next != null) {
            nodeToDelete.value = next.value;
            nodeToDelete.next = next.next;
            next.next = null;
        }
        else {
            // last node in the list, invalid work to perform for dangling reference.
            throw new java.lang.IllegalStateException("Invalid state.");
        }
    }
}