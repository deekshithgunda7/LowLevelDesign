import java.util.*;

class Solution {

   public static void main(String[] args) {
        int[] arr = {9, 4, 7, 6, 3, 1, 5};
        int n = arr.length;

        System.out.println("Before Sorting Array: ");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();

        // Create an instance of the Solution class
        Solution sol = new Solution();
        // Function call to sort the array
        int[] sortedArr = sol.mergeSort(arr);

        System.out.println("After Sorting Array: ");
        for (int i = 0; i < n; i++)
            System.out.print(sortedArr[i] + " ");
        System.out.println();
    }

  public void merge(int[] nums, int low, int mid, int high) {

    List<Integer> temp = new ArrayList<>();

    int left = low;
    int rigth = mid + 1;

    while (left <= mid && rigth <= high) {
      if (nums[left] <= nums[rigth]) {
        temp.add(nums[left]);
        left++;
      } else {
        temp.add(nums[rigth]);
        rigth++;
      }
    }

    while (left <= mid) {
      temp.add(nums[left]);
      left++;
    }

    while (rigth <= high) {
      temp.add(nums[rigth]);
      rigth++;
    }

    for (int i = low; i <= high; i++) {
      nums[i] = temp.get(i - low);
    }
  }

  public void mergeSortHelper(int[] nums, int low, int high) {

    if (low >= high) return;

    int mid = (low + high) / 2;

    mergeSortHelper(nums, low, mid);
    mergeSortHelper(nums, mid + 1, high);

    merge(nums, low, mid, high);
  }

  public int[] mergeSort(int[] nums) {

    int n = nums.length - 1;

    mergeSortHelper(nums, 0, n);

    // sorting same array itself
    return nums;
  }
}
