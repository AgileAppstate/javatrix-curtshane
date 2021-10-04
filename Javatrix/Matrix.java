package Javatrix;

/**
 * The Matrix class does matrix calculations.
 *
 * @author Curt Bridgers
 * @author Shane McCann
 * @version 2021.09.27
 */
public class Matrix
{
    // Fields
    private double[][] matrix;
    
    // Constructors
    public Matrix(double[][] A) {
        this.matrix = A;
    }

    public Matrix(int m, int n, double s) {
        this.matrix = new double[m][n];
        for (int row = 0; row < m; row++) {
           for (int col = 0; col < n; col++) {
              this.matrix[row][col] = s;
           }
        }
    }

    // Methods
    public double[][] getArray() {
      return this.matrix;
    }

    public void print(int w, int d) {
      String fStr = String.format("%%%d.%df  ", w, d);
      for (int row = 0; row < matrix.length; row++) {
         System.out.printf("[ ");
         for (int col = 0; col < matrix[row].length; col++) {
            System.out.printf(fStr, matrix[row][col]);
         }
         System.out.printf(" ]");
         System.out.println();
      }
    }

    public static void main(String[] args) {
        Matrix m = new Matrix(3,3,5);
        m.print(5, 3);
    }
}
