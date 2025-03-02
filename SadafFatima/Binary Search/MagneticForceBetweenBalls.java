import java.util.Arrays;
import java.util.Scanner;

public class MagneticForceBetweenBalls {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);

        int low = 1, high = position[position.length - 1] - position[0]; 
        int result = 0;

        while (low <= high) { 
            int mid = low + (high - low) / 2;

            if (canPlaceBalls(position, m, mid)) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }

    private boolean canPlaceBalls(int[] position, int m, int minDist) {
        int count = 1, lastPlaced = position[0];

        for (int i = 1; i < position.length; i++) {
            if (position[i] - lastPlaced >= minDist) {
                count++;
                lastPlaced = position[i];

                if (count == m) return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of baskets: ");
        int n = scanner.nextInt();
        int[] position = new int[n];

        System.out.println("Enter basket positions:");
        for (int i = 0; i < n; i++) {
            position[i] = scanner.nextInt();
        }

        System.out.print("Enter number of balls: ");
        int m = scanner.nextInt();

        MagneticForceBetweenBalls solution = new MagneticForceBetweenBalls();
        int result = solution.maxDistance(position, m);

        System.out.println("Maximum minimum force: " + result);

        scanner.close();
    }
}
