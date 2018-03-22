package function;

import java.math.BigInteger;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Vector;
import org.apache.commons.math3.fraction.BigFraction;

import static java.lang.Math.pow;

public class Function {

    public static void main(String[] args) {
        count(Math.PI);
    }
    public static double count(double value) {
        double result = 0.0;
        double prevRes = 0.0;
        final Double EPS = 0.1;
        int i = 1;
        do {
            prevRes = result;
            result += bernouilli(2*i) * pow(-4, i)*(1 - pow(4, i)) * pow(value, 2*i - 1) / factorial(2*i);
            i++;
        } while (Math.abs(result-prevRes) >= EPS);
        System.out.println("Result: " + result);
        return result;
    }

    static double bernouilli(int n) {
        double[] A = new double[n + 1];
        for (int m = 0; m <= n; m++) {
            A[m] = (1.0 / (m + 1));
            for (int j = m; j >= 1; j--)
                A[j - 1] = (A[j - 1] - (A[j])) * j;
        }
        return A[0];
    }


    public static long factorial(int i) {
        long fact = 1;
        if (i == 0) return 1;
        else {
            for (int n=1; n<=i; n++) {
                fact=fact*n;
            }
            return fact;
        }
    }

}