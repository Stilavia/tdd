package org.stilavia.tdd;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.junit.Assert.*;

/**
 * Created by guillermoblascojimenez on 02/04/15.
 */
public class PowerSeriesTest {

    @Test
    public void trivial() {

        final Function<Integer, BigDecimal> a = new Function<Integer, BigDecimal>() {
            @Override
            public BigDecimal eval(Integer input) {
                return BigDecimal.ONE;
            }
        };

        PowerSeries powerSeries = new PowerSeries(a);

        int steps = 1000;
        BigDecimal e = powerSeries.eval(BigDecimal.ONE, steps);
        assertNotNull(e);
        assertTrue(e.subtract(BigDecimal.valueOf(steps)).abs().compareTo(BigDecimal.valueOf(0.00000000000000000000001)) < 0);
    }
    @Test
    public void trivial2() {

        final Function<Integer, BigDecimal> a = new Function<Integer, BigDecimal>() {
            @Override
            public BigDecimal eval(Integer input) {
                return BigDecimal.ZERO;
            }
        };

        PowerSeries powerSeries = new PowerSeries(a);

        int steps = 1000;
        BigDecimal e = powerSeries.eval(BigDecimal.ONE, steps);
        assertNotNull(e);
        assertTrue(e.subtract(BigDecimal.ZERO).abs().compareTo(BigDecimal.valueOf(0.00000000000000000000001)) < 0);
    }

    @Test
    public void exp() {

        final Function<Integer, BigDecimal> a = new Function<Integer, BigDecimal>() {
            @Override
            public BigDecimal eval(Integer input) {
                if (input == 0) {
                    return BigDecimal.ONE;
                } else {
                    return BigDecimal.ONE.divide(new BigDecimal(factorial(BigInteger.valueOf(input))), 1000, BigDecimal.ROUND_CEILING);
                }
            }
        };

        PowerSeries powerSeries = new PowerSeries(a);

        BigDecimal e = powerSeries.eval(BigDecimal.ONE, 1000);
        assertNotNull(e);
        assertTrue(e.setScale(15, BigDecimal.ROUND_CEILING).subtract(BigDecimal.valueOf(Math.E)).abs().compareTo(BigDecimal.valueOf(0.00000000001)) < 0);
    }


    public static BigInteger factorial(BigInteger n) {
        BigInteger result = BigInteger.ONE;

        while (!n.equals(BigInteger.ZERO)) {
            result = result.multiply(n);
            n = n.subtract(BigInteger.ONE);
        }

        return result;
    }
}