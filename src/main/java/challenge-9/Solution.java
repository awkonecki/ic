public class Solution {
    // [F]unctional

    // Assumme that each cake array is of the following
    // [weight, value]
    private static int getMaxStolenValue(
        int [][] cakes, 
        int cakeIndex, 
        int capacityRemaining, 
        int currentValue, 
        int maxValue) 
    {
        if ((capacityRemaining == 0 || cakeIndex >= cakes.length) && currentValue > maxValue) {
            return currentValue;
        }
        else if (capacityRemaining <= 0 || cakeIndex >= cakes.length) {
            return maxValue;
        }

        int cakeWeight = cakes[cakeIndex][0];
        int cakeValue = cakes[cakeIndex][1];
        int cakeCount = 1;
        int max = maxValue;

        // excluded
        max = getMaxStolenValue(cakes, cakeIndex + 1, capacityRemaining, currentValue, max); 

        // Included
        while (cakeCount * cakeWeight <= capacityRemaining && cakeCount * (cakeValue + currentValue) > currentValue) {
            max = getMaxStolenValue(cakes, cakeIndex + 1, capacityRemaining - (cakeCount * cakeWeight), currentValue + (cakeValue * cakeCount), max); 
            cakeCount++;   
        }

        return max;
    }

    // [A]nalysis
    // 1. Does the problem have optimal sub-structure?
    // Yes each level is independent of the others.
    // 2. Does the problem have re-occurring problems?
    // Yes, there is a possibility based on the data that the same max value, 
    // current value and index are presented.

    // Performance
    // Memory 
    // O(N) - where N is the number of cakes

    // Time
    // O(D^N) where D is the capacity / minimum weight.

    public static int getMaxStolenValue(int [][] cakes, int capacity) {
        return getMaxStolenValue(cakes, 0, capacity, 0, 0);
    }

    public static void main(String [] args) {
        System.out.println(getMaxStolenValue(new int [][] {
            {2, 1},
            {2, 0},
            {0, 10000}
        }, 9));
    }
}