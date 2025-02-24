import java.util.Scanner;

class PrefixSum4 {
    public int maxScore(String s) {
        int n = s.length();
        int maxScore = 0;
        int totalOnes = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                totalOnes++;
            }
        }

        int leftZeroes = 0;
        int rightOnes = totalOnes;

        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == '0') {
                leftZeroes++;
            } else {
                rightOnes--;
            }
            maxScore = Math.max(maxScore, leftZeroes + rightOnes);
        }

        return maxScore;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a binary string: ");
        String s = sc.next();

        PrefixSum4 solution = new PrefixSum4();
        int result = solution.maxScore(s);

        System.out.println("Maximum score after splitting: " + result);

        sc.close();
    }
}
