/* 
 * JUnit5 test class
 */

import static org.junit.jupiter.api.Assertions.assertEquals;
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
}
