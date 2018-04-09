package functionTest;

import function.Function;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class FunctionTest {
    final BigDecimal EPS = BigDecimal.valueOf(0.01);

    @Test
    public void testCount0() {
        double n = 0;
        BigDecimal sub = BigDecimal.valueOf(Math.tan(n)).subtract(Function.count(n));
        assertTrue(sub.abs().compareTo(EPS) == -1);
    }

    @Test
    public void testCountPi6() {
        double pi = Math.PI / 6;
        BigDecimal sub = BigDecimal.valueOf(Math.tan(pi)).subtract(Function.count(pi));
        assertTrue(sub.abs().compareTo(EPS) == -1);
    }

    @Test
    public void testCountPi3() {
        double pi = Math.PI / 3;
        BigDecimal sub = BigDecimal.valueOf(Math.tan(pi)).subtract(Function.count(pi));
        assertTrue(sub.abs().compareTo(EPS) == -1);
    }

    @Test
    public void testCountPi2() {
        double pi = Math.PI / 2 - 0.5;
        BigDecimal sub = BigDecimal.valueOf(Math.tan(pi)).subtract(Function.count(pi));
        assertTrue(sub.abs().compareTo(EPS) == -1);
    }

    @Test
    public void testCountMin1() {
        double n = -1;
        BigDecimal sub = BigDecimal.valueOf(Math.tan(n)).subtract(Function.count(n));
        assertTrue(sub.abs().compareTo(EPS) == -1);
    }

    @Test
    public void testCount1() {
        double n = 1;
        BigDecimal sub = BigDecimal.valueOf(Math.tan(n)).subtract(Function.count(n));
        assertTrue(sub.abs().compareTo(EPS) == -1);
    }

    @Test
    public void testCountMinPi2() {
        double pi = -Math.PI / 2 + 0.5;
        BigDecimal sub = BigDecimal.valueOf(Math.tan(pi)).subtract(Function.count(pi));
        assertTrue(sub.abs().compareTo(EPS) == -1);
    }

    @Test
    public void testCountPi4() {
        double pi = Math.PI / 4;
        BigDecimal sub = BigDecimal.valueOf(Math.tan(pi)).subtract(Function.count(pi));
        assertTrue(sub.abs().compareTo(EPS) == -1);
    }

    @Test
    public void testCountMinPi4() {
        double pi = -Math.PI / 4;
        BigDecimal sub = BigDecimal.valueOf(Math.tan(pi)).subtract(Function.count(pi));
        assertTrue(sub.abs().compareTo(EPS) == -1);
    }

    @Test
    public void testCountMinPi6() {
        double pi = -Math.PI / 6;
        BigDecimal sub = BigDecimal.valueOf(Math.tan(pi)).subtract(Function.count(pi));
        assertTrue(sub.abs().compareTo(EPS) == -1);
    }

    @Test
    public void testCountMinPi3() {
        double pi = -Math.PI / 3;
        BigDecimal sub = BigDecimal.valueOf(Math.tan(pi)).subtract(Function.count(pi));
        assertTrue(sub.abs().compareTo(EPS) == -1);
    }

    //ряд тейлора лежит в дианазоне от -pi/2; pi/2

    @Test
    public void DopTest() {
        double pi = -Math.PI / 2;
        BigDecimal sub = BigDecimal.valueOf(Math.tan(pi)).subtract(Function.count(pi));
        assertTrue(sub.abs().compareTo(EPS) == 1);
    }
    @Test
    public void DopTest2() {
        double pi = Math.PI / 2;
        BigDecimal sub = BigDecimal.valueOf(Math.tan(pi)).subtract(Function.count(pi));
        assertTrue(sub.abs().compareTo(EPS) == 1);
    }

    @Test
    public void DopTest3() {
        double pi = Math.PI;
        BigDecimal sub = BigDecimal.valueOf(Math.tan(pi)).subtract(Function.count(pi));
        assertTrue(sub.abs().compareTo(EPS) == 1);
    }

    @Test
    public void DopTest4() {
        double pi = -Math.PI;
        BigDecimal sub = BigDecimal.valueOf(Math.tan(pi)).subtract(Function.count(pi));
        assertTrue(sub.abs().compareTo(EPS) == 1);
    }

    @Test
    public void DopTest5() {
        double pi = -2* Math.PI/3 ;
        BigDecimal sub = BigDecimal.valueOf(Math.tan(pi)).subtract(Function.count(pi));
        assertTrue(sub.abs().compareTo(EPS) == 1);
    }

    @Test
    public void DopTest6() {
        double pi = -2* Math.PI/4 ;
        BigDecimal sub = BigDecimal.valueOf(Math.tan(pi)).subtract(Function.count(pi));
        assertTrue(sub.abs().compareTo(EPS) == 1);
    }
}

