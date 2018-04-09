package function;

import java.math.BigDecimal;

public class Function {

    private final static BigDecimal EPS = new BigDecimal(0.01);
    private final static int factorialLimit = 30;
    private final static int scaling = 30;



    public static BigDecimal count(double value) {
        BigDecimal result = new BigDecimal(0.0);
        BigDecimal prevRes;
        BigDecimal newValue = new BigDecimal(value);
        int i = 1;
        do {
            prevRes = result;
            result = result.add(taylorTerm(newValue, i));
            i++;
        } while (result.subtract(prevRes).abs().compareTo(EPS) > 0 && i <= factorialLimit);
        return result;
    }

    public static BigDecimal taylorTerm(BigDecimal value, int i) {
        BigDecimal first =
                (new BigDecimal(-4).pow(i))
                        .multiply((new BigDecimal(1))
                                .subtract(new BigDecimal(4).pow(i)));
        BigDecimal second = value.pow(2 * i - 1);
        return first
                .multiply(second)
                .multiply(bernoulli(2 * i))
                .divide(factorial(2 * i), scaling, BigDecimal.ROUND_CEILING);
    }

    public static BigDecimal bernoulli(int n) {
        BigDecimal[] buffer = new BigDecimal[n + 1];
        for (int m = 0; m <= n; m++) {
            buffer[m] = (new BigDecimal(1)).divide(new BigDecimal(m + 1), scaling, BigDecimal.ROUND_CEILING);
            for (int j = m; j >= 1; j--)
                buffer[j - 1] = (buffer[j - 1].subtract(buffer[j])).multiply(new BigDecimal(j));
        }
        return buffer[0];
    }

    public static BigDecimal factorial(int i) {
        BigDecimal fact = new BigDecimal(1);
        if (i == 0) return fact;
        else {
            for (int n = 1; n <= i; n++) {
                fact = fact.multiply(new BigDecimal(n));
            }
            return fact;
        }
    }
}