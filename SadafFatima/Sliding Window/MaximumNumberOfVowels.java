import java.util.Scanner;

public class MaximumNumberOfVowels {
    public int maxVowels(String s, int k) {
        int maxVowelCount = 0, currentVowelCount = 0;
        int n = s.length();

        // Check if a character is a vowel
        boolean[] isVowel = new boolean[128];
        isVowel['a'] = isVowel['e'] = isVowel['i'] = isVowel['o'] = isVowel['u'] = true;

        // Count vowels in the first window of size k
        for (int i = 0; i < k; i++) {
            if (isVowel[s.charAt(i)]) {
                currentVowelCount++;
            }
        }
        maxVowelCount = currentVowelCount;


        for (int i = k; i < n; i++) {
            if (isVowel[s.charAt(i)]) {
                currentVowelCount++;
            }
            if (isVowel[s.charAt(i - k)]) {
                currentVowelCount--;
            }
            maxVowelCount = Math.max(maxVowelCount, currentVowelCount);
        }

        return maxVowelCount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String s = scanner.nextLine();

        System.out.print("Enter the value of k: ");
        int k = scanner.nextInt();

        MaximumNumberOfVowels sol = new MaximumNumberOfVowels();
        int result = sol.maxVowels(s, k);
        System.out.println("Maximum number of vowels in any substring of length " + k + ": " + result);

        scanner.close();
    }
}
