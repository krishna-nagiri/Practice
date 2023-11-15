import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows and columns for the first Matrix:");
        int m0 = sc.nextInt();
        int n0 = sc.nextInt();
        System.out.println("Enter the elements into Matrix1:");
        int[][] Matrix1 = inputMatrix(m0, n0, sc);

        System.out.println("Enter the number of rows and columns for the second Matrix:");
        int m1 = sc.nextInt();
        int n1 = sc.nextInt();
        System.out.println("Enter the elements into Matrix2:");
        int[][] Matrix2 = inputMatrix(m1, n1, sc);
        System.out.println("Enter your choice of operation 1.Addition \n 2.Multiplication: ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("You've chosen to add matrices.");
                if (m0 == m1 && n0 == n1) {
                    int[][] AnsMatrix = addMatrices(Matrix1, Matrix2);
                    System.out.println("Resultant Matrix (Matrix1 + Matrix2):");
                    printMatrix(AnsMatrix);
                } else {
                    System.out.println("Matrices cannot be added. Invalid dimensions.");
                }
                break;
            case 2:
                System.out.println("You've chosen to Multiply the matrices.");
                if (m0 == n1) {
                    int[][] MultiMatrix = multiplyMatrices(Matrix1, Matrix2);
                    System.out.println("Resultant Matrix (Matrix1 X Matrix2) is : ");
                    printMatrix(MultiMatrix);
                } else {
                    System.out.println("Matrix Multiplication is not possible.");
                }

            default:
                break;
        }

        sc.close();

        System.out.println("Matrix 1:");
        printMatrix(Matrix1);

        System.out.println("Matrix 2:");
        printMatrix(Matrix2);

    }

    // Function to input a matrix
    public static int[][] inputMatrix(int m, int n, Scanner sc) {
        int[][] matrix = new int[m][n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        return matrix;
    }

    // Function to print a matrix
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
    }

    // Function to add two matrices
    public static int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
        int m = matrix1.length;
        int n = matrix1[0].length;
        int[][] result = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        return result;
    }

    // Function to Multiply the matrix.
    public static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        int m0 = matrix1.length;
        int n0 = matrix1[0].length;
        int m1 = matrix2.length;
        int n1 = matrix2[0].length;

        int[][] result = new int[m0][n1];

        for (int i = 0; i < m0; i++) {
            for (int j = 0; j < n1; j++) {
                for (int k = 0; k < n0; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return result;
    }

}
