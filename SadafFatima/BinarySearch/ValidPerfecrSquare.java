import java.util.Scanner;

public class ValidPerfecrSquare {
    public boolean isPerfectSquare(int num) {
        if (num < 2) return true;

        long low = 1, high = num;
        
        while (low <= high) {
            long mid = low + (high - low) / 2;
            long square = mid * mid;

            if (square == num) {
                return true;
            } else if (square < num) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = scanner.nextInt();

        ValidPerfecrSquare solution = new ValidPerfecrSquare();
        boolean result = solution.isPerfectSquare(num);

        if (result) {
            System.out.println(num + " is a perfect square.");
        } else {
            System.out.println(num + " is not a perfect square.");
        }

        scanner.close();
    }
}
