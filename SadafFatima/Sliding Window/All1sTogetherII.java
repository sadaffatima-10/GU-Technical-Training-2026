import java.util.Scanner;

public class All1sTogetherII {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int totalOnes = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                totalOnes++;
            }
        }
        if (totalOnes == 0 || totalOnes == n) {
            return 0;
        }

        int start = 0, end = 0, currentOnes = 0;
        int minSwap = Integer.MAX_VALUE;

        while (end < 2 * n) {
            if (nums[end % n] == 1) {
                currentOnes++;
            }

            if ((end - start + 1) == totalOnes) {
                int swap = totalOnes - currentOnes;
                minSwap = Math.min(minSwap, swap);

                if (nums[start % n] == 1) {
                    currentOnes--;
                }
                start++;
            }
            end++;
        }
        return minSwap;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];

        System.out.println("Enter the elements of the array (only 0s and 1s):");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        All1sTogetherII sol = new All1sTogetherII();
        int result = sol.minSwaps(nums);
        System.out.println("Minimum swaps required: " + result);

        scanner.close();
    }

}
