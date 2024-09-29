import java.util.Scanner;

public class Matrix {
    private int[][] data;
    private int rows;
    private int cols;

    //Constructor
    public Matrix(int start_rows, int start_cols) {
        rows = start_rows;
        cols = start_cols;
        data = new int[rows][cols];
    }
    
    public void inputMatrix(Scanner scanner) {
        System.out.println("Enter elements for matrix");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                data[i][j] = scanner.nextInt();
            }
        }
    }
    public void printMatrix() {
        for (int i = 0; i < rows; i++) {
            for ( int j = 0; j < cols; j++) {
                System.out.print(data[i][j] + "\s");
            }
            System.out.println();
    }
}
    public Matrix add(Matrix otherMatrix) {
        Matrix result = new Matrix(rows,cols);
        for (int i = 0; i < rows; i++) {
            for ( int j = 0; j < cols; j++) {
                result.data[i][j] = data[i][j] + otherMatrix.data[i][j];
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of cols: ");
        int cols = scanner.nextInt();

        Matrix matrixA = new Matrix(rows, cols);
        Matrix matrixB = new Matrix(rows, cols);

        matrixA.inputMatrix(scanner);
        matrixB.inputMatrix(scanner);

        Matrix sumMatrix = matrixA.add(matrixB);
        
        System.out.println("Sum of Matrix A and Matrix B:");
        sumMatrix.printMatrix();

        scanner.close();
    }
}
