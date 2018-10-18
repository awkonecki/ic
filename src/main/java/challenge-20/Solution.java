import java.util.Stack;

public class Solution {

    private class FastEnqueueQueue {
        private Stack<Integer> inputStack = new Stack<>();
        private Stack<Integer> outputStack = new Stack<>();

        public void enqueue(int value) {
            inputStack.push(value);
        }

        public int dequeue() {
            if (inputStack.isEmpty() && outputStack.isEmpty()) {
                throw new java.lang.IllegalStateException();
            }
            else if (!outputStack.isEmpty()) {
                return outputStack.pop();
            }
            else {
                while (!inputStack.isEmpty()) {
                    outputStack.push(inputStack.pop());
                }

                return outputStack.pop();
            }
        }
    }

    private class FastDequeueQueue {
        private Stack<Integer> inputStack = new Stack<>();
        private Stack<Integer> outputStack = new Stack<>();

        public void enqueue(int value) {
            inputStack.push(value);

            while (!outputStack.isEmpty()) {
                inputStack.push(outputStack.pop());
            }

            Stack<Integer> temp = inputStack;
            inputStack = outputStack;
            outputStack = temp;
        }

        public int dequeue() {
            if (outputStack.isEmpty()) {
                throw new java.lang.IllegalStateException();
            }
            else {
                return outputStack.pop();
            }
        }
    }

}