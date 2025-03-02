import java.util.Scanner;

public class CountNegetives {
    public int countNegatives(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0; 

        int rows = grid.length, cols = grid[0].length; 
        int res = 0, lastNeg = cols - 1;
        
        for (int row = 0; row < rows; row++) {
            System.out.println("Processing row: " + row);

            if (grid[row][0] < 0) {
                res += cols;
                System.out.println("All elements in row " + row + " are negative. Total count: " + res);
                continue;
            }

            if (grid[row][cols - 1] > 0) {
                System.out.println("No negative numbers in row " + row);
                continue;
            }

            int l = 0, r = lastNeg;
            while (l <= r) {
                int m = l + (r - l) / 2;
                if (grid[row][m] < 0) {
                    r = m - 1;
                } else {
                    l = m + 1; 
                }
            }

            int negativeCount = cols - l;
            res += negativeCount; 
            lastNeg = l;

            System.out.println("Row " + row + " has " + negativeCount + " negative numbers. Total count: " + res);
        }
        
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        int cols = scanner.nextInt();

        int[][] grid = new int[rows][cols];

        System.out.println("Enter the elements of the matrix row-wise (sorted in non-increasing order per row):");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }

        CountNegetives solution = new CountNegetives();
        int result = solution.countNegatives(grid);

        System.out.println("Total count of negative numbers: " + result);

        scanner.close();
    }
}
