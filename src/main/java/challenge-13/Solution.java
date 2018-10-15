import java.util.Random;

public class Solution {
    public static int rand7(Random random) {
        while (true) {
            switch (rand5(random)) {
                case 1:
                    switch (rand5(random)) {
                        case 1:
                        case 2:
                            return 1;
                        case 3:
                        case 4:
                            return 2;
                        default:
                            // re-roll
                            break;
                    }
                    break;
                case 2:
                    switch (rand5(random)) {
                        case 1:
                        case 2:
                            return 3;
                        case 3:
                        case 4:
                            return 4;
                        default:
                            // re-roll
                            break;
                    }
                    break;
                case 3:
                    switch (rand5(random)) {
                        case 1:
                        case 2:
                            return 5;
                        case 3:
                        case 4:
                            return 6;
                        default:
                            // re-roll
                            break;
                    }
                    break;
                case 4:
                    switch (rand5(random)) {
                        case 1:
                        case 2:
                            return 7;
                        default:
                            // re-roll
                            break;
                    }
                    break;
                default:
                    // do nothing just re-roll
                    break;
            }
        }
    }

    public static int random7(Random random) {
        while (true) {
            int roll1 = rand5(random), roll2 = rand5(random);

            if ((roll1 - 1) * 5 + (roll2 - 1) + 1 > 21) {
                continue;
            }

            return ((roll1 - 1) * 5 + (roll2 - 1) + 1) % 7 + 1;
        }
    }

    private static int rand5(Random random) {
        return random.nextInt(5) + 1;
    }

    public static void main(String [] args) {
        int [] counts = new int [7];
        int trials = 100000000;
        Random random = new Random();

        while (trials > 0) {
            trials--;
            int value = rand7(random);
            counts[value - 1]++;
        }

        int min = counts[0];
        int max = counts[1];
        for (int count : counts) {
            System.out.println(count);
            if (count < min) {
                min = count;
            }
            if (count > max) {
                max = count;
            }
        }
        System.out.println("Min Max Difference " + (max - min));
        
        counts = new int [7];
        trials = 100000000;
        while (trials > 0) {
            trials--;
            int value = random7(random);
            counts[value - 1]++;
        }

        min = counts[0];
        max = counts[1];
        for (int count : counts) {
            System.out.println(count);
            if (count < min) {
                min = count;
            }
            if (count > max) {
                max = count;
            }
        }
        System.out.println("Min Max Difference " + (max - min));
    }
}