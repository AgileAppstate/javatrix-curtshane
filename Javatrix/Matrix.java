/**
 * The Matrix class does matrix calculations.
 *
 * @author Curt Bridgers
 * @author Shane McCann
 * @version 2021.09.27
 */
public class Matrix
{
    private double[][] matrix;
    private int columnDimension;
    private int rowDimension;
    
    public Matrix(double[][] a)
    {
        matrix = a;
        columnDimension = matrix[0].length;
        rowDimension = matrix.length;
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

    public double[][] getArray()
    {
        return matrix;
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
