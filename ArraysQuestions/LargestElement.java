package LowLevelDesign.ArraysQuestions;

import java.util.*;

class Solution {
    public int largestElement(int[] nums) {
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }
}