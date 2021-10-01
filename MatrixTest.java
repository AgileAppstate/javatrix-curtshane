
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MatrixTest
{
    private Matrix a;

    @BeforeEach
    public void setUp()
    {
        double[][] vals = {{ 1, 2, 3 },
                           { 4, 5, 6 }};
        a = new Matrix(vals);
    }

    @Test
    public void testTimes()
    {
        double[][] vals = {{ 7 , 8  },
                           { 9 , 10 },
                           { 11, 12 }};
        Matrix b = new Matrix(vals);
        double[][] expected = {{  58,  64 },
                               { 139, 154 }};
        double[][] actual = a.times(b).getArray();
        
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

