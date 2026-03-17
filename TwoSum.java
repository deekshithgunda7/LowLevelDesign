import java.util.HashMap;

class Solution {
    // Variant 1: Check if two numbers sum to target using hashing
    public String twoSumExists(int[] arr, int target) {
        
        HashMap<Integer, Integer> map = new HashMap<>();

        // Iterate over all elements
        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            // Check if complement exists in map
            if (map.containsKey(complement)) {
                return "YES";  // Pair found
            }
            // Store current element and its index
            map.put(arr[i], i);
        }
        // No pair found
        return "NO";
    }

    // Variant 2: Return indices of two numbers that sum to target using hashing
    public int[] twoSumIndices(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            // If complement found, return indices
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            // Store current element and index
            map.put(arr[i], i);
        }
        // No pair found
        return new int[] { -1, -1 };
    }
}

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {2, 6, 5, 8, 11};
        int target = 14;

        System.out.println(sol.twoSumExists(arr, target));
        int[] res = sol.twoSumIndices(arr, target);
        System.out.println("[" + res[0] + ", " + res[1] + "]");
    }
}
