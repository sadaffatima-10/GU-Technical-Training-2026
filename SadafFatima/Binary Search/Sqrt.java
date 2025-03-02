import java.util.Scanner;

public class Sqrt {
    public int mySqrt(int x) {
        if (x < 2) return x;

        int low = 1, high = x / 2, ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            long square = (long) mid * mid;

            if (square == x) {
                return mid;
            } else if (square < x) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a non-negative integer: ");
        int num = scanner.nextInt();

        Sqrt solution = new Sqrt();
        int result = solution.mySqrt(num);

        System.out.println("Square root of " + num + " (rounded down) is: " + result);

        scanner.close();
    }
}
