package functionTest;


import function.Function;
import org.junit.Test;
import static org.junit.Assert.*;

public class FunctionTest {
    final Double EPS = 0.1;

    @Test
    public void countTest0(){
        double x = 0;
        double sub = Math.abs(Math.tan(x)-Function.count(x));
        assertEquals(sub<EPS, true);
    }

    @Test
    public void countTestPI4() {
        double x = Math.PI/4;
        double sub = Math.abs(Math.tan(x)- Function.count(x));
        assertEquals(sub < EPS, true);
    }

    @Test
    public void countTestPI6(){
        double x = Math.PI/6;
        double sub = Math.abs(Math.tan(x)-Function.count(x));
        assertEquals(sub<EPS, true);
    }

    @Test
    public void countTestPI3() {
        double x = Math.PI/3;
        double sub = Math.abs(Math.tan(x)-Function.count(x));
        assertEquals(sub<EPS, true);
    }

    @Test
    public void countTestPI2() {
        double x = Math.PI/2;
        double sub = Math.abs(Math.tan(x)-Function.count(x));
        assertEquals(sub<EPS, true);
    }

    @Test
    public void countTestPI() {
        double x = Math.PI;
        double sub = Math.abs(Math.tan(x)-Function.count(x));
        assertEquals(sub<EPS, true);
    }
    @Test
    public void countTest3PI2() {
        double x = (3*Math.PI)/2;
        double sub = Math.abs(Math.tan(x)-Function.count(x));
        assertEquals(sub<EPS, true);
    }
    @Test
    public void countTest2PI() {
        double x = 2*Math.PI;
        double sub = Math.abs(Math.tan(x)-Function.count(x));
        assertEquals(sub<EPS, true);
    }
}

