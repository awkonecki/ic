import java.util.HashMap;

public class Solution {

    public static HashMap<String, Integer> getData(String data) {
        HashMap<String, Integer> result = new HashMap<String, Integer>();
        if (data == null || data.isEmpty()) {
            return result;    
        }
        
        // First will need to parse.  
        for (int leftIndex = 0; leftIndex < data.length(); ) {
            switch (data.charAt(leftIndex)) {
                case '.':
                case ':':
                case ' ':
                case ',':
                case '\n':
                case '?':
                case '-':
                case '(':
                case ')':
                    leftIndex++;
                    break;
                default:
                    assert (data.charAt(leftIndex) != ' ');
                    StringBuilder sb = new StringBuilder();
                    int rightIndex = leftIndex;
                    for (; rightIndex < data.length(); rightIndex++) {
                        if ((data.charAt(rightIndex) >= 'a' && data.charAt(rightIndex) <= 'z') || 
                            (data.charAt(rightIndex) == '-')) {
                            sb.append(data.charAt(rightIndex));
                        }
                        else if (data.charAt(rightIndex) >= 'A' && data.charAt(rightIndex) <= 'Z') {
                            sb.append(((char)(data.charAt(rightIndex) - 'A' + 'a')));
                        }
                        else if (data.charAt(rightIndex) == '\'') {
                            // do nothing
                        }
                        else {
                            break;
                        }
                    }

                    leftIndex = rightIndex + 1;
                    String key = sb.toString();
                    if (result.containsKey(key)) {
                        result.put(key, result.get(key).intValue() + 1);
                    }
                    else {
                        result.put(key, 1);
                    }
            }    
        }

        return result;
    }

    private static String buildKey(String string) {
        return string;
    }
    
    public static void main(String [] args) {
        String string = "We came, we saw, we conquered...then we ate Bill's (Mille-Feuille) cake.  The bill came to five dollars.";
        HashMap<String, Integer> mapping = getData(string);

        for (String key : mapping.keySet()) {
            System.out.println(key + " " + mapping.get(key).intValue());
        }
    }
}