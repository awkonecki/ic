import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

public class Solution {
    public static Set<String> getPermutations(String inputString) {

        // generate all permutations of the input string
        Set<String> result = new HashSet<String>();
        
        if (inputString == null || inputString.isEmpty()) {
            return new HashSet<>(Arrays.asList(""));
        }

        getPermutations(inputString.toCharArray(), inputString.length(), result, new StringBuilder(inputString.length()));

        return result;
    }

    private static void getPermutations(char [] characters, int lengthLeft, Set<String> result, StringBuilder sb) {
        if (lengthLeft == 0) {
            result.add(sb.toString());
            return;
        }
        
        sb.append('0');
        
        for (int index = 0; index < lengthLeft; index++) {
            char character = characters[index];
            // swap
            characters[index] = characters[lengthLeft - 1];
            
            // add to the buffer
            sb.setCharAt(sb.length() - 1, character);
            
            getPermutations(characters, lengthLeft - 1, result, sb);
            
            // swap back
            characters[index] = character;
        }
        
        sb.deleteCharAt(sb.length() - 1);
    }

    public static void main(String [] args) {

    }
}