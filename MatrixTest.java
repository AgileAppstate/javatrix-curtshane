/* 
 * JUnit5 test class
 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

import javatrix.Matrix;

public class MatrixTest {

   private Matrix matrix;

   private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
   private final PrintStream originalOut = System.out;

   @Test
   public void testConstructor1() {
      double[][] a = {{1., 2.5, 3.1415},{5.0, 16.3, 2.0},{1.0, 2.0, 3.0}};
      Matrix m = new Matrix(a);

      double[][] mMatrix = m.getArray();
      assertEquals(a, mMatrix);
   }

   @Test
   public void testConstructor2() {
      Matrix m = new Matrix(3, 2, 1.0);
      double[][] a = {{1.0, 1.0}, {1.0, 1.0}, {1.0, 1.0}};
   }

   @Test
   public void testGetArray() {
      double[][] a = {{1., 2.5, 3.1415},{5.0, 16.3, 2.0},{1.0, 2.0, 3.0}};
      Matrix m = new Matrix(a);

      double[][] mMatrix = m.getArray();
      assertEquals(a, mMatrix);
   }

   @Test
   public void testPrint() {
      System.setOut(new PrintStream(outContent));

      double[][] a = {
         {5.0, 5.0, 5.0},
         {5.0, 5.0, 5.0},
         {5.0, 5.0, 5.0}
      };
      Matrix m = new Matrix(a);
      m.print(5, 3);
      assertEquals("[ 5.000  5.000  5.000   ]\n[ 5.000  5.000  5.000   ]\n" + 
                   "[ 5.000  5.000  5.000   ]\n", outContent.toString());
   }
  
  @Test
    public void testTimes()
    {
        double[][] aVals = {{ 1, 2, 3 },
                            { 4, 5, 6 }};
        Matrix a = new Matrix(aVals);
        double[][] bVals = {{ 7 , 8  },
                            { 9 , 10 },
                            { 11, 12 }};
        Matrix b = new Matrix(bVals);
        double[][] expected = {{  58,  64 },
                               { 139, 154 }};
        double[][] actual = a.times(b).getArray();
        
        for (int i = 0; i < actual.length; i++)
        {
            for (int j = 0; j < actual[0].length; j++)
            {
                if (actual[i][j] != expected[i][j])
                {
                    fail("Indicies do not match!\n" +
                         "Expected[" + i + "][" + j + "]: " + expected[i][j] + "\n" +
                         "Actual[" + i + "][" + j + "]: " + actual[i][j] + "\n");
                }
            }
        }
    }

    @Test
    public void testTimesEquals()
    {
        double[][] aVals = {{ 1, 2, 3 },
                            { 4, 5, 6 }};
        Matrix a = new Matrix(aVals);
        
        double[][] expected = {{  5, 10, 15 },
                               { 20, 25, 30 }};
        double[][] actual = a.timesEquals(5).getArray();
        
        for (int i = 0; i < actual.length; i++)
        {
            for (int j = 0; j < actual[0].length; j++)
            {
                if (actual[i][j] != expected[i][j])
                {
                    fail("Indicies do not match!\n" +
                         "Expected[" + i + "][" + j + "]: " + expected[i][j] + "\n" +
                         "Actual[" + i + "][" + j + "]: " + actual[i][j] + "\n");
                }
            }
        }
    }

    @Test
    public void testTranspose()
    {
        double[][] aVals = {{ 1, 2, 3 },
                           { 4, 5, 6 }};
        Matrix a = new Matrix(aVals);
        
        double[][] expected = {{ 1, 4 },
                               { 2, 5 },
                               { 3, 6 }};
        double[][] actual = a.transpose().getArray();
        
        for (int i = 0; i < actual.length; i++)
        {
            for (int j = 0; i < actual[0].length; i++)
            {
                if (actual[i][j] != expected[i][j])
                {
                    fail("Indicies do not match!\n" +
                         "Expected[" + i + "][" + j + "]: " + expected[i][j] + "\n" +
                         "Actual[" + i + "][" + j + "]: " + actual[i][j] + "\n");
                }
            }
        }
    }

    @Test
    public void testClone()
    {
        double[][] aVals = {{1,2,3,4}
                           ,{5,6,7,8}};
        Matrix a = new Matrix(aVals);

        assertEquals(a, a.clone());
    }
  
    public void testMinus1()
    {
        int rows = 3;
        int cols = 5;
        double[][] aArr = new double[rows][cols];
        double[][] bArr = new double[rows][cols];
        double[][] cArr = new double[rows][cols];

        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                aArr[i][j] = 1;
                bArr[i][j] = 1;
                cArr[i][j] = 0;
            }
        }

        Matrix a = new Matrix(aArr);
        Matrix b = new Matrix(bArr);
        Matrix c = a.minus(b);
  
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                assertEquals(c.getArray()[i][j], cArr[i][j]);
            }
        }
    }

    @Test
    public void testMinus2()
    {
        double[][] aArr = new double[3][5];
        double[][] bArr = new double[3][6];

        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 5; j++)
            {
               aArr[i][j] = 1;
            }
        }

        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 6; j++)
            {
               bArr[i][j] = 1;
            }
        }

        Matrix a = new Matrix(aArr);
        Matrix b = new Matrix(bArr);
        assertThrows(IllegalArgumentException.class, ()->{a.minus(b);});
    }

    @Test
    public void testMinus3()
    {
        double[][] aArr = new double[3][5];

        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 5; j++)
            {
               aArr[i][j] = 1;
            }
        }

        Matrix a = new Matrix(aArr);
        Matrix b = null;
        assertThrows(NullPointerException.class, ()->{a.minus(b);});
    }

    @Test
    public void testMinusEquals1()
    {
        int rows = 3;
        int cols = 5;
        double[][] aArr = new double[rows][cols];
        double[][] bArr = new double[rows][cols];
        double[][] cArr = new double[rows][cols];

        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                aArr[i][j] = 1;
                bArr[i][j] = 1;
                cArr[i][j] = 0;
            }
        }

        Matrix a = new Matrix(aArr);
        Matrix b = new Matrix(bArr);
        Matrix c = a.minusEquals(b);
        
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                assertEquals(c.getArray()[i][j], cArr[i][j]);
                assertEquals(a.getArray()[i][j], cArr[i][j]);
            }
        }
    }

    @Test
    public void testMinusEquals2()
    {
        double[][] aArr = new double[3][5];
        double[][] bArr = new double[3][6];

        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 5; j++)
            {
               aArr[i][j] = 1;
            }
        }

        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 6; j++)
            {
               bArr[i][j] = 1;
            }
        }

        Matrix a = new Matrix(aArr);
        Matrix b = new Matrix(bArr);
        assertThrows(IllegalArgumentException.class, ()->{a.minusEquals(b);});
    }

    @Test
    public void testMinusEquals3()
    {
        double[][] aArr = new double[3][5];

        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 5; j++)
            {
               aArr[i][j] = 1;
            }
        }

        Matrix a = new Matrix(aArr);
        Matrix b = null;
        assertThrows(NullPointerException.class, ()->{a.minusEquals(b);});
    }
    
    public void testPlus1()
    {
        int rows = 3;
        int cols = 5;
        double[][] aArr = new double[rows][cols];
        double[][] bArr = new double[rows][cols];
        double[][] cArr = new double[rows][cols];

        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                aArr[i][j] = 1;
                bArr[i][j] = 1;
                cArr[i][j] = 2;
            }
        }

        Matrix a = new Matrix(aArr);
        Matrix b = new Matrix(bArr);
        Matrix c = a.plus(b);

        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                assertEquals(c.getArray()[i][j], cArr[i][j]);
            }
        }
    }
    
    public void testPlus2()
    {
        double[][] aArr = new double[3][5];
        double[][] bArr = new double[3][6];

        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 5; j++)
            {
               aArr[i][j] = 1;
            }
        }

        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 6; j++)
            {
               bArr[i][j] = 1;
            }
        }

        Matrix a = new Matrix(aArr);
        Matrix b = new Matrix(bArr);
        assertThrows(IllegalArgumentException.class, ()->{a.plus(b);});
    }

    @Test
    public void testPlus3()
    {
        double[][] aArr = new double[3][5];

        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 5; j++)
            {
               aArr[i][j] = 1;
            }
        }

        Matrix a = new Matrix(aArr);
        Matrix b = null;
        assertThrows(NullPointerException.class, ()->{a.plus(b);});
    }

    @Test
    public void testPlusEquals1()
    {
        int rows = 3;
        int cols = 5;
        double[][] aArr = new double[rows][cols];
        double[][] bArr = new double[rows][cols];
        double[][] cArr = new double[rows][cols];

        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                aArr[i][j] = 1;
                bArr[i][j] = 1;
                cArr[i][j] = 2;
            }
        }

        Matrix a = new Matrix(aArr);
        Matrix b = new Matrix(bArr);
        Matrix c = a.plusEquals(b);
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                assertEquals(c.getArray()[i][j], cArr[i][j]);
                assertEquals(a.getArray()[i][j], cArr[i][j]);
            }
        }
    }

    @Test
    public void testPlusEquals2()
    {
        double[][] aArr = new double[3][5];
        double[][] bArr = new double[3][6];

        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 5; j++)
            {
               aArr[i][j] = 1;
            }
        }

        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 6; j++)
            {
               bArr[i][j] = 1;
            }
        }

        Matrix a = new Matrix(aArr);
        Matrix b = new Matrix(bArr);
        assertThrows(IllegalArgumentException.class, ()->{a.plusEquals(b);});
    }

    @Test
    public void testPlusEquals3()
    {
        double[][] aArr = new double[3][5];

        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 5; j++)
            {
               aArr[i][j] = 1;
            }
        }

        Matrix a = new Matrix(aArr);
        Matrix b = null;
        assertThrows(NullPointerException.class, ()->{a.plusEquals(b);});
    }

    @Test
    public void testIdentity1()
    {
        double[][] expected = {{ 1, 0, 0 },
                               { 0, 1, 0 },
                               { 0, 0, 1 }};
        double[][] actual = Matrix.identity(3, 3).getArray();
        
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                assertEquals(expected[i][j], actual[i][j]);
            }
        }
    }

    @Test
    public void testIdentity2()
    {
        assertThrows(IllegalArgumentException.class, ()->{ Matrix.identity(2,3); });
    }
  
    public void testCopy()
    {
        Matrix a = new Matrix(3, 3, 5.0);
        Matrix b = a.copy();

        assertEquals(a.getRowDimension(), b.getRowDimension());
        assertEquals(a.getColumnDimension(), b.getColumnDimension());

        for (int i = 0; i < a.getRowDimension(); i++)
        {
            for (int j = 0; j < a.getColumnDimension(); j++)
            {
                assertEquals(a.getArray()[i][j], b.getArray()[i][j]);
            }
        }
    }
}
