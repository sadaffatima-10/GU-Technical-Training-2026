import java.util.Scanner;

public class EqualSubstringsWithinBudget {
    public int equalSubstring(String s, String t, int maxCost) {
        int start = 0, end = 0, maxLength = 0, cost = 0;

        while (end < s.length()) {
            cost += Math.abs(s.charAt(end) - t.charAt(end));

            while (cost > maxCost) { // Shrink window if cost exceeds maxCost
                cost -= Math.abs(s.charAt(start) - t.charAt(start));
                start++;
            }

            maxLength = Math.max(maxLength, end - start + 1);
            end++;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first string (s): ");
        String s = scanner.nextLine();

        System.out.print("Enter second string (t): ");
        String t = scanner.nextLine();

        System.out.print("Enter max cost: ");
        int maxCost = scanner.nextInt();

        EqualSubstringsWithinBudget sol = new EqualSubstringsWithinBudget();
        int result = sol.equalSubstring(s, t, maxCost);
        System.out.println("Longest equal substring length: " + result);

        scanner.close();
    }
}
