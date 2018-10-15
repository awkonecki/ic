import java.util.Random;

public class Solution {
    public static int maxProfit(int [] stockPrices) {
        if (stockPrices == null || stockPrices.length < 2) {
            throw new java.lang.IllegalArgumentException(
                "Stockprices requires at least two values, to buy and sell."
            );
        }

        int maxProfit = stockPrices[1] - stockPrices[0];
        int buyPrice = stockPrices[0];

        for (int sellIndex = 1; sellIndex < stockPrices.length; sellIndex++) {
            int sellPrice = stockPrices[sellIndex];

            if (sellPrice - buyPrice > maxProfit) {
                maxProfit = sellPrice - buyPrice;
            }

            if (sellPrice < buyPrice) {
                buyPrice = sellPrice;
            }
        }

        assert (maxProfitBruteForce(stockPrices) == maxProfit);
        return maxProfit;
    }

    public static int maxProfitBruteForce(int [] stockPrices) {
        int maxProfit = stockPrices[1] - stockPrices[0];

        for (int pivotIndex = 0; pivotIndex < stockPrices.length; pivotIndex++) {
            int buyPrice = stockPrices[pivotIndex];
            for (int sellIndex = pivotIndex; sellIndex < stockPrices.length; sellIndex++) {
                int sellPrice = stockPrices[sellIndex];

                if (sellPrice - buyPrice > maxProfit) {
                    maxProfit = sellPrice - buyPrice;
                }
            }
        }

        return maxProfit;
    }

    public static void main(String [] args) {
        int caseCount = 100;
        Random random = new Random();

        for (int caseIndex = 0; caseIndex < caseCount; caseIndex++) {
            int [] stockPrices = new int [random.nextInt(1000) + 2]; 
            for (int priceIndex = 0; priceIndex < stockPrices.length; priceIndex++) {
                stockPrices[priceIndex] = random.nextInt(10000) * (random.nextBoolean() ? -1 : 1);
            }

            maxProfit(stockPrices);
        }
    }
}