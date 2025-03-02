import java.util.Scanner;

public class KokoEatingBanana {
    public boolean perHour(int[] piles, int h, int k) {
        int reqHour = 0;
        for (int pile : piles) {
            reqHour += (int) Math.ceil((double) pile / k);
        }
        return reqHour <= h;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int min = 1, max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        int result = max;
        while (min <= max) {
            int k = min + (max - min) / 2;
            if (perHour(piles, h, k)) {
                result = k;
                max = k - 1;
            } else {
                min = k + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of piles: ");
        int n = scanner.nextInt();
        int[] piles = new int[n];

        System.out.println("Enter pile sizes:");
        for (int i = 0; i < n; i++) {
            piles[i] = scanner.nextInt();
        }

        System.out.print("Enter hours available: ");
        int h = scanner.nextInt();

        KokoEatingBanana solution = new KokoEatingBanana();
        int minSpeed = solution.minEatingSpeed(piles, h);

        System.out.println("Minimum eating speed: " + minSpeed);
        scanner.close();
    }
}
