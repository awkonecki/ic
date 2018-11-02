public class Solution {
    private static class LinkedListNode {

        public int value;
        public LinkedListNode next;

        public LinkedListNode(int value) {
            this.value = value;
        }
    }

    public static LinkedListNode kthToLastNode(int k, LinkedListNode head) {

        if (k < 1 || head == null) {
            throw new java.lang.IllegalArgumentException("");
        }
        
        LinkedListNode slow = head, fast = head;
        
        while (fast != null && fast.next != null && k > 1) {
            k--;
            fast = fast.next;
        }
        
        if (fast == null || k != 1) {
            throw new java.lang.IllegalArgumentException("");
        }
        
        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}