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
}
