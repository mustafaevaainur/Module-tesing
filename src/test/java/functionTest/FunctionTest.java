package functionTest;


import function.Function;
import org.junit.Test;

import static org.junit.Assert.*;

public class FunctionTest {
    final Double EPS = 0.1;

    @Test
    public void countTest0() {
        double x = 0;
        double sub = Math.abs(Math.tan(x) - Function.count(x));
        assertEquals(sub < EPS, true);
    }

    @Test
    public void countTestPI4() {
        double x = Math.PI / 4;
        double sub = Math.abs(Math.tan(x) - Function.count(x));
        assertEquals(sub < EPS, true);
    }

    @Test
    public void countTestPI6() {
        double x = Math.PI / 6;
        double sub = Math.abs(Math.tan(x) - Function.count(x));
        assertEquals(sub < EPS, true);
    }

    @Test
    public void countTestPI3() {
        double x = Math.PI / 3;
        double sub = Math.abs(Math.tan(x) - Function.count(x));
        assertEquals(sub < EPS, true);
    }

    @Test
    public void countTestArctg() {
        double x = Math.atan(1);
        double sub = Math.abs(Math.tan(x) - Function.count(x));
        assertEquals(sub < EPS, true);
    }


    @Test
    public void countTest1() {
        double x = 1;
        double sub = Math.abs(Math.tan(x) - Function.count(x));
        assertEquals(sub < EPS, true);
    }

    @Test
    public void countTestMin1() {
        double x = -1;
        double sub = Math.abs(Math.tan(x) - Function.count(x));
        assertEquals(sub < EPS, true);
    }

    @Test
    public void countTest40() {
        double x = 0.00000001;
        double sub = Math.abs(Math.tan(x) - Function.count(x));
        assertEquals(sub < EPS, true);
    }

    @Test
    public void countTestABC() {
        char x = 'x';
        double sub = Math.abs(Math.tan(x) - Function.count(x));
        assertEquals(sub < EPS, false);
    }

}

