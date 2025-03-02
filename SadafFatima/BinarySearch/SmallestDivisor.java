import java.util.Scanner;

public class SmallestDivisor {
    public int SumByDiv(int[] nums, int div) {
        int sum = 0;
        for (int num : nums) {
            sum += (int) Math.ceil((double) num / div);
        }
        return sum;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int min = 1, max = 0;

        for (int num : nums) {
            max = Math.max(max, num);
        }

        while (min <= max) {
            int mid = min + (max - min) / 2;
            if (SumByDiv(nums, mid) <= threshold) {
                max = mid - 1;
            } else {
                min = mid + 1;
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

        System.out.print("Enter threshold: ");
        int threshold = scanner.nextInt();

        SmallestDivisor solution = new SmallestDivisor();
        int result = solution.smallestDivisor(nums, threshold);

        System.out.println("Smallest Divisor: " + result);

        scanner.close();
    }
}
