class Solution {

      public static void main(String[] args) {
        // Create an instance of solution class
        Solution solution = new Solution();
        
        int[] nums = {13, 46, 24, 52, 20, 9};
        
        System.out.println("Before Using Insertion Sort: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        // Function call for insertion sort
        nums = solution.insertionSort(nums);
        
        System.out.println("After Using Insertion Sort: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public int[] insertionSort(int[] nums) {

        for(int i=0;i<=nums.length-1;i++){

            int j=i;

            while(j>0 && nums[j-1]>nums[j]){
                int temp = nums[j];
                nums[j]=nums[j-1];
                nums[j-1]=temp;

                j--;
            }
        }
        return nums;

    }
}
