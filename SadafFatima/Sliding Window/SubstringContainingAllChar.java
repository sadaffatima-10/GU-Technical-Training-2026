import java.util.Scanner;

public class SubstringContainingAllChar {
    public int numberOfSubstrings(String s) {
        int start = 0, end = 0, count = 0;
        int count_a = -1, count_b = -1, count_c = -1;

        while (end < s.length()) {
            if (s.charAt(end) == 'a') {
                count_a = end;
            } else if (s.charAt(end) == 'b') {
                count_b = end;
            } else if (s.charAt(end) == 'c') {
                count_c = end;
            }

            int minOfCount = Math.min(count_a, Math.min(count_b, count_c));
            count += minOfCount - start + 1;
            end++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String s = scanner.nextLine();

        SubstringContainingAllChar sol = new SubstringContainingAllChar();
        int result = sol.numberOfSubstrings(s);
        System.out.println("Number of valid substrings: " + result);

        scanner.close();
    }
}
