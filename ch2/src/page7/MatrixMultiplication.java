package page7;
public class MatrixMultiplication {

    public static double[][] matrixMultiplication(double[][] A, double[][] B) {
        int n = A.length;
        double[][] C = new double[n][n];

        // 初始化结果矩阵 C，所有元素都设置为 0.0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = 0.0;
            }
        }

        // 迭代遍历进行矩阵乘法
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    // 更新结果矩阵 C 中位置 (i, j) 的元素
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        // 返回结果矩阵 C
        return C;
    }

    public static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // 示例用法
        double[][] A = {{1, 2}, {3, 4}};
        double[][] B = {{5, 6}, {7, 8}};

        System.out.println("矩阵 A:");
        printMatrix(A);

        System.out.println("\n矩阵 B:");
        printMatrix(B);

        double[][] result = matrixMultiplication(A, B);

        System.out.println("\n矩阵乘法结果 C:");
        printMatrix(result);
    }
}
