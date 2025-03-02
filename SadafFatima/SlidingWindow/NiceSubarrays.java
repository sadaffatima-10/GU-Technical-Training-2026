import java.util.Scanner;

public class NiceSubarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    public int atMost(int[] nums, int k) {
        int start = 0, end = 0, oddCount = 0, count = 0;
        while (end < nums.length) {
            if (nums[end] % 2 != 0) {
                oddCount++;
            }

            while (oddCount > k) {
                if (nums[start] % 2 != 0) {
                    oddCount--;
                }
                start++;
            }
            count += (end - start + 1);
            end++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.print("Enter the value of k: ");
        int k = scanner.nextInt();

        NiceSubarrays sol = new NiceSubarrays();
        int result = sol.numberOfSubarrays(nums, k);
        System.out.println("Number of nice subarrays: " + result);

        scanner.close();
    }
}
