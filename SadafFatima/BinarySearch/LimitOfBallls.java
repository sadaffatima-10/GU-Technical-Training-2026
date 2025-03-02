import java.util.Scanner;

public class LimitOfBallls {
    public boolean isPossible(int nums[], int maxBalls, int maxOperations) {
        for (int num : nums) {
            maxOperations -= (num - 1) / maxBalls;
            if (maxOperations < 0) {
                return false;
            }
        }
        return true;
    }

    public int minimumSize(int[] nums, int maxOperations) {
        int min = 1;
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }

        while (min <= max) {
            int maxBalls = (min + max) / 2;

            if (isPossible(nums, maxBalls, maxOperations)) {
                max = maxBalls - 1;
            } else {
                min = maxBalls + 1;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.print("Enter max operations: ");
        int maxOperations = scanner.nextInt();

        LimitOfBallls solution = new LimitOfBallls();
        int result = solution.minimumSize(nums, maxOperations);

        System.out.println("Minimum Bag Size: " + result);

        scanner.close();
    }
}
