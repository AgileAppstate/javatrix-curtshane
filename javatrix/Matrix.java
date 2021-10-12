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
    /**
     * Constructs a new Matrix object.
     *
     * @param a matrix to construct
     */
    public Matrix(double[][] a)
    {
        matrix = a;
        columnDimension = matrix[0].length;
        rowDimension = matrix.length;
    }
    
    /**
     * Constructs a new Matrix object.
     *
     * @param m row dimension
     * @param n column dimension
     * @param s data constant
     */ 
    public Matrix(int m, int n, double s)
    {
        this.matrix = new double[m][n];
        for (int row = 0; row < m; row++)
        {
            for (int col = 0; col < n; col++)
            {
                this.matrix[row][col] = s;
            }
        }
        columnDimension = matrix[0].length;
        rowDimension = matrix.length;
    }

    // Methods
    /**
     * Get the matrix as a 2D array.
     *
     * @return matrix
     */
    public double[][] getArray()
    {
        return this.matrix;
    }
    
    /**
     * Prints the matrix.
     *
     * @param w column width
     * @param d decimal places
     */
    public void print(int w, int d)
    {
        String fStr = String.format("%%%d.%df  ", w, d);
        for (int row = 0; row < matrix.length; row++)
        {
            System.out.printf("[ ");
            for (int col = 0; col < matrix[row].length; col++)
            {
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
    
    /**
     * Matrix transpose.
     *
     * @return A'
     */
    public Matrix transpose()
    {
        double[][] t = new double[columnDimension][rowDimension];
        for (int row = 0; row < rowDimension; row++)
        {
            for (int col = 0; col < columnDimension; col++)
            {
                t[col][row] = matrix[row][col];
            }
        }
        return new Matrix(t);
    }

    /**
     * Multiply a matrix by a scalar in place, A = s*A.
     *
     * @param s - scalar
     * @return replace A by s*A
     */
    public Matrix timesEquals(double s)
    {
        for (int row = 0; row < rowDimension; row++)
        {
            for (int col = 0; col < columnDimension; col++)
            {
                matrix[row][col] *= s;
            }
        }
        return this;
    }

    /**
     * Clones the matrix object by performing a shallow copy.
     *
     * @return A reference to this.Matrix.
     */
    @Override
    public Object clone()
    {
        return (Object) this;
    }
  
    /**
     * Returns a matrix that is the difference of this.Matrix and
     * the given Matrix argument.
     *
     * @param B - The subtraction operand matrix.
     * @exception IllegalArgumentException if operand matrices' dimensions don't match.
     * @exception NullPointerException if B is null.
     * @return A new matrix that is the result of this.Matrix - B.
     */
    public Matrix minus(Matrix B)
    {
        if (B.rowDimension != this.rowDimension ||
            B.columnDimension != this.columnDimension)
        {
            throw new IllegalArgumentException("Operand matrices are not of the same dimensions.");
        }
        if (B == null)
        {
            throw new NullPointerException("Null operand was passed.");
        }
      
        double[][] resultArr = new double[rowDimension][columnDimension];
        for (int row = 0; row < rowDimension; row++)
        {
            for (int col = 0; col < columnDimension; col++)
            {
                resultArr[row][col] = matrix[row][col] - B.matrix[row][col];
            }
        }
        return new Matrix(resultArr);
    }
  
     /**
     * Returns a matrix that is the sum of this.Matrix and
     * the given Matrix argument.
     *
     * @param B - The summation operand matrix.
     * @exception IllegalArgumentException if operand matrices' dimensions don't match.
     * @exception NullPointerException if B is null.
     * @return A new matrix that is the result of this.Matrix + B.
     */
    public Matrix plus(Matrix B)
    {
        if (B.rowDimension != this.rowDimension ||
            B.columnDimension != this.columnDimension)
        {
           throw new IllegalArgumentException("Operand matrices are not of the same dimensions.");
        }
        if (B == null)
        {
           throw new NullPointerException("Null operand was passed.");
        }

        double[][] resultArr = new double[rowDimension][columnDimension];
        for (int row = 0; row < rowDimension; row++)
        {
            for (int col = 0; col < columnDimension; col++)
            {
                resultArr[row][col] = matrix[row][col] + B.matrix[row][col];
            }
        }
        return new Matrix(resultArr);
    }

    /**
     * Performs an in-place matrix subtraction;
     * This.matrix is modified by this method.
     *
     * @param B - The subtraction operand matrix.
     * @exception IllegalArgumentException if operand matrices' dimensions don't match.
     * @exception NullPointerException if B is null.
     * @return A new matrix that is the result of this.Matrix - B.
     */
    public Matrix minusEquals(Matrix B)
    {
        if (B.rowDimension != this.rowDimension ||
            B.columnDimension != this.columnDimension)
        {
            throw new IllegalArgumentException("Operand matrices are not of the same dimensions.");
        }
        if (B == null)
        {
            throw new NullPointerException("Null operand was passed.");
        }

        for (int row = 0; row < rowDimension; row++)
        {
            for (int col = 0; col < columnDimension; col++)
            {
                matrix[row][col] -= B.matrix[row][col];
              }
        }
        return new Matrix(matrix);
    }
  
     /**
     * Performs an in-place matrix summation;
     * This.matrix is modified by this method.
     *
     * @param B - The summation operand matrix.
     * @exception IllegalArgumentException if operand matrices' dimensions don't match.
     * @exception NullPointerException if B is null.
     * @return A new matrix that is the result of this.Matrix + B.
     */
    public Matrix plusEquals(Matrix B)
    {
        if (B.rowDimension != this.rowDimension ||
            B.columnDimension != this.columnDimension)
        {
           throw new IllegalArgumentException("Operand matrices are not of the same dimensions.");
        }
        if (B == null)
        {
           throw new NullPointerException("Null operand was passed.");
        }

        for (int row = 0; row < rowDimension; row++)
        {
            for (int col = 0; col < columnDimension; col++)
            {
                matrix[row][col] += B.matrix[row][col];
            }
        }
        return new Matrix(matrix);
    }

    /**
     * Get the column dimension.
     *
     * @return column dimension
     */
    public int getColumnDimension()
    {
        return columnDimension;
    }

    /**
     * Get the row dimension.
     *
     * @return row dimension
     */
    public int getRowDimension()
    {
        return rowDimension;
    }
}
