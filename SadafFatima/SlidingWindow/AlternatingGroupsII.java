import java.util.Scanner;

public class AlternatingGroupsII {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int start = 0; // Start of the window
        int count = 0;
        int n = colors.length;

        for (int end = 1; end < 2 * n; end++) {
            if (colors[end % n] == colors[(end - 1) % n]) {
                start = end; // Reset window if the sequence breaks
            }

            // If the window size is at least k, count it
            if (end - start + 1 >= k) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = scanner.nextInt();

        int[] colors = new int[n];
        System.out.println("Enter color values:");
        for (int i = 0; i < n; i++) {
            colors[i] = scanner.nextInt();
        }

        System.out.print("Enter minimum group size (k): ");
        int k = scanner.nextInt();

        AlternatingGroupsII sol = new AlternatingGroupsII();
        int result = sol.numberOfAlternatingGroups(colors, k);
        System.out.println("Number of alternating groups: " + result);

        scanner.close();
    }
}
