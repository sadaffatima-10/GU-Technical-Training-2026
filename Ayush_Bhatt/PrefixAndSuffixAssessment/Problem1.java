//package test DSA;

public class Problem1 {
    public void findMiddleIndex(int []nums){
        int totalSum = 0;
        int leftSum = 0;
//initialze the total and left sum as zero
        for(num : nums){
            totalSum + = nums;//calculate the total sum
        }
        for(int i = 0;i<nums.length;i++){
            int rightSum = totalSum - leftSum - nums[i]; // calculate the right sum
            if ( leftSum = rightSum )//check if both the rightSum and LeftSum are equal
            {
               return i; //return i index
            }
            leftSum +=nums[i];
        }
        return -1;

        }
        public static void main(String[] args) {
            int[] nums1 = {2, 3, -1, 8, 4};
            int[] nums2 = {1, -1, 4};
            int[] nums3 = {2, 5};
    
            System.out.println(findMiddleIndex(nums1)); 
            System.out.println(findMiddleIndex(nums2)); 
            System.out.println(findMiddleIndex(nums3));
        }
    }
}
//time complexity---- O(2n)
//space complexity ---- O(1)
