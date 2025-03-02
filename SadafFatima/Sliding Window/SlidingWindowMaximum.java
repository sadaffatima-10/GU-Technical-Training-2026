import java.util.Arrays;
import java.util.Scanner;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || k == 0) {
            return new int[0];
        }

        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];

        // Step 1: Compute prefix max
        for (int i = 0; i < n; i++) {
            if (i % k == 0) {
                prefixMax[i] = nums[i]; 
            } else {
                prefixMax[i] = Math.max(prefixMax[i - 1], nums[i]);
            }
        }

        // Step 2: Compute suffix max
        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1 || (i + 1) % k == 0) {
                suffixMax[i] = nums[i];
            } else {
                suffixMax[i] = Math.max(suffixMax[i + 1], nums[i]);
            }
        }

        // Step 3: Compute sliding window max
        int[] result = new int[n - k + 1];
        for (int i = 0; i <= n - k; i++) {
            result[i] = Math.max(suffixMax[i], prefixMax[i + k - 1]);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input size of array
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();

        int[] nums = new int[n];

        // Input array elements
        System.out.print("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        // Input window size k
        System.out.print("Enter window size k: ");
        int k = scanner.nextInt();

        SlidingWindowMaximum sol = new SlidingWindowMaximum();
        int[] result = sol.maxSlidingWindow(nums, k);

        // Output result
        System.out.println("Maximum values in each sliding window: " + Arrays.toString(result));

        scanner.close();
    }
}
