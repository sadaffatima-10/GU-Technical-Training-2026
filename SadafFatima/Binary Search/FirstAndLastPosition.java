import java.util.Scanner;

public class FirstAndLastPosition {
    public int[] searchRange(int[] nums, int target) {
        int first = findBound(nums, target, true);
        int last = findBound(nums, target, false);
        return new int[]{first, last};
    }

    private int findBound(int[] nums, int target, boolean isFirst) {
        int left = 0, right = nums.length - 1, result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                result = mid;
                if (isFirst) {
                    right = mid - 1; 
                } else {
                    left = mid + 1; 
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();

        int[] nums = new int[n];

        
        System.out.println("Enter sorted elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.print("Enter target value: ");
        int target = scanner.nextInt();

        FirstAndLastPosition solution = new FirstAndLastPosition();
        int[] result = solution.searchRange(nums, target);

        // Output the result
        System.out.println("Target range: [" + result[0] + ", " + result[1] + "]");

        scanner.close();
    }
}
