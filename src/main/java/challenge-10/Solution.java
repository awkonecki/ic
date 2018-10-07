public class Solution {
    private static class LinkedListNode<T> {
        private T data;
        private LinkedListNode<T> next;

        public LinkedListNode(T data) {
            this.data = data;
        }
    }

    public static <T> LinkedListNode<T> insert(LinkedListNode<T> root, T data) {
        if (root == null) {
            return new LinkedListNode<T>(data);
        }

        LinkedListNode<T> node = root;
        LinkedListNode<T> prev = null;

        while (node != null) {
            prev = node;
            node = node.next;
        }

        prev.next = new LinkedListNode<T>(data);

        return root;
    }

    public static <T> LinkedListNode<T> reverseInPlace(LinkedListNode<T> root) {
        LinkedListNode<T> node = root;
        LinkedListNode<T> prev = null, next = null;

        while (node != null) {
            next = node.next;

            node.next = prev;
            prev = node;
            node = next;
        }

        return prev;
    }

    public static <T> LinkedListNode<T> reverseWithoutModification(LinkedListNode<T> root) {
        LinkedListNode<T> node = root;
        LinkedListNode<T> newNode = null, prev = null, next = null;

        while (node != null) {
            newNode = new LinkedListNode<T>(node.data);

            newNode.next = prev;
            prev = newNode;

            node = node.next;
        }

        return prev;
    }

    public static void main(String [] args) {
        LinkedListNode<Integer> root = null;
        root = insert(null, 1);
        root = insert(root, 2);
        root = insert(root, 3);
        root = insert(root, 4);
        root = insert(root, 5);

        LinkedListNode<Integer> reversedCopy = reverseWithoutModification(root);
        reversedCopy = reverseInPlace(reversedCopy);

        while (root != null && reversedCopy != null) {
            assert (root.data == reversedCopy.data);
            root = root.next;
            reversedCopy = reversedCopy.next;
        }

        assert (root == null);
        assert (reversedCopy == null);
    }
}