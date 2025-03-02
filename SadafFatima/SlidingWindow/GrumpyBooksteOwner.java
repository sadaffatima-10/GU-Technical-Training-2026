import java.util.Scanner;

public class GrumpyBooksteOwner{
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int start = 0, end = 0;
        int maxUnsatisfied = 0, totalSatisfied = 0, unsatisfied = 0;

        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                totalSatisfied += customers[i];
            }
        }

        while (end < customers.length) {
            unsatisfied += customers[end] * grumpy[end];

            if (end - start + 1 > minutes) {
                if (grumpy[start] == 1) {
                    unsatisfied -= customers[start];
                }
                start++;
            }

            maxUnsatisfied = Math.max(maxUnsatisfied, unsatisfied);
            end++;
        }

        return totalSatisfied + maxUnsatisfied;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        int[] customers = new int[n];
        int[] grumpy = new int[n];

        System.out.println("Enter the customers array:");
        for (int i = 0; i < n; i++) {
            customers[i] = scanner.nextInt();
        }

        System.out.println("Enter the grumpy array:");
        for (int i = 0; i < n; i++) {
            grumpy[i] = scanner.nextInt();
        }

        System.out.print("Enter the minutes: ");
        int minutes = scanner.nextInt();

        GrumpyBooksteOwner sol = new GrumpyBooksteOwner();
        int result = sol.maxSatisfied(customers, grumpy, minutes);
        System.out.println("Maximum satisfied customers: " + result);

        scanner.close();
    }
}
