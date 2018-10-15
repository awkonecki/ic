import java.util.HashMap;

public class Solution {

    public static HashMap<String, Integer> buildCloud(String document) {
        HashMap<String, Integer> cloud = new HashMap<>();

        for (int leftIndex = 0, rightIndex = 0; leftIndex < document.length(); ) {
            char firstCharacter = document.charAt(leftIndex);
            if (firstCharacter == ' ') {
                // go past the whitespace
                leftIndex++;
            }
            else {
                // process until next whitespace / eos
                for (rightIndex = leftIndex; rightIndex < document.length(); rightIndex++) {
                    char character = document.charAt(rightIndex);
                    if (character == ' ') {
                        // white space detection.
                        break;
                    }
                }

                // right index is at the end of the document or at white space character
                String key = buildKey(document.substring(leftIndex, rightIndex));
                int count = cloud.getOrDefault(key, 0).intValue() + 1;
                cloud.put(key, count);
                
                // update left index.
                leftIndex = rightIndex;
            }
        }

        return cloud;
    }

    private static String buildKey(String string) {
        StringBuilder sb = new StringBuilder(string.length());
        
        for (int index = 0; index < string.length(); index++) {
            char character = string.charAt(index);

            if (character == '.' || character == '?' || character == ',') {
                // do nothing
            }
            else {
                // currently ignoring case.
                if (character >= 'A' && character <= 'Z') {
                    character = (char)(character - 'A' + 'a');
                }

                sb.append(character);
            }
        }

        return sb.toString();
    }

    public static void main(String [] args) {
        
    }
}