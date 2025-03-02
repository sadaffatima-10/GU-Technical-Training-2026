import java.util.*;

public class HIndexII {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] suffix = new int[n + 1];

        for (int num : citations) {
            if (num > n) {
                suffix[n]++;
            } else {
                suffix[num]++;
            }
        }

        int sum = 0;
        for (int i = n; i >= 0; i--) {
            sum += suffix[i];
            if (sum >= i) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of citations: ");
        int n = scanner.nextInt();

        int[] citations = new int[n];

        System.out.println("Enter citations:");
        for (int i = 0; i < n; i++) {
            citations[i] = scanner.nextInt();
        }

        HIndexII solution = new HIndexII();
        int hIndex = solution.hIndex(citations);

        System.out.println("H-Index: " + hIndex);

        scanner.close();
    }
}
