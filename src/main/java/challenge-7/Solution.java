public class Solution {

    public static int function(String [] words) {
        if (words[0].compareTo(words[words.length - 1]) <= 0) {
            return 0;
        }
        assert (recursive(words, 0, words.length - 1) == serial(words));
        return serial(words);    
    }

    private static int serial(String [] words) {
        int lowIndex = 0;
        int highIndex = words.length - 1;

        while (lowIndex < highIndex) {

            // guess a point halfway between floor and ceiling
            int index = (highIndex - lowIndex) / 2 + lowIndex;

            // if guess comes after first word or is the first word
            if (words[index].compareTo(words[0]) >= 0) {
                // go right
                lowIndex = index + 1;
            } else {
                // go left
                highIndex = index;
            }
        }

        return highIndex;
    }

    private static int recursive(String [] words, int lowIndex, int highIndex) {
        if (lowIndex < highIndex) {
            int index = (highIndex - lowIndex) / 2 + lowIndex;
            String word = words[index];

            if (words[0].compareTo(word) > 0) {
                highIndex = index;
            }
            else {
                // go right
                lowIndex = index + 1;
            }

            return recursive(words, lowIndex, highIndex);
        }
        else if (lowIndex == highIndex) {
            return highIndex;
        }
        else {
            return -1;
        }
    }
    
    public static void main(String [] args) {
        assert (function(new String[] {"a","b","c","d","e"}) == 0);
        assert (function(new String[] {"e","a","b","c","d"}) == 1);
        assert (function(new String[] {"d","e","a","b","c"}) == 2);
        assert (function(new String[] {"c","d","e","a","b"}) == 3);
        assert (function(new String[] {"b","c","d","e","a"}) == 4);
    }
}