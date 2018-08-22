public class Solution {

    public static int minDrops(int floors) {
        if (floors <= 0) {
            return -1;
        } 
        else {
            return (new Double(
                Math.ceil((-1.0 + Math.sqrt(1 + 4 * 2 * floors)) / 2.0))
                ).intValue();
        }
    }

    public static void main(String [] args) {
        System.out.println(minDrops(100));
        assert (minDrops(100) == 14);
    }
}