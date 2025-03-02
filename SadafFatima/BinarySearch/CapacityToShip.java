import java.util.Scanner;

public class CapacityToShip {
    public boolean isPossible(int[] weights, int days, int capacity) {
        int reqDays = 1, load = 0;
        for (int weight : weights) {
            if (weight > capacity) {
                return false;
            }

            if (load + weight > capacity) {
                reqDays++;
                load = weight;
            } else {
                load += weight;
            }
        }
        return reqDays <= days;
    }

    public int shipWithinDays(int[] weights, int days) {
        int sum = 0;
        for (int weight : weights) {
            sum += weight;
        }
        int max = sum, min = 1, capacity;

        while (min <= max) {
            capacity = (min + max) / 2;

            if (isPossible(weights, days, capacity)) {
                max = capacity - 1;
            } else {
                min = capacity + 1;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of packages: ");
        int n = scanner.nextInt();
        int[] weights = new int[n];

        System.out.println("Enter package weights:");
        for (int i = 0; i < n; i++) {
            weights[i] = scanner.nextInt();
        }

        System.out.print("Enter number of days: ");
        int days = scanner.nextInt();

        CapacityToShip solution = new CapacityToShip();
        int result = solution.shipWithinDays(weights, days);

        System.out.println("Minimum ship capacity required: " + result);

        scanner.close();
}
}
