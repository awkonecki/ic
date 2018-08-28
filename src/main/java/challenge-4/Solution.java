public class Solution {

    public static int [] myFunction(int [] scores, int highestScorePossible) {
        int [] sortedScores = new int [scores.length];
        int [] scoreCounts = new int [highestScorePossible + 1];
        
        // this assumes that the scores are never negative and would be bound to size of 
        // an integer.  
        // if negative could double the possible assuming the min is the negative of the
        // max or can just take the total  number of elements between the min and max.
        for (int score : scores) {
            scoreCounts[score] += 1;
        }
        
        
        int scoreIndex = 0;
        for (int index = 0; index < sortedScores.length; ) {
            if (scoreCounts[scoreIndex] > 0) {
                scoreCounts[scoreIndex]--;
                sortedScores[index] = scoreIndex;
                index++;
            }
            else {
                scoreIndex++;
            }
        }
        
        return sortedScores;
    }
    
    public static void main(String [] args) {
        for (int score : myFunction(new int [] {41, 37, 89, 41, 65, 91, 53, 41}, 100)) {
            System.out.println(score);
        }
    }
}