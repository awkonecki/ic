public class Solution {

    public static int [] function(int [] nums) {
        if (nums == null || nums.length < 2) {
            return new int [0];
        }

        int [] result = new int [nums.length];
        int forward = 1, backward = 1;

        for (int i = 1; i < nums.length; i++) {
            forward *= nums[i - 1];
            result[i] = forward;
        }

        for (int i = nums.length - 2; i > 0; i--) {
            backward *= nums[i + 1];
            result[i] *= backward;
        }

        result[0] = backward;
        result[result.length - 1] = forward;

        return result;
    }
    
    public static void main(String [] args) {
        assert (function(null).length == 0);
        assert (function(new int [0]).length == 0);
        assert (function(new int [1]).length == 0);

        int [] singleZero = new int [] {0,1,2,3,4,5};
        int [] singleZeroRsult = new int [] {120,0,0,0,0,0};
        int index = 0;
        for (int num : function(singleZero)) {
            assert (singleZeroRsult[index] == num);
            index++;
        }
    }
}