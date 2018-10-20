public class Solution {
    private static int getMatchingClosingIndex(String string, int index) {
        if (string == null || index < 0 || index >= string.length() || string.charAt(index) != '(') {
            return -1;
        }

        int openCount = 1;

        for (; index < string.length(); index++) {
            char character = string.charAt(index);

            if (character == '(') {
                openCount++;
            }
            else if (character == ')') {
                openCount--;
                if (openCount == 1) {
                    return index;
                }
            }
        }
        
        return -1;
    }
}