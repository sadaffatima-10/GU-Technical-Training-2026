import java.util.Scanner;

public class Searc2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        
        int rows = matrix.length, cols = matrix[0].length;
        int left = 0, right = rows * cols - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = matrix[mid / cols][mid % cols];

            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take matrix dimensions input
        System.out.print("Enter number of rows: ");
        int m = scanner.nextInt();
        System.out.print("Enter number of columns: ");
        int n = scanner.nextInt();

        int[][] matrix = new int[m][n];
        System.out.println("Enter matrix elements row-wise:");

        // Take matrix input
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        // Take target input
        System.out.print("Enter target element: ");
        int target = scanner.nextInt();

        // Create an instance of Solution and call searchMatrix
        Searc2DMatrix solution = new Searc2DMatrix();
        boolean result = solution.searchMatrix(matrix, target);

        // Output the result
        if (result) {
            System.out.println("Target found in matrix!");
        } else {
            System.out.println("Target not found in matrix.");
        }

        scanner.close();
    }
}
