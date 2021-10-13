import javatrix.Matrix;
import java.util.Scanner;

public class Testtrix {

   private Scanner scan;

   public Testtrix()
   {
       scan = new Scanner(System.in);
   }

   private void printMenu()
   {
       System.out.print("Welcome to the Matrix Testing Interface (MTI) v0.1\n\n");
       System.out.print("Listed below are your options; enter the corresponding number and press Enter to continue:\n");
       System.out.print("1) Matrix addition\n");
       System.out.print("2) Matrix subtraction\n");
       System.out.print("3) Matrix multiplication\n");
       System.out.print("4) Scalar matrix multiplication\n");
       System.out.print("5) Matrix transposition\n");
       System.out.print("6) Identity matrix\n\n");
   }

   private int getOperation()
   {
       int opcode;

       do {
          System.out.print("Enter a number (1-6) and press Enter: ");

          try
          {
              opcode = scan.nextInt();
          } 
          catch(Exception e)
          {
              System.out.println("That's not a number, please try again.");
              opcode = -1;
              scan.nextLine();
          }

          if ((opcode < 1 || opcode > 6) && opcode != -1)
          {
              System.out.println("That's not a valid operation, please try again.");
          }
       } while (opcode < 1 || opcode > 6);

       return opcode;
   }

   //NOTE: Only accepts numbers from 1 to 32.
   private int getUserInt()
   {
       int num;

       do {
          try
          {
              num = scan.nextInt();
          } 
          catch(Exception e)
          {
              System.out.println("That's not a number, please try again.");
              num = -1;
              scan.nextLine();
          }

          if (num < 1 && num != -1)
          {
              System.out.println("Invalid number... Please enter a number from 1 to 32.");
          }
       } while (num < 1);

       return num;
   }

   private double getUserDouble()
   {
       double num = 0;
       boolean isValid;

       do {
          isValid = true;
          try
          {
              num = scan.nextDouble();
          } 
          catch(Exception e)
          {
              System.out.println("That's not a number, please try again.");
              isValid = false;
              scan.nextLine();
          }
       } while (!isValid);

       return num;
   }

   private Matrix getUserMatrix()
   {
      double[][] nums;
      int numRows;
      int numCols;
      Matrix matrix;

      System.out.print("Enter the number of rows (1-32) for your matrix: ");
      numRows = getUserInt();

      System.out.print("Enter the number of columns (1-32) for your matrix: ");
      numCols = getUserInt();

      nums = new double[numRows][numCols];

      System.out.print("Enter the numbers of your matrix consecutively from left to right and top to bottom. Press Enter after each number.\n");
      System.out.print("Example:  [ 1 2 3 ]\n");
      System.out.print("          [ 4 5 6 ]\n\n");
      System.out.print("Input as: 1\n");
      System.out.print("          2\n");
      System.out.print("          3\n");
      System.out.print("          4\n");
      System.out.print("          5\n");
      System.out.print("          6\n\n");
      System.out.print("The program will print the resulting matrix after all of the number have been received.\n");
      System.out.print("Please begin entering numbers as above, each on a new line (pressing Enter after each number):\n");
      for (int i = 0; i < numRows; i++)
      {
          for (int j = 0; j < numCols; j++)
          {
              nums[i][j] = getUserDouble();
          }
      }

      matrix = new Matrix(nums);

      System.out.print("\nYour matrix:\n");
      matrix.print(5, 3);

      return matrix;
   }

   private void addition()
   {
       Matrix mA;
       Matrix mB;
       Matrix result;

       System.out.print("Creating your first matrix...\n");
       mA = getUserMatrix();

       System.out.print("\nCreating your second matrix...\n");
       mB = getUserMatrix();

       System.out.print("\nThe summation of the given matrices:\n");
       result = mA.plus(mB);
       result.print(5, 3);
   }

   private void subtraction()
   {
       Matrix mA;
       Matrix mB;
       Matrix result;

       System.out.print("Creating your first matrix...\n");
       mA = getUserMatrix();

       System.out.print("\nCreating your second matrix...\n");
       mB = getUserMatrix();

       System.out.print("\nThe difference of the given matrices:\n");
       result = mA.minus(mB);
       result.print(5, 3);
   }

   private void multiplication()
   {
       Matrix mA;
       Matrix mB;
       Matrix result;

       System.out.print("Creating your first matrix...\n");
       mA = getUserMatrix();

       System.out.print("\nCreating your second matrix...\n");
       mB = getUserMatrix();

       System.out.print("\nThe multiplication of the given matrices:\n");
       result = mA.times(mB);
       result.print(5, 3);
   }

   private void scalarMultiplication()
   {
       Matrix mA;
       double s;

       System.out.print("Creating your matrix...\n");
       mA = getUserMatrix();

       System.out.print("\nPlease enter a scalar number: ");
       s = getUserDouble();

       System.out.print("\nThe scalar multiplication of the given matrix and scalar:\n");
       mA.timesEquals(s);
       mA.print(5, 3);
   }

   private void transposition()
   {
       Matrix mA;
       Matrix result;

       System.out.print("Creating your matrix...\n");
       mA = getUserMatrix();

       System.out.print("\nThe transposed matrix:\n");
       result = mA.transpose();
       result.print(5, 3);
   }

   private void identity()
   {
      int numRows;
      int numCols;
      Matrix m;

      System.out.print("Enter the number of rows (1-32) for your matrix: ");
      numRows = getUserInt();

      System.out.print("Enter the number of columns (1-32) for your matrix: ");
      numCols = getUserInt();

      m = Matrix.identity(numRows, numCols);
      System.out.print("\nThe identity matrix:\n");
      m.print(1, 0);
   }

   public void run()
   {
      int opcode;

      printMenu();
      opcode = getOperation();
      switch (opcode)
      {
          case 1:
             addition();
             break;
          case 2:
             subtraction();
             break;
          case 3:
             multiplication();
             break;
          case 4:
             scalarMultiplication();
             break;
          case 5:
             transposition();
             break;
          case 6:
             identity();
             break;
          default:
             System.out.println("That's not an operation.");
             System.exit(1);
      }
   }

   public static void main(String[] args) {
      Testtrix tester = new Testtrix();
      tester.run();
   }
}
