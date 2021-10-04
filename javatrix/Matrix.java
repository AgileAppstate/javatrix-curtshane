package javatrix;

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
    private int columnDimension;
    private int rowDimension;
    
    // Constructors
    public Matrix(double[][] A)
    {
        matrix = A;
        columnDimension = matrix[0].length;
        rowDimension = matrix.length;
    }
      
    public Matrix(int m, int n, double s) {
        this.matrix = new double[m][n];
        for (int row = 0; row < m; row++) {
           for (int col = 0; col < n; col++) {
              this.matrix[row][col] = s;
           }
        }
        columnDimension = matrix[0].length;
        rowDimension = matrix.length;
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
  
    /**
     * Performs matrix multiplication.
     *
     * @param b the matrix to multiply by
     * @return the product the matricies
     * @throws IllegalArgumentException inner dimensions of the matricies
     *                                  must be the same
     */
    public Matrix times(Matrix b) throws IllegalArgumentException
    {
        if (columnDimension == b.getRowDimension())
        {
            double[][] c = new double[rowDimension][b.getColumnDimension()];
            int sum = 0;

            for (int i = 0; i < rowDimension; i++)
            {
                for (int j = 0; j < b.getColumnDimension(); j++)
                {
                    for (int k = 0; k < columnDimension; k++)
                    {
                        sum += matrix[i][k] * b.getArray()[k][j];
                    }
                    c[i][j] = sum;
                    sum = 0;
                }
                
            }
            return new Matrix(c);
        }
        else
        {
            throw new IllegalArgumentException(
                "Matix inner dimensions must agree.");
        }
    }

    public int getColumnDimension()
    {
        return columnDimension;
    }

    public int getRowDimension()
    {
        return rowDimension;
    }
}
