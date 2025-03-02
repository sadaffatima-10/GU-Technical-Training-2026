import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class MostProfitAssigningWork {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int[][] jobs = new int[n][2];

        for (int i = 0; i < n; i++) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }

        Arrays.sort(jobs, Comparator.comparingInt(a -> a[0])); // Sort jobs by difficulty
        Arrays.sort(worker); // Sort workers by ability

        int[] maxProfit = new int[n]; 
        maxProfit[0] = jobs[0][1];

        for (int i = 1; i < n; i++) {
            maxProfit[i] = Math.max(maxProfit[i - 1], jobs[i][1]); 
        }

        int totalProfit = 0;

        for (int w : worker) {
            int index = binarySearch(jobs, w); // Find max difficulty <= worker ability
            if (index != -1) {
                totalProfit += maxProfit[index];
            }
        }

        return totalProfit;
    }

    private int binarySearch(int[][] jobs, int ability) {
        int left = 0, right = jobs.length - 1, ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (jobs[mid][0] <= ability) {
                ans = mid; // Store the best valid job index
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans; // Returns index of best job or -1 if no job is possible
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of jobs: ");
        int n = scanner.nextInt();
        int[] difficulty = new int[n];
        int[] profit = new int[n];

        System.out.println("Enter job difficulties:");
        for (int i = 0; i < n; i++) {
            difficulty[i] = scanner.nextInt();
        }

        System.out.println("Enter job profits:");
        for (int i = 0; i < n; i++) {
            profit[i] = scanner.nextInt();
        }

        System.out.print("Enter number of workers: ");
        int m = scanner.nextInt();
        int[] worker = new int[m];

        System.out.println("Enter worker abilities:");
        for (int i = 0; i < m; i++) {
            worker[i] = scanner.nextInt();
        }

        MostProfitAssigningWork solution = new MostProfitAssigningWork();
        int result = solution.maxProfitAssignment(difficulty, profit, worker);

        System.out.println("Maximum Profit: " + result);

        scanner.close();
    }
}
