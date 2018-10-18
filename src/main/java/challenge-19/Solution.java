import java.util.Stack;
import java.util.Comparator;

public class Solution {

    private static class MyStack <T extends Comparable<T>> {
        
        private static class StackNode<T extends Comparable<T>> {
            private T value;
            private T max;

            public StackNode(T value, T max) {
                this.value = value;
                this.max = max;
            }
        }

        private Stack<StackNode<T>> mStack = new Stack<StackNode<T>>();

        public void push(T value) {
            if (mStack.isEmpty()) {
                mStack.push(new StackNode<T>(value, value));
            }
            else {
                mStack.push(new StackNode<T>(value, value.compareTo(getMax()) > 0 ? value : getMax()));
            }
        }

        public T getMax() {
            if (mStack.isEmpty()) {
                throw new IllegalStateException();
            }
            else {
                return mStack.peek().max;
            }
        }

        public T pop() {
            if (mStack.isEmpty()) {
                throw new IllegalStateException();
            }
            else {
                return mStack.pop().value;
            }
        }
    }
}