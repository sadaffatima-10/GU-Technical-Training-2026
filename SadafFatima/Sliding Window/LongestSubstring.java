import java.util.Scanner;

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int maxLength = 0;
        int[] helperArray = new int[128]; // ASCII character tracking

        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            start = Math.max(start, helperArray[c]); 
            maxLength = Math.max(maxLength, end - start + 1);
            helperArray[c] = end + 1; 
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        LongestSubstring sol = new LongestSubstring();
        int result = sol.lengthOfLongestSubstring(input);

        System.out.println("Length of longest substring without repeating characters: " + result);

        scanner.close();
    }
}
