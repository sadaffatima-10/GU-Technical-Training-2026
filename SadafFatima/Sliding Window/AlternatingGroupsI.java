import java.util.Scanner;

public class AlternatingGroupsI {
    public int numberOfAlternatingGroups(int[] colors) {
        int n = colors.length;
        if (n == 0) return 0;

        int groups = 1; 

        for (int i = 1; i < n; i++) {
            if (colors[i] != colors[i - 1]) {
                groups++;
            }
        }

        if (colors[0] != colors[n - 1]) {
            groups++;
        }

        return groups;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] colors = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            colors[i] = scanner.nextInt();
        }

        AlternatingGroupsI sol = new AlternatingGroupsI();
        int result = sol.numberOfAlternatingGroups(colors);
        System.out.println("Number of alternating groups: " + result);

        scanner.close();
    }
}
