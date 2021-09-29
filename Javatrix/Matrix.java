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
    private double[][] matrix;
    private int columnDimension;
    private int rowDimension;
    
    public Matrix(double[][] A)
    {
        matrix = A;
    }
    
    public Matrix times(Matrix B)
    {
        double[][] C = new double[B.getRowDimension()][columnDimension];

        if (columnDimension == B.getRowDimension())
        {
            for (int i = 0; i < columnDimension; i++)
            {
                for (int j = 0; j < B.getRowDimension(); j++)
                {
                    C[i][j] += matrix[i][j] * B.getArray()[i][j];
                }
            }
            return new Matrix(C, B.getRowDimension(), columnDimension);
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
