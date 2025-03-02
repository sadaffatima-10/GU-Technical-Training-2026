import java.util.Scanner;

public class Search2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int rows = matrix.length, cols = matrix[0].length;
        int row = 0, col = cols - 1;

        while (row < rows && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                col--; 
            } else {
                row++; 
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
        Search2DMatrixII solution = new Search2DMatrixII();
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
