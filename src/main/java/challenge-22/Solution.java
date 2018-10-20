import java.util.Stack;

public class Solution {
    public static boolean isValid(String string) {
        Stack<Character> openStack = new Stack<>();

        if (string == null) {
            return true;
        }

        for (int i = 0; i < string.length(); i++) {
            char character = string.charAt(i);

            switch (character) {
                case '(':
                case '{':
                case '[':
                    openStack.push(character);
                    break;
                case ')':
                case '}':
                case ']':
                    if (isValid(openStack, character)) {
                        openStack.pop();
                    }
                    else {
                        return false;
                    }
                    break;
                default:
                    break;
            }

        }

        if (openStack.isEmpty()) {
            return true;
        }
        else {
            return false;
        }
    }

    private static boolean isValid(Stack<Character> openStack, char character) {
        if (openStack.isEmpty()) {
            return false;
        }

        switch (openStack.peek().charValue()) {
            case '(':
                return character == ')';
            case '{':
                return character == '}';
            case '[':
                return character == ']';
            default:
                return false;
        }
    }
}