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
        int cakeCount = 0;
        int max = maxValue;

        while (cakeCount * cakeWeight <= capacityRemaining) {
            max = getMaxStolenValue(cakes, cakeIndex + 1, capacityRemaining - (cakeCount * cakeWeight), currentValue + (cakeValue * cakeCount), max); 
            cakeCount++;   
        }

        return max;
    }

    public static int getMaxStolenValue(int [][] cakes, int capacity) {
        return getMaxStolenValue(cakes, 0, capacity, 0, 0);
    }

    public static void main(String [] args) {
        System.out.println(getMaxStolenValue(new int [][] {
            {2, 1}
        }, 9));
    }
}