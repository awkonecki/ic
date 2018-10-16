import java.util.HashSet;

public class Solution {

    public static boolean isCompleteCycle(int [] values) {
        HashSet<Integer> indicesVisited = new HashSet<>();
        
        if (values == null || values.length < 1) {
            throw new java.lang.IllegalArgumentException(
                "Values must be populated with at least one value."
            );
        }

        int length = values.length;
        int indexToVisit = 0;
        int visitCount = 0;

        for (visitCount = 0; visitCount < length; visitCount++) {
            if (indicesVisited.contains(indexToVisit)) {
                return false;
            }
            
            indicesVisited.add(indexToVisit);

            indexToVisit = (indexToVisit + (values[indexToVisit] % length)) % length;

            if (indexToVisit < 0) {
                indexToVisit += length;
            }

            if (indexToVisit == 0) {
                break;
            }
        }

        if (indicesVisited.size() == values.length && indexToVisit == 0 && visitCount == length - 1) {
            return true;
        }
        else {
            return false;
        }
    }

    public static void main(String [] args) {
        assert (isCompleteCycle(new int [] {1}));
        assert (isCompleteCycle(new int [] {2,2,2,2,2}));
        assert (isCompleteCycle(new int [] {1,1,1,1,1}));
        assert (!isCompleteCycle(new int [] {2,2}));
    }
}