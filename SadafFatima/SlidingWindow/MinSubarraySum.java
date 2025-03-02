import java.util.Scanner;

public class MinSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int start = 0, end = 0, minLength = n + 1, sum = 0;

        while (end < n) {
            sum += nums[end];

            while (sum >= target) { 
                minLength = Math.min(minLength, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return (minLength == n + 1) ? 0 : minLength;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter target sum: ");
        int target = scanner.nextInt();

        System.out.print("Enter array size: ");
        int n = scanner.nextInt();
        
        int[] nums = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        MinSubarraySum sol = new MinSubarraySum();
        int result = sol.minSubArrayLen(target, nums);
        System.out.println("Minimum subarray length: " + result);

        scanner.close();
    }
}
