import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class MatrixTest
{
    private Matrix A;

    @BeforeEach
    public void setUp()
    {
        double[][] vals = {{ 1, 2, 3 },
                           { 4, 5, 6 }};
        A = new Matrix(vals);
    }

    @Test
    public void testTimes()
    {
        double[][] vals = {{ 7 , 8  },
                           { 9 , 10 },
                           { 11, 12 },
                           { 13, 14 }};
        Matrix B = new Matrix(vals);

    }
}

