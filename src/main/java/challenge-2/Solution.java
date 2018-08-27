import java.lang.Math;

public class Solution {

    public static int duplicateNumber(int [] nums) {
        long sum = 0;

        for (int index = 1; index <= nums.length; index++) {
            sum += ((long)index) - ((long)nums[index - 1]);
        }

        sum -= (long)(nums.length);

        return Math.abs((int)sum);
    }

    public static void main(String [] args) {
        assert (duplicateNumber(new int [] {1,2,3,4,5,1}) == 1);
        assert (duplicateNumber(new int [] {1,2,3,4,5,2}) == 2);
        assert (duplicateNumber(new int [] {1,2,3,4,5,3}) == 3);
        assert (duplicateNumber(new int [] {1,2,3,4,5,4}) == 4);
        assert (duplicateNumber(new int [] {1,2,3,4,5,5}) == 5);
    }
}