/* 
 * JUnit5 test class
 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

import Javatrix.Matrix;

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
      Matrix.main(null);
      assertEquals("[ 5.000  5.000  5.000   ]\n[ 5.000  5.000  5.000   ]\n" + 
                   "[ 5.000  5.000  5.000   ]\n", outContent.toString());
   }
}
