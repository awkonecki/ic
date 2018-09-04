import java.util.*;

public class Solution {

    public static int function(int [] nums) {
        HashSet<Integer> duplicates = findAllDuplicates(nums);
        if (duplicates.size() < 1) {
            return -1;
        }  

        assert (duplicates.contains(modification(nums.clone())));
        assert (duplicates.contains(search(nums)));        
        assert (duplicates.contains(graph(nums)));

        return -1;
    }

    private static HashSet<Integer> findAllDuplicates(int [] nums) {
        HashSet<Integer> uniques = new HashSet<Integer>();
        HashSet<Integer> duplicates = new HashSet<Integer>();

        for (int num : nums) {
            if (uniques.contains(num)) {
                duplicates.add(num);
            }
            else {
                uniques.add(num);
            }
        }

        return duplicates;
    }

    private static int search(int [] nums) {
        int lowIndex = 0, highIndex = nums.length - 1;

        while (lowIndex < highIndex) {
            int index = (highIndex - lowIndex) / 2 + lowIndex;
            int lowerIndexLower = lowIndex;
            int lowerIndexUpper = index;
            int higherIndexLower = index + 1;
            int higherIndexUpper = highIndex;

            int lowerCount = 0;
            //int upperCount = 0;

            for (int num : nums) {
                if (num >= lowerIndexLower && num <= lowerIndexUpper) {
                    lowerCount++;
                }
                //else {
                //    upperCount++;
                //}
            }

            int lowerPossibilities = lowerIndexUpper - lowerIndexLower + 1;
            //int higherPossibilities = higherIndexUpper - higherIndexLower + 1;
            
            /*
            if (lowerCount > lowerPossibilities && upperCount > higherPossibilities) {
                if (lowerCount > upperCount) {
                    highIndex = lowerIndexUpper;
                    lowIndex = lowerIndexLower;
                }
                else {
                    highIndex = higherIndexUpper;
                    lowIndex = higherIndexLower;
                }
            }
            else */if (lowerCount > lowerPossibilities) {
                highIndex = lowerIndexUpper;
                lowIndex = lowerIndexLower;    
            }
            else {//if (upperCount > higherPossibilities) {
                highIndex = higherIndexUpper;
                lowIndex = higherIndexLower;
            }
            //else {
            //    assert (false);
            //}
        }
        
        System.out.println(lowIndex);
        return lowIndex;
    }

    private static int graph(int [] nums) {
        int slowIndex = nums.length - 1;
        int fastIndex = nums.length - 1;
    
        // 1. Find the collision
        while (true) {
            slowIndex = nums[slowIndex];
            fastIndex = nums[fastIndex];
            fastIndex = nums[fastIndex];

            if (slowIndex == fastIndex) {
                break;
            }
        }

        // 2. Find the head
        fastIndex = nums.length - 1;

        while (fastIndex != slowIndex) {
            slowIndex = nums[slowIndex];
            fastIndex = nums[fastIndex];  
        }

        // System.out.println(fastIndex + " " + slowIndex);

        // 3. get the one prior to the start
        while (true) {
            if (nums[slowIndex] == fastIndex) {
                break;
            }
            slowIndex = nums[slowIndex];
        }        

        // System.out.println(slowIndex);

        return nums[slowIndex];
    }

    private static int modification(int [] nums) {
        for (int index = 0; index < nums.length; ) {
            int num = nums[index];

            if (num == index) {
                index++;
            }
            else {
                if (nums[num] == num) {
                    return num;
                }
                else {
                    nums[index] = nums[num];
                    nums[num] = num;
                }
            }
        }

        return -1;
    }
    
    public static void main(String [] args) {
        function(new int [] {2,0,1,0});  
        function(new int [] {0,0,1,2,3,4,5,6,7,8});
        function(new int [] {0,1,0,2,3,4,5,6,7,8});
        function(new int [] {0,1,2,0,3,4,5,6,7,8});
        function(new int [] {0,1,2,3,0,4,5,6,7,8});
        function(new int [] {0,1,2,3,4,0,5,6,7,8});
        function(new int [] {0,1,2,3,4,5,0,6,7,8});
        function(new int [] {0,1,2,3,4,5,6,0,7,8});
        function(new int [] {0,1,2,3,4,5,6,7,0,8});
        function(new int [] {0,1,2,3,4,5,6,7,8,0});        
    }
}